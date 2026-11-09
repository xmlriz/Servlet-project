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
		
	
		out.print("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<title>Dashboard</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n"
				+ "</head><br><br><hr>");
		
		
		int totalStudent = 0;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		(
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDrive","root","123@Javac");		
			PreparedStatement ps = con.prepareStatement("select count(*) from student");
			ResultSet rs = ps.executeQuery();
		)
		{	
			
			if(rs.next()) {
				totalStudent = rs.getInt(1);
				System.out.println("Total Rows: "+totalStudent);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
		
		
		
		out.print("<br><br> <span Align = 'right'>Add</span>");
		out.print("<br><br> <span Align = 'right'>Total students: "+totalStudent+"</span>");
		
		
		out.print("<table width = 95% border = '2' style = margin-left:30px;>"
				+ "<TR bgcolor = 'green'><th>sn</th><TH>sid</TH><TH>NAME</TH><TH>Email</TH><TH>cid</TH>"
				+ "<TH>Actions</TH>"
				+ "</TR>");
				
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlDrive","root","123@Javac");	
			System.out.println("Connection established "+con);
			
			PreparedStatement ps = con.prepareStatement("select sid,sname,semail,cid from student");
			
			ResultSet rs = ps.executeQuery();
			int i = 1;
			
			while(rs.next())
			{
				out.print("<tr><td>"+i+"</td>"
						+ "<td>"+rs.getString("sid")+"</td>"
								+ "<td>"+rs.getString("sname")+"</td>"
								+ "<td>"+rs.getString("semail")+"</td>"
								+ "<td>"+rs.getInt("cid")+"</td>"
								+ "<td> <a href = 'DeleteAction2?sid="+rs.getString("sid")+ "'> <i class=\"material-icons\">delete</i> </a> |<a href = '#'> Update </a> |<a href = '#'> view</a> </td>"
								+ "</tr>");
			i++;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}		
				
		out.print("</table>");
			
	}
}
