package com.generation.persondrama.controller.command;

import com.generation.common.model.dao.deprecated.EntityDAO;
import com.generation.persondrama.controller.context.Context;

public class List extends PersonDramaCommand
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

	