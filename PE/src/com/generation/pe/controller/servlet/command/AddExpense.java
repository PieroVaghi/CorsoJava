package com.generation.pe.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.pe.model.entities.Expense;
import com.generation.pe.model.entities.User;


public class AddExpense extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		
		Expense expense = new Expense();
		expense.fromMap(parametersToMap(request));
		expense.setDoe(stringToDate(request.getParameter("doe")));
		if(expense.valid())
		{		
			User u = pebl.load(user.getId());
			u.addExpens(expense);
			pebl.save(expense);
			request.getSession().setAttribute("user", pebl.save(u));
			request.setAttribute("iduser", "0");
			WebCommand.loadCommand("ownprofile").run(request, response);
		}
		else
		{
			request.setAttribute("error", "Invalid data for product. Check that price and quanties are positive or zero and provide all the fields");
			WebCommand.loadCommand("badrequest").run(request, response);
		}
		
							
	}

	@Override
	protected int getLevel() 
	{
		return 1;
	}

}