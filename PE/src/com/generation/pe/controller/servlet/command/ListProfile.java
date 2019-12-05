package com.generation.pe.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListProfile extends WebCommand
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("users", pebl.list());
		request.setAttribute("user", pebl.load(user.getId()));
		
		request.getRequestDispatcher("listprofile.jsp").forward(request, response);		
	}

	@Override
	protected int getLevel() 
	{
		return 0;
	}

}