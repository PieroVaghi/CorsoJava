package com.generation.pe.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.pe.model.entities.User;


public class RemoveExpense extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		
		// HARDENING
		int idExpense;
		try
		{
			idExpense = Integer.parseInt(request.getParameter("expenseid"));
		}
		catch(Exception e)
		{
			request.setAttribute("error", "Invalid expense id");
			WebCommand.loadCommand("badrequest").run(request, response);
			return;
		}
		
		User u = pebl.load(user.getId());
		u.removeExpens(pebl.loadExpence(idExpense));
		pebl.save(u);
		pebl.delete(pebl.loadExpence(idExpense));
		request.getSession().setAttribute("user", u);
		request.setAttribute("iduser", "0");
		WebCommand.loadCommand("ownprofile").run(request, response);
		
	}

	@Override
	protected int getLevel() {
		return 1;
	}

}