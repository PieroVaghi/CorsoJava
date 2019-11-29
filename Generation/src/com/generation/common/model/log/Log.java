package com.generation.common.model.log;

import java.util.ArrayList;
import java.util.List;

public class Log implements ILog
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


	@Override
	public List<Event> getEvents() 
	{
		return content;
	}
	
	
}