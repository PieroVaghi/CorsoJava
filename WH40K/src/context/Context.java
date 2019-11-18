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
		saveQueries.put("Soldier", "insert into unit values([id],[cost],'[deployment]','[notes]');insert into soldier values([id],'[name]','[surname]','[dob]',[service],'[race]',[salary]);");
        saveQueries.put("Vehicle", "insert into unit values([id],[cost],'[deployment]','[notes]');insert into vehicle values([id],'[category]','[fueltype]','[license]',[years]);");
		dependencies.put("savequeries", saveQueries);
	
		try
		{
			dependencies.put("connection", DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wh40k?useSSL=false","root","root"));
		} 
		catch (SQLException e) 
		{
			System.out.println("Can't estabilish connection. Program aborting");
			e.printStackTrace();
			System.exit(-1);
		}
		dependencies.put("entityfactory", new SimpleFactory("entities"));
		
		dependencies.put
		(
			"unitdao", 
			new FlatEntityDAO<Unit>
			(
				(Connection) dependencies.get("connection"),
				"select * from viewunit",
		        "select * from viewunit where id=",
		        "delete from unit where id=[id]",
		        saveQueries,
				(Factory) dependencies.get("entityfactory")
			)
		);
		
				
	}
	
	
}