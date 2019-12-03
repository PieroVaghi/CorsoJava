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
		Customer user = (Customer) request.getSession().getAttribute("customer");
		if(user==null || user.getLevel()<2)
		{
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
			return;
		}
		
		Product product = new Product();
		product.setCategory(request.getParameter("category"));
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		shop.save(product);
		WebCommand.loadCommand("").run(request, response);
		
	}

}