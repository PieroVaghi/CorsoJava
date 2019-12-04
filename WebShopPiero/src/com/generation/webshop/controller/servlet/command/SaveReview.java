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
			
			
			Review review = new Review();
			review.fromMap(parametersToMap(request));
			if(review.valid())
			{		
				Product p = shop.load(idProduct);
				p.addReview(review);
				Customer c = shop.loadCustomer(user.getId());
				c.addReview(review);
				shop.save(p);
				shop.save(c);
				shop.save(review);
				WebCommand.loadCommand("productdetail").run(request, response);
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