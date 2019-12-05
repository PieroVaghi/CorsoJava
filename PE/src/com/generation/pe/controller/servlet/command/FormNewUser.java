package com.generation.pe.controller.servlet.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormNewUser extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		if(user==null || user.getLevel()<2)
		{
			System.out.println("forbidden!!!!");
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
			return;
		}
		else
		{
			request.setAttribute("loggedin", user);
			request.getRequestDispatcher("formnewuser.jsp").forward(request, response);
		}
		
	}

	@Override
	protected int getLevel() 
	{
		return 2;
	}
		
}