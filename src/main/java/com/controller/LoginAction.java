package com.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import com.service.LoginService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println(LocalDateTime.now()+" Login action called ... ");
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginService loginService = new LoginService();
		
		if(loginService.isValidUserAndPassword(uname, pass))
		{
//			RequestDispatcher rs = request.getRequestDispatcher("Dashboard");
//			rs.forward(request, response);
//			
			response.sendRedirect("Dashboard");	
		}	
		
		else
			request.getRequestDispatcher("ErrorPage").forward(request, response);
		
	}
}
