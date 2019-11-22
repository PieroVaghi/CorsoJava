package com.generation.megacorp.controller.command;

import com.generation.megacorp.controller.context.Context;
import com.generation.megacorp.model.entities.Employee;
import com.generation.megacorp.model.view.EmployeeView;

import generation.common.dao.EntityDAO;

public class List extends MegacorpCommand
{


	
	@Override
	public String execute() 
	{
		try
		{
			
			return view.render(dao.list());
		}
		catch(Exception e)
		{
			return e.getMessage();
		}	
	}

	
	
	

}
