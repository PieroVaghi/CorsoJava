package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;

public class FormNewProduct extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Customer user = (Customer) request.getSession().getAttribute("customer");
		if(user==null || user.getLevel()<2)
		{
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
			return;
		}
		else
		{
			request.setAttribute("loggedin", user);
			request.getRequestDispatcher("formnewproduct.jsp").forward(request, response);
		}
		
	}

}