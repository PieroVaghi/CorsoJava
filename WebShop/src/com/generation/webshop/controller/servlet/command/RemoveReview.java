package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Product;

public class RemoveReview extends WebCommand
{

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		Product p = shop.load(Integer.parseInt(request.getParameter("productid")));
		p.removeReview(shop.loadReview(Integer.parseInt(request.getParameter("reviewid"))));
		shop.deleteReview(Integer.parseInt(request.getParameter("reviewid")));
		
		shop.save(p);
		WebCommand.loadCommand("productdetail").run(request, response);
		
	}

}