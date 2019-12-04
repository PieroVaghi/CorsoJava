package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public class NewProduct extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		
		//Controllo di session
		if(user==null || user.getLevel()<2)
		{
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
			return;
		}
				
		
		Product product = new Product();
		product.fromMap(parametersToMap(request));
		if(product.valid())
		{		
			shop.save(product);
			WebCommand.loadCommand("").run(request, response);
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
		return 2;
	}

}