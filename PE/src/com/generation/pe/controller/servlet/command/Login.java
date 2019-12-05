package com.generation.pe.controller.servlet.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.pe.model.entities.User;


public class Login extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//Questi dati sono parametri e arrivano dalla form
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = pebl.login(email,password);
	
		if(user!=null)
		{
			//Login ha avuto successo
			//aggiorno la session
			request.getSession().setAttribute("user", user);
			request.setAttribute("iduser", "0");
			if(user.getLevel()==2) 
				WebCommand.loadCommand("listprofile").run(request, response);
			else
				WebCommand.loadCommand("ownprofile").run(request, response);
		}
		else
		{
			request.setAttribute("errormessage", "BAD LOGIN");
			request.getRequestDispatcher("formlogin.jsp").forward(request, response);					
		}
		
	}
	
	@Override
	protected int getLevel() 
	{
		return 0;
	}

}