package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;
import com.generation.webshop.model.entities.Review;

public class SaveReview extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Review review = new Review();
		review.setTitle(request.getParameter("title"));
		review.setContent((request.getParameter("content")));
		review.setStars(Integer.parseInt(request.getParameter("stars")));
		
//		String id =request.getParameter("productid");
		Product p = shop.load(Integer.parseInt(request.getParameter("productid")));
		Customer c;
		if(Integer.parseInt(request.getParameter("customerid"))==0)
			c = GUEST;
		else
			c = shop.loadCustomer(Integer.parseInt(request.getParameter("customerid")));
		
		review.setProduct(p);
		review.setCustomer(c);
		review = c.addReview(review);
		shop.save(p.addReview(review));
		
		
		
		request.setAttribute("product", shop.load(Integer.parseInt(request.getParameter("productid"))));
		WebCommand.loadCommand("productdetail").run(request, response);
		
	}

}