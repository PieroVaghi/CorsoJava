package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public class DeleteProduct extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// HARDENING
		int id;
		try
		{
			id = Integer.parseInt(request.getParameter("productid"));
		}
		catch(Exception e)
		{
			request.setAttribute("error", "Invalid product id");
			WebCommand.loadCommand("badrequest").run(request, response);
			return;
		}
		
		shop.delete(shop.load(id));
		WebCommand.loadCommand("").run(request, response);
	}
	
	@Override
	protected int getLevel() 
	{
		return 2;
	}

}