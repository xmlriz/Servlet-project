package com.Dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ErrorPage")
public class ErrorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println("Error pages called");
		out.print("<body background = 'background.jpeg' > Error </body>");
		out.print("Invalid username password");
		out.print("Click <a href = 'http://localhost:8080/ServletClass2810/index.html' >here</a> to login again");
		
	}

}
