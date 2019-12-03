package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getSession().setAttribute("customer", GUEST);
		WebCommand.loadCommand("").run(request, response);		
	}

}