package com.generation.firefighter.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.firefighter.model.entities.Badge;
import com.generation.firefighter.model.entities.Fireman;


public class SaveBadge extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Badge badge = new Badge();
		badge.setTitle(request.getParameter("title"));
		badge.setRisklevel(Integer.parseInt(request.getParameter("risklevel")));
		
		Fireman f = fire.load(Integer.parseInt(request.getParameter("firemanid")));
		f.addBadge(badge);
		fire.save(f);
		//Torno alla pagina del prodotto con la recensione aggiunta
		request.setAttribute("fireman", f);
		request.getRequestDispatcher(FIREMANPAGE).forward(request, response);	
		
	}

}