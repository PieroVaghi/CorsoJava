package com.generation.persondrama.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.generation.persondrama.controller.command.BIavgage;
import com.generation.persondrama.controller.command.BIavgdrama;
import com.generation.persondrama.controller.command.Delete;
import com.generation.persondrama.controller.command.List;
import com.generation.persondrama.controller.command.QuitCommand;
import com.generation.persondrama.controller.command.RandomInsert;
import com.generation.persondrama.controller.command.Search;
import com.generation.persondrama.model.dao.PersonDAO;
import com.generation.persondrama.model.entities.Drama;
import com.generation.persondrama.model.entities.Person;
import com.generation.persondrama.model.insert.CasualInsertImplement;
import com.generation.persondrama.view.PersonView;

import generation.common.controller.command.Behaviour;
import generation.common.controller.command.Command;
import generation.common.dao.FlatEntityDAO;
import generation.common.database.Database;
import generation.common.database.DatabaseImpl;
import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;
import generation.common.view.entities.BasicView;
import generation.common.view.language.BasicLanguage;
import generation.common.view.language.Language;

public class Context extends generation.common.context.Context {
	
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
			put
			(
				"connection",
				DriverManager.getConnection("jdbc:mysql://localhost:3306/pdrama?useSSL=false","root","root")
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Behaviour behaviour = 
				new Behaviour
				(
					"list,quit,search,delete,biavgdrama,biavgage,randominsert".split(","),
					new Command[] {new List(), new QuitCommand(), new Search(),
							new Delete(), new BIavgdrama(), new BIavgage(),
							new RandomInsert()}
				);
		
		put("behaviour", behaviour);
		
		put("keyboard", new Scanner(System.in));
		
		put("insert", new CasualInsertImplement());
		
		put
		(
			"factory",
			new FlatEntityFactory("com.generation.persondrama.model.entities")
		);

		//queries di salvataggio
		Map<String,String> saving = new HashMap<String,String>();
		saving.put("Person", "insert into person (id,name,surname,age) values ([id],'[name]','[surname]',[age])");
		saving.put("Drama", "insert into drama (info,date) values ('[info]','[date]')");
		put("saving",saving);
		
		put("database", new DatabaseImpl((Connection) dependencies.get("connection")));
				
		put
		(
			"flatpersondao",
			new FlatEntityDAO<Person>
			(
				(Database) get("database"),
			    "select * from personview",
			    "select * from personview where id=",
			    "delete from person where id=[id]",
			    (Map<String,String>)get("saving"),
			    (Factory) get("factory")
			)				
		);
		
		put
		(
			"flatdramadao",
			new FlatEntityDAO<Drama>
			(
				(Database) get("database"),
			    "select * from dramaview",
			    "select * from dramaview where id=",
			    "delete from drama where id=[id]",
			    (Map<String,String>)get("saving"),
			    (Factory) get("factory")
			)				
		);
		
		
		put
		(
			"persondao", 
			new PersonDAO
			(
				(FlatEntityDAO<Person>) get("flatpersondao"),
				(FlatEntityDAO<Drama>) get("flatdramadao")
			)
		);
		
		put ("language",  new BasicLanguage("ita/ita.lang"));
		
		put
		   (
				   "viewperson",
				   new PersonView
				   (
						   new BasicView<Person> ("ita/template.txt")
						   ,
						   ((Language) get("language"))
						   
					)
			);
		
			
		
	}
	
}
