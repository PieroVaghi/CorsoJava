package com.generation.common.model.log;

import java.util.List;

public interface ILog 
{

	void addEvent(Event e);
	List<Event> getEvents();

	default void addEvent(String content)
	{
		addEvent(new Event(System.nanoTime(), content));
	}
	
}