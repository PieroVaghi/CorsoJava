package com.generation.pe.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OwnProfile extends WebCommand
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("user", pebl.load(user.getId()));
		int iduseranalized;
		try
		{
			iduseranalized = Integer.parseInt((String) request.getParameter("iduser"));
		}
		catch(Exception e)
		
		{
			request.setAttribute("error", "Invalid expense id");
			WebCommand.loadCommand("badrequest").run(request, response);
			return;
		}
		if(iduseranalized == 0)
			iduseranalized = user.getId();
		else
			iduseranalized = Integer.parseInt(request.getParameter("iduser"));
		
		request.setAttribute("useranalized", pebl.load(iduseranalized));
		request.getRequestDispatcher("ownprofile.jsp").forward(request, response);		
	}

	@Override
	protected int getLevel() 
	{
		return 0;
	}

}