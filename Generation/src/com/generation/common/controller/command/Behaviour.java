package com.generation.common.controller.command;

import java.util.HashMap;
import java.util.Map;

public class Behaviour 
{
	protected Map<String,Command> behaviours = new HashMap<String,Command>();
	//uno zero logico
	private static Command nullCommand = new NullCommand();
	
	
	public Behaviour(String[] labels, Command[] commands)
	{
		for(int i=0;i<labels.length;i++)
			put(labels[i],commands[i]);
	}
	
	public Command get(String key)
	{
		return behaviours.get(key)==null ? nullCommand : behaviours.get(key);
	}
	
	public void put(String key, Command command)
	{
		behaviours.put(key,command);
	}
	
	
}