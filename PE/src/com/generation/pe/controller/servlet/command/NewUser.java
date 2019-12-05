package com.generation.pe.controller.servlet.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.pe.model.entities.User;


public class NewUser extends WebCommand {
	
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
				
		
		User user = new User();
		Map<String,String> map = parametersToMap(request);
		
			
		user.fromMap(map);
		if(user.valid())
		{		
			pebl.save(user);
			WebCommand.loadCommand("listprofile").run(request, response);
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