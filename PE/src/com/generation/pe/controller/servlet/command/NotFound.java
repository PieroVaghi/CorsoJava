package com.generation.pe.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFound extends WebCommand
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("notfound.jsp").forward(request, response);		
	}
	
	@Override
	protected int getLevel() 
	{
		return 0;
	}
}