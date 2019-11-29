package com.generation.common.controller.command;

public abstract class BehaviourFactory 
{
	// Il prodotto di questa factory è un Behaviour
	// vale a dire un aggregatore di Command
	public static Behaviour make(String[] commands, Command[] actions)
	{
		return new Behaviour(commands, actions);
	}
	
}