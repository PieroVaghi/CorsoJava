Main.java

A

a

Tipo
Java
Dimensioni
2 kB (1.599 byte)
Spazio di archiviazione utilizzato
0 byteDi proprietà di
Posizione
dao
Proprietario
Simone Damigella
Modificato
15 nov 2019 da Simone Damigella
Aperto
12:03 da me
Creato
15 nov 2019
Aggiungi una descrizione
I visualizzatori possono scaricare
package dao;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import entities.Employee;
import entities.Person;

public class Main 
{

	public static void main(String[] args) throws Exception
	{
		 String url = "jdbc:sqlite:shop.db";
         // create a connection to the database
         Connection conn = DriverManager.getConnection(url);
	
         //come chiave, il nome della classe
         //come valore la query di salvataggio
         Map<String, String> saveQueries = new HashMap<String,String>();
         
         saveQueries.put("Employee", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],[salary],'[mansion]');");
         saveQueries.put("Client", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
         EntityDAO<Person> dao = new FlatEntityDAO<Person>
         (
        	conn,
         	"select * from viewperson",
         	"select * from viewperson where id=",
         	"delete from person where id=[id];delete from employee where id=[id];delete from client where id=[id];",
         	saveQueries
        );
     
         
         
         System.out.println(dao.list());
         
         /*
         Employee e = new Employee();
         
         e.setName("Viktor");
         e.setSurname("Frankenstein");
         e.setDob("01/01/1979");
         e.setMansion("scientist");
         e.setSalary(10000);
         e.setId(2);
         
         dao.save(e);
         */
	}

}