package dao;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import entities.Client;
import entities.Employee;
import entities.Person;



public class Main 
{

	private static final String PWD = "root";

	public static void main(String[] args) throws Exception
	{
		 String url = "jdbc:mysql://127.0.0.1:3306/shop?useSSL=false";
         // create a connection to the database
         Connection conn = DriverManager.getConnection(url, "root", PWD);
	
         //come chiave, il nome della classe
         //come valore la query di salvataggio
         Map<String, String> saveQueries = new HashMap<String,String>();
         
         saveQueries.put("Employee", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],'[mansion]',[salary]);");
         saveQueries.put("Client", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
         EntityDAO<Person> dao = new FlatEntityDAO<Person>
         (
        	conn,
         	"select * from viewperson",
         	"select * from viewperson where id=",
         	"delete from person where id=[id]",//;delete from employee where id=[id];delete from client where id=[id]",
         	saveQueries
        );
     
         
         
        System.out.println(dao.list());
         
         
         Employee e = new Employee();
         
         e.setName("Walter");
         e.setSurname("Frankenstein");
         e.setDob("01/01/1979");
         e.setMansion("Venditore");
         e.setSalary(1500);
         e.setId(2);
         
         dao.save(e);
         
         Client c = new Client();
         
         c.setName("Francesco");
         c.setSurname("Rotondi");
         c.setDob("27/12/1992");
         c.setEmail("frarotonfi@gmail.com");
         c.setInterests("Vespa, Pompieri, Margherita");
         c.setId(4);
         
         dao.save(c);
         
         System.out.println(dao.list());
         
	}

}