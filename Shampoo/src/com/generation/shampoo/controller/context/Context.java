package com.generation.shampoo.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.generation.shampoo.model.entities.Shampoo;
import com.generation.shampoo.model.statistics.StatisticsImpl;

import generation.common.dao.*;
import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;
import generation.common.view.BasicView;

// un cestone in cui metterò tutte le informazioni di configurazione del progetto
// SINGLETON

public class Context extends generation.common.context.Context
{

	
	
	//L'unico oggetto appartiene alla classe
	private static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
		
	
	private Context()
	{
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");  
			dependencies.put("connection",DriverManager.getConnection("jdbc:mysql://localhost:3306/parrucco?useSSL=false","root","root"));
		}
		catch(Exception e)
		{
			System.out.println("Can't establish connection. program aborting");
			e.printStackTrace();
			System.exit(-1);
		}
		
		Map<String,String> saveQueries = new HashMap<String,String>();
		saveQueries.put
		(		
				"Shampoo", 
				"INSERT INTO Shampoo (id, producer, name, price, bio, size) VALUES ([id],'[producer]','[name]',[price],'[bio]',[size]);"
		);
		
		dependencies.put("entityfactory", new FlatEntityFactory("com.generation.shampoo.model.entities"));
		
		dependencies.put
		(
			"shampoodao",
			new FlatEntityDAOCached<Shampoo>
											(
												new FlatEntityDAO<Shampoo>
																		(
																			(Connection) dependencies.get("connection"),
																			"select * from shampooview",
																			"select * from shampooview where id=",
																			"delete from shampoo where id=[id]",
																			saveQueries,
																			(Factory) dependencies.get("entityfactory")
																		)
											)
		);
		
		dependencies.put
		(
			"statistics",
			new StatisticsImpl((Connection) dependencies.get("connection"))	
		);
		
		dependencies.put
		   (
				   "viewshampoo",
				   new BasicView<Shampoo>("C:\\Users\\utente15\\Desktop\\CorsoJava\\Shampoo\\ita\\text.txt", "C:\\Users\\utente15\\Desktop\\CorsoJava\\Shampoo\\ita\\template.txt")
		   );
		
	}
	
	
}