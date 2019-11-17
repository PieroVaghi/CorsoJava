package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.*;
import entities.*;

public class Main 
{
	private static final String PWD = "piefragio1";
	
	public static void main(String[] args) throws Exception 
	{
		 String url = "jdbc:mysql://127.0.0.1:3306/shop?useSSL=false";
         // create a connection to the database
         Connection conn = DriverManager.getConnection(url,"root",PWD);
		
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
         
		Map<String, String> saveQueries = new HashMap<String,String>();
		saveQueries.put("Employee", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],'[mansion]',[salary]);");
        saveQueries.put("Client", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
        saveQueries.put("Book", "insert into Product values([id],'[name]',[price],[quantity],'[description]');insert into Book values([id],'[author]','[category]',[pages])");
        saveQueries.put("CD", "insert into Product values([id],'[name]',[price],[quantity],'[description]');insert into CD values([id],'[artist]','[genre]',[length])");
   
		EntityDAO<Person> persondao = new FlatEntityDAO<Person>
        (
        	conn,
        	"select * from viewperson",
        	"select * from viewperson where id=",
        	"delete from person where id=[id]",
        	saveQueries
       );
	
		EntityDAO<Product> productdao = new FlatEntityDAO<Product>
        (
	       	conn,
	       	"select * from viewproduct;",
	       	"select * from viewproduct where id=",
	       	"delete from product where id=[id]",
	        saveQueries
       );
		
		String cmd = "";
		do
		{
			System.out.println("Insert command:");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "personal":
					for(Person person:persondao.list())
						System.out.println(person + "\n");
				break;
				case "employees":
					for(Person person:persondao.list())
						if(person instanceof Employee)
							System.out.println(person+ "\n");
				break;
				case "products":
					for(Product product:productdao.list())
						System.out.println(product+ "\n");
				break;
				case "printperson": {
					System.out.println("Insert ID:");
					int id = Integer.parseInt(keyboard.nextLine());
					System.out.println(persondao.load(id) + "\n");
				}
				break;
				case "printproduct": {
					System.out.println("Insert ID:");
					int id = Integer.parseInt(keyboard.nextLine());
					System.out.println(productdao.load(id) + "\n");
				}
				break;
				case "deleteperson": {
					System.out.println("Insert ID:");
					int id = Integer.parseInt(keyboard.nextLine());
					System.out.println(persondao.delete(id) + "\n");
				}
				break;
				case "deleteproduct": {
					System.out.println("Insert ID:");
					int id = Integer.parseInt(keyboard.nextLine());
					System.out.println(productdao.delete(id) + "\n");
				}
				break;
			}
		}while(!cmd.contentEquals("quit"));
		
		
		
		keyboard.close();
		
	}

}