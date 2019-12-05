package com.generation.pe.controller.servlet.command;

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
		request.getSession().setAttribute("user", GUEST);
		WebCommand.loadCommand("formlogin").run(request, response);		
	}

	@Override
	protected int getLevel() 
	{
		return 0;
	}

}