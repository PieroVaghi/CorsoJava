package com.generation.common.model.log;

import java.util.ArrayList;
import java.util.List;

public class Log 
{
	List<Event> content = new ArrayList<Event>();

	private static Log instance = new Log();
	
	public static Log getInstance() {return instance;}
	
	
	private Log()
	{
	};
	
	public void addEvent(Event e)
	{
		content.add(e);
	}
	
	
}
