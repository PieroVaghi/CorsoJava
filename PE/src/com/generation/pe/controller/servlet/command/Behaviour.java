package com.generation.pe.controller.servlet.command;
import java.util.HashMap;
import java.util.Map;

public class Behaviour 
{
	
	
	private static final WebCommand NOTFOUND = new NotFound();
	
	Map<String,WebCommand> behaviour = new HashMap<String,WebCommand>();
	
	public Behaviour(String[] labels, WebCommand[] commands)
	{
		for(int i=0;i<labels.length;i++)
			behaviour.put(labels[i], commands[i]);
	}
	
	public WebCommand get(String cmd)
	{
		if(cmd==null) cmd="formlogin";
		return behaviour.containsKey(cmd) ? behaviour.get(cmd) : NOTFOUND;
	}
	
}