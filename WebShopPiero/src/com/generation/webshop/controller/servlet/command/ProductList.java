package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;

public class ProductList extends WebCommand
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("products", shop.products());
		
		request.getRequestDispatcher(MAINPAGE).forward(request, response);		
	}

	@Override
	protected int getLevel() 
	{
		return 0;
	}

}