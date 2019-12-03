package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public class RemoveProduct extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
//		Product p = shop.load(Integer.parseInt(request.getParameter("productid")));
		shop.deleteProduct(Integer.parseInt(request.getParameter("productid")));
		Customer loggedIn = (Customer) request.getSession().getAttribute("customer");
		loggedIn = loggedIn!= null ? loggedIn : GUEST;
		
		//A QUESTA PAGINA PASSO LA LISTA DEI PRODOTTI, PRESA DA MODEL
		//E IL CUSTOMER, PRESO DA SESSION SE C'E'
		request.setAttribute("products", shop.products());
		request.setAttribute("loggedin", loggedIn);	
		request.getRequestDispatcher(MAINPAGE).forward(request, response);
		
	}

}