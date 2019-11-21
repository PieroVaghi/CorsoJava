package com.generation.shampoo.model.statistics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import generation.common.database.Database;

import java.sql.Statement;

public class StatisticsImpl implements Statistics
{
	Database database;
	
	public StatisticsImpl(Database database)
	{
		this.database = database;
	}

	
	@Override
	public Map<String, Double> avgPriceByProducer() {
		
		Map<String,Double> res = new HashMap<String,Double>();
		try 
		{
			for(Map<String,String> m : database.rows("SELECT producer, AVG(price) avg FROM parrucco.shampoo GROUP BY producer"))
				res.put(m.get("producer"), Double.parseDouble(m.get("avg")));	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double deltaBio() {
		try {
			return database.singleDouble("select round((select((select AVG(price / size) FROM shampoo where bio = 'y')-(select AVG(price / size) FROM shampoo where bio = 'n'))/(select AVG(price / size) FROM shampoo where bio = 'n')) *100,2) deltabio");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
	
}