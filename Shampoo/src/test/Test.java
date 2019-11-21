package test;

import com.generation.shampoo.controller.context.Context;
import com.mysql.jdbc.Connection;

import generation.common.database.Database;
import generation.common.database.DatabaseImpl;
import generation.common.entities.Factory;

public class Test {

	public static void main(String[] args) throws Exception
	{
		Database database = new DatabaseImpl((Connection) Context.getInstance().get("connection"));
		Factory factory = ((Factory) Context.getInstance().get("entityfactory")) ;
		
//		System.out.println(database.row("select * from shampooview where id=1"));
		System.out.println(factory.make(database.row("select * from shampooview where id=1")));
	
		System.out.println("------------------------------");
		
		System.out.println(database.singleInt("select round(avg(price)) from shampoo where producer='Coop'"));
		
	}
	

}
