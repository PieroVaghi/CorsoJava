package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public class DeleteReview extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		
		// HARDENING
		int idProduct;
		try
		{
			idProduct = Integer.parseInt(request.getParameter("productid"));
		}
		catch(Exception e)
		{
			request.setAttribute("error", "Invalid product id");
			WebCommand.loadCommand("badrequest").run(request, response);
			return;
		}
		int idReview;
		try
		{
			idReview = Integer.parseInt(request.getParameter("reviewid"));
		}
		catch(Exception e)
		{
			request.setAttribute("error", "Invalid review id");
			WebCommand.loadCommand("badrequest").run(request, response);
			return;
		}
		
		Product p = shop.load(idProduct);
		Customer c = shop.loadCustomer(user.getId());
		p.removeReview(shop.loadReview(idReview));
		c.removeReview(shop.loadReview(idReview));
		shop.delete(shop.loadReview(idReview));
		shop.save(c);
		shop.save(p);
		WebCommand.loadCommand("productdetail").run(request, response);
		
	}

	@Override
	protected int getLevel() {
		return 2;
	}

}