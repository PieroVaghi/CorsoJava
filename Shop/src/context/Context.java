package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import dao.*;
import entities.*;

// un cestone in cui metterò tutte le informazioni di configurazione del progetto
// SINGLETON

public class Context 
{
	Map<String, Object> dependencies = new HashMap<String,Object>();
	
	public Object get(String key)
	{
		return dependencies.get(key);
	}
	
	//L'unico oggetto appartiene alla classe
	private static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
	
	
	private Context()
	{
		//le queries di salvataggio
		Map<String, String> saveQueries = new HashMap<String,String>();
		saveQueries.put("Employee", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],[salary],'[mansion]');");
        saveQueries.put("Client", "insert into Person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
        saveQueries.put("Book", "insert into Product values([id],'[name]','[description]',[price],[quantity]);insert into Book values([id],'[author]','[category]',[pages])");
        saveQueries.put("CD", "insert into Product values([id],'[name]','[description]',[price],[quantity]);insert into CD values([id],'[artist]','[genre]',[length])");
		dependencies.put("savequeries", saveQueries);
	
		try
		{
			dependencies.put("connection", DriverManager.getConnection("jdbc:sqlite:shop.db"));
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dependencies.put("entityfactory", new SimpleFactory("entities"));
		
		dependencies.put
		(
			"persondao", 
			new FlatEntityDAO<Person>
			(
				(Connection) dependencies.get("connection"),
				"select * from viewperson",
		        "select * from viewperson where id=",
		        "delete from person where id=[id];delete from employee where id=[id];delete from client where id=[id];",
		        saveQueries,
				(Factory) dependencies.get("entityfactory")
			)
		);
		
		dependencies.put
		(
			"productdao",
			new FlatEntityDAO<Product>
	        (
				(Connection) dependencies.get("connection"),
		       	"select * from viewproduct;",
		       	"select * from viewproduct where id=",
		       	"delete from product where id=[id]; delete from Book where id=[id]; delete from CD where id=[id];",
		        saveQueries,
				(Factory) dependencies.get("entityfactory")
	       )
	   );
		
		
		
	}
	
	
}