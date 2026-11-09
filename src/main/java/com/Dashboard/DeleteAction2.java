package com.Dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/DeleteAction2")
public class DeleteAction2 extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("sid");
		if(!sid.isBlank()) {
			
		System.out.print("sid : "+sid);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDrive","root","123@Javac");	
			System.out.println("Connection established "+con);
			
			PreparedStatement ps = con.prepareStatement("delete from student where sid = ?");
			ps.setString(1, sid);
			
			int row = ps.executeUpdate();
			System.out.println("Row Effected : "+row);
			
			if(row>0)
				request.getRequestDispatcher("Dashboard").forward(request, response);
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		}
		else
		{
			System.out.println("Sid is blank");
		}
		
		
	}
}
