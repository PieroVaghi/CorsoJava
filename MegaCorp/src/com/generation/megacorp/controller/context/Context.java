package com.generation.megacorp.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.generation.megacorp.controller.command.*;
import com.generation.megacorp.model.dao.EmployeeDAO;
import com.generation.megacorp.model.entities.Certificate;
import com.generation.megacorp.model.entities.Employee;
import com.generation.megacorp.model.view.EmployeeView;

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
				DriverManager.getConnection("jdbc:mysql://localhost:3306/megaditta?useSSL=false","root","root")
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Behaviour behaviour = 
				new Behaviour
				(
					"list,quit,search".split(","),
					new Command[] {new List(), new QuitCommand(), new Search()}
				);
		
		put("behaviour", behaviour);
		
		put("keyboard", new Scanner(System.in));
		
		put
		(
			"factory",
			new FlatEntityFactory("com.generation.megacorp.model.entities")
		);

		//queries di salvataggio
		Map<String,String> saving = new HashMap<String,String>();
		saving.put("Employee", "insert into employee (id,name,surname,role,salary,dob) values ([id],'[name]','[surname]','[role]',[salary],'[dob]')");
		saving.put("Certificate", "insert into certificate (title,earnedon,expireson,cost,employeedid) values ('[title]','[earnedon]','[expireson]',[cost],'[employeeid]')");
		put("saving",saving);
		
		put("database", new DatabaseImpl((Connection) dependencies.get("connection")));
				
		put
		(
			"flatemployeedao",
			new FlatEntityDAO<Employee>
			(
				(Database) get("database"),
			    "select * from employeeview",
			    "select * from employeeview where id=",
			    "delete from employee where id=[id]",
			    (Map<String,String>)get("saving"),
			    (Factory) get("factory")
			)				
		);
		
		put
		(
			"flatcertificatedao",
			new FlatEntityDAO<Certificate>
			(
				(Database) get("database"),
			    "select * from certificateview",
			    "select * from certificateview where id=",
			    "delete from certificate where id=[id]",
			    (Map<String,String>)get("saving"),
			    (Factory) get("factory")
			)				
		);
		
		
		put
		(
			"employeedao", 
			new EmployeeDAO
			(
				(FlatEntityDAO<Employee>) get("flatemployeedao"),
				(FlatEntityDAO<Certificate>) get("flatcertificatedao")
			)
		);
		
		put ("language",  new BasicLanguage("ita/ita.lang"));
		
		put
		   (
				   "viewemployee",
				   new EmployeeView
				   (
						   new BasicView<Employee> ("ita/template.txt")
						   ,
						   ((Language) get("language"))
						   
					)
			);
		
			
		
	}
	
}
