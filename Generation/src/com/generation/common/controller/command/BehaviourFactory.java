package com.generation.common.controller.command;

public abstract class BehaviourFactory 
{

	public static Behaviour make(String[] commands, Command[] actions)
	{
		return new Behaviour(commands, actions);
	}
	
}