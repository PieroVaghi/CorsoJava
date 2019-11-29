package com.generation.common.model.log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LogDB implements ILog
{
	Connection connection;
	
	

	public LogDB(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public void addEvent(Event e) 
	{
		try
		{
			Statement command = connection.createStatement();
			command.execute("insert into log(time,content) values("+e.getTime()+",'"+e.getContent()+"')");
			command.close();
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
				
	}

	@Override
	public List<Event> getEvents() 
	{
		List<Event> res = new ArrayList<Event>();
		try
		{
			Statement command = connection.createStatement();
			ResultSet rs = command.executeQuery("select * from log");
			while(rs.next())
				res.add(new Event(rs.getLong("time"), rs.getString("content")));
			return res;
		}
		catch(Exception er)
		{
			er.printStackTrace();
			return null;
		}
		
	}

}