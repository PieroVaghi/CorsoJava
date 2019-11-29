package com.generation.common.model.log;

import java.sql.Connection;

public abstract class LogFactory 
{
	public static ILog make()
	{
		return	Log.getInstance();
		
	}
	
	public static ILog make(Connection connection)
	{
		return	new LogDB(connection);
	
	}
	
}