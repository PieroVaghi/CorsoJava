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
import entities.Person;
import entities.Product;

public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		 String url = "jdbc:sqlite:shop.db";
         // create a connection to the database
         Connection conn = DriverManager.getConnection(url);
		
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
         
		Map<String, String> saveQueries = new HashMap<String,String>();
		saveQueries.put("Employee", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],[salary],'[mansion]');");
        saveQueries.put("Client", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
        saveQueries.put("Book", "insert into Product values([id],'[name]','[description]',[price],[quantity]);insert into Book values([id],'[author]','[category]',[pages])");
        saveQueries.put("CD", "insert into Product values([id],'[name]','[description]',[price],[quantity]);insert into CD values([id],'[artist]','[genre]',[length])");
   
		EntityDAO<Person> persondao = new FlatEntityDAO<Person>
        (
        	conn,
        	"select * from viewperson",
        	"select * from viewperson where id=",
        	"delete from person where id=[id];delete from employee where id=[id];delete from client where id=[id];",
        	saveQueries
       );
	
		EntityDAO<Product> productdao = new FlatEntityDAO<Product>
        (
	       	conn,
	       	"select * from viewproduct;",
	       	"select * from viewproduct where id=",
	       	"delete from product where id=[id]; delete from Book where id=[id]; delete from CD where id=[id];",
	        saveQueries
       );
		
		String cmd = "";
		do
		{
			System.out.println("Insert command");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "personal":
					for(Person person:persondao.list())
						System.out.println(person);
				break;
				case "employees":
					for(Person person:persondao.list())
						if(person instanceof Employee)
							System.out.println(person);
				break;
				case "products":
					for(Product product:productdao.list())
						System.out.println(product);
				break;
			}
		}while(!cmd.contentEquals("quit"));
		
		
		
		keyboard.close();
		
	}

}