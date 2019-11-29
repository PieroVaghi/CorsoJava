package com.generation.common.model.log;

public class Event 
{
	long time;
	String content;
	
	public Event(long time, String content)
	{
		super();
		this.time = time;
		this.content = content;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}