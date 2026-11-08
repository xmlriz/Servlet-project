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


@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		doPost(request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("MainMenu").include(request, response);
		out.print("welcome mr: "+request.getParameter("uname"));
		
		out.print("<br><br><hr>");
		
		out.print("<br><br> <span Align = 'right'>Add</span>");
		
		out.print("<table width = 95% border = '2' Align = 'center'>"
				+ "<TR bgcolor = 'green'><TH>sid</TH><TH>NAME</TH><TH>Email</TH><TH>cid</TH>"
				+ "<TH>Actions</TH>"
				+ "</TR>");
				
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDrive","root","123@Javac");	
			System.out.println("Connection established "+con);
			
			PreparedStatement ps = con.prepareStatement("select sid,sname,semail,cid from student");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				out.print("<tr>"
						+ "<td>"+rs.getString("sid")+"</td>"
								+ "<td>"+rs.getString("sname")+"</td>"
								+ "<td>"+rs.getString("semail")+"</td>"
								+ "<td>"+rs.getInt("cid")+"</td>"
								+ "<td> <a href = '#'> Remove </a> |<a href = '#'> Update </a> |<a href = '#'> view</a> </td>"
								+ "</tr>");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}		
				
		out.print("</table>");
			
	}
}
