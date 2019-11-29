package com.generation.common.model.bi;

import java.sql.SQLException;
import java.util.Map;
import java.util.List;

public interface BIFacade 
{
	
	
	// select sum(salary) from soldier
	// facade.singleNumber("select sum(salary) from soldier")
	default double singleNumber(String sql) throws SQLException, NumberFormatException
	{
		return Double.parseDouble(singleString(sql));
	}
	
	// facade.singleString("select profession from soldier group by profession order by count(*) desc limit 1");
	default String singleString(String sql) throws SQLException
	{
		Map<String,String> row = row(sql);
		String res = "";
		for(String key:row.keySet())
		{
			res = row.get(key);
			break;
		}
		return res;
		
	}
	
	// facade.rows("select profession, avg(salary) as avg from soldier group by profession");
	List<Map<String,String>> rows(String sql) throws SQLException;
	
	// TEMPLATE METHOD
	default Map<String,String> row(String sql) throws SQLException
	{
		List<Map<String,String>> rows = rows(sql);
		return rows.size()>=1 ? rows.get(0) : null;
	}
	
	
	
	
	
}