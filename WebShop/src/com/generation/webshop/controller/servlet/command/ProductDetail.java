package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;

public class ProductDetail extends WebCommand
{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Customer loggedIn = (Customer) request.getSession().getAttribute("customer");
		loggedIn = loggedIn!= null ? loggedIn : GUEST;
		request.setAttribute("loggedin", loggedIn);
		
		request.setAttribute("product", shop.load(Integer.parseInt(request.getParameter("productid"))));
		request.getRequestDispatcher(PRODUCTPAGE).forward(request, response);		
	}

}