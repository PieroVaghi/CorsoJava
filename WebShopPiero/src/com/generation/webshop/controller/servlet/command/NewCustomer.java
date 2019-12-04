package com.generation.webshop.controller.servlet.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public class NewCustomer extends WebCommand {
	
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
				
		
		Customer customer = new Customer();
		Map<String,String> map = parametersToMap(request);
		System.out.println(map);
		if(map.get("email").endsWith("@generation.com"))
			extracted(request, response);
		if(map.get("password").equals(map.get("checkpassword")))
			extracted(request, response);
			
		customer.fromMap(map);
		if(customer.valid())
		{		
			shop.save(customer);
			WebCommand.loadCommand("").run(request, response);
		}
		else
		{
			extracted(request, response);
		}
	}

	private void extracted(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("error", "Invalid data for product. Check that price and quanties are positive or zero and provide all the fields, the mail and the password");
		WebCommand.loadCommand("badrequest").run(request, response);
	}

	@Override
	protected int getLevel() 
	{
		return 2;
	}

}
