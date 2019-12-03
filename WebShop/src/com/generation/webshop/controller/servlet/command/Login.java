package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;

public class Login extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//Questi dati sono parametri e arrivano dalla form
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer user = shop.login(email,password);
	
		if(user!=null)
		{
			//Login ha avuto successo
			//aggiorno la session
			request.getSession().setAttribute("customer", user);
			WebCommand.loadCommand("").run(request, response);
		}
		else
		{
			request.setAttribute("errormessage", "BAD LOGIN");
			request.getRequestDispatcher("formlogin.jsp").forward(request, response);					
		}
		
	}

}