package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormNewCustomer extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		if(user==null || user.getLevel()<2)
		{
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
			return;
		}
		else
		{
			request.setAttribute("loggedin", user);
			request.getRequestDispatcher("formnewcustomer.jsp").forward(request, response);
		}
		
	}

	@Override
	protected int getLevel() 
	{
		return 2;
	}
		
}