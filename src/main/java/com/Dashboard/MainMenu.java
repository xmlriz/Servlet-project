package com.Dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/MainMenu")
public class MainMenu extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("&nbsp<a href='Dashboard'>Home<a>&nbsp&nbsp"
				+ "<a href = '#'>Services</a>&nbsp&nbsp"
				+ "<a href = '#'>About</a>"
				+ "&nbsp&nbsp"
				+ "<a href = '#'>Contact</a>&nbsp&nbsp"
				+ "<a href = 'Logout'>Logout</a>");
		
	}
}
