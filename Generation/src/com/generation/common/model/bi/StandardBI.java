package com.generation.common.model.bi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Facade di JDBC a scopo BI

public class StandardBI implements BIFacade
{
	//Coprirò: Connection, Statement e ResultSet
	
	Connection connection;
	
	StandardBI(String dbPath) throws Exception
	{
		connection = DriverManager.getConnection(dbPath);
	}
	
	StandardBI(Connection connection) throws Exception
	{
		this.connection = connection;
	}

	
	
	@Override
	public List<Map<String, String>> rows(String sql) throws SQLException 
	{
		Statement command = connection.createStatement();
		ResultSet rs = command.executeQuery(sql);
		
		List<Map<String,String>> res = new ArrayList<Map<String,String>>();
		
		while(rs.next())
			res.add(_rowToMap(rs));
		
		rs.close();
		command.close();
		
		return res;
	}
	
	private Map<String, String> _rowToMap(ResultSet row) throws SQLException
	{
		Map<String,String> res = new HashMap<String,String>();
		
		for(int i=1;i<=row.getMetaData().getColumnCount();i++)
		{
			String fieldName = row.getMetaData().getColumnLabel(i);	//nome del campo
			String fieldValue = row.getString(i);					//valore
			res.put(fieldName, fieldValue);
		}
		
		return res;		
	}

}