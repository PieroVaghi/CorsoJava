package com.generation.finalshop.controller.main;

import com.generation.common.controller.command.Behaviour;
import com.generation.finalshop.controller.context.Context;

public class Main {

	//DIPENDENZA
	static Behaviour behaviour = (Behaviour) Context.getInstance().get("behaviour");
	
	public static void main(String[] args) 
	{
		System.out.println(behaviour.get("login").run());
		while(true)
		{
			String cmd = behaviour.get("askcommand").run();
			System.out.println(behaviour.get(cmd).run());
		}
		
		
	}

}
