package com.generation.firefighter.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiremanDetail extends WebCommand
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("fireman", fire.load(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher(FIREMANPAGE).forward(request, response);		
	}

}