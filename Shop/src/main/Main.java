package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.*;
import entities.Book;
import entities.Client;
import entities.Employee;
import entities.Entity;
import entities.Factory;
import entities.Person;
import entities.Product;
import entities.SimpleFactory;
import java.util.Scanner;

import context.Context;
public class Main 
{

    static java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
	// DIPENDENZE DEL MAIN 
	static Connection connection = (Connection) Context.getInstance().get("connection");
	static EntityDAO<Person> persondao = (EntityDAO<Person>) Context.getInstance().get("persondao");
	static EntityDAO<Product> productdao = (EntityDAO<Product>) Context.getInstance().get("productdao");
    
	public static void main(String[] args) 
	{
		
		String cmd = "";
		String res = "";
		do
		{
			System.out.println("Insert command");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "personal":
					res = _personal();
				break;
				case "employees":
					res = _employees();
				break;
				case "products":
					res = _products();
				break;
			}
			System.out.println(res);
		}while(!cmd.contentEquals("quit"));
		
		keyboard.close();
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String _personal() 
	{
		String res = "";
		try 
		{
			for(Person p:persondao.list())
				res+=p.toString();
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static String _employees() 
	{
		String res = "";
		try 
		{
			for(Person p:persondao.list())
				if(p instanceof Employee)
					res+=p.toString();
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}

	private static String _products() 
	{
		String res = "";
		try 
		{
			for(Product p:productdao.list())
				res+=p.toString();
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}

	
}