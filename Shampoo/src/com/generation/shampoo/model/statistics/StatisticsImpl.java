package com.generation.shampoo.model.statistics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import java.sql.Statement;

public class StatisticsImpl implements Statistics
{
	Connection connection;
	
	public StatisticsImpl(Connection connection)
	{
		this.connection = connection;
	}

	
	@Override
	public Map<String, Double> avgPriceByProducer() {
		
		Map<String,Double> res = new HashMap<String,Double>();
		
		Statement command;
		try 
		{
			command = connection.createStatement();
			ResultSet row = command.executeQuery("SELECT producer, AVG(price) avg FROM parrucco.shampoo GROUP BY producer");
			while(row.next())
				res.put(row.getString("producer"), row.getDouble("avg"));
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Map<String, Double> deltaBio() {
		Map<String,Double> res = new HashMap<String,Double>();
		
		Statement command;
		try 
		{
			command = connection.createStatement();
			ResultSet row = command.executeQuery("select round((select((select AVG(price / size) FROM shampoo where bio = 'y')-(select AVG(price / size) FROM shampoo where bio = 'n'))/(select AVG(price / size) FROM shampoo where bio = 'n')) *100,2) deltabio");
			while(row.next())
				res.put("title", row.getDouble("deltabio"));
	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	
	
}