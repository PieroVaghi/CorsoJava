package com.generation.firefighter.controller.context;

import com.generation.firefighter.controller.servlet.command.Behaviour;
import com.generation.firefighter.controller.servlet.command.FiremanDetail;
import com.generation.firefighter.controller.servlet.command.FiremanList;
import com.generation.firefighter.controller.servlet.command.SaveBadge;
import com.generation.firefighter.controller.servlet.command.WebCommand;
import com.generation.firefighter.model.fireBL.FireJPA;

public class Context extends com.generation.common.controller.context.Context
{
	private static Context instance = new Context();
	
	public static Context getInstance() {return instance;}
	
	private Context()
	{
		put("fire", new FireJPA("Firefighter"));
		
		put
		(
				"behaviour", 
				new Behaviour
				(
						new String[] {"", "firemandetails","savebadge"}, 
						new WebCommand[] {new FiremanList(), new FiremanDetail(), new SaveBadge()}
				)
		);
	
	}
	
	
	
	
}