package com.generation.firefighter.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiremanList extends WebCommand
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("firemans", fire.firemans());
		request.getRequestDispatcher(MAINPAGE).forward(request, response);		
	}

}