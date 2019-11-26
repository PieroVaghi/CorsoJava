package com.generation.libraryjpa.controller.main;

import com.generation.libraryjpa.controller.context.Context;
import com.generation.common.controller.command.Behaviour;

public class Main 
{

	//DIPENDENZA
	static Behaviour behaviour = (Behaviour) Context.getInstance().get("behaviour");
	
	public static void main(String[] args) 
	{
		while(true)
		{
			String cmd = behaviour.get("askcommand").run();
			System.out.println(behaviour.get(cmd).run());
		}
		
		
	}

}
