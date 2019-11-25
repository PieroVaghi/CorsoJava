package generation.wh40k.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.generation.common.model.dao.deprecated.*;

import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;
import generation.wh40k.businessintelligence.StatisticsImpl;
import generation.wh40k.entities.*;

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
		Map<String,String> savequery= new HashMap<String,String>();
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");  
			dependencies.put("connection",DriverManager.getConnection("jdbc:mysql://localhost:3306/wh40k","root","root"));
		}
		catch(Exception e)
		{
			System.out.println("Can't establish connection. program aborting");
			e.printStackTrace();
			System.exit(-1);
		}
		
		Map<String,String> saveQueries = new HashMap<String,String>();
		saveQueries.put
		(		
				"Soldier", 
				"insert into unit(id,deployment,cost,notes)values([id],'[deployment]',[cost],'[notes]');insert into soldier (id, name, surname, dob, salary, race, service) values ([id], '[name]', '[surname]', '[dob]', [salary], '[race]', [service])"
		);
		saveQueries.put
		(		
				"Vehicle", 
				"insert into unit(id,deployment,cost,notes)values([id],'[deployment]',[cost],'[notes]');insert into vehicle (id, category, fueltype, license, years) values ([id], '[category]', '[fueltype]', '[license]', '[years]')"
		);
		
		dependencies.put("entityfactory", new FlatEntityFactory("generation.wh40k.entities"));
		
		dependencies.put
		(
			"unitdao",	
			new FlatEntityDAO<Unit>
			(
				(Connection) dependencies.get("connection"),
				"select * from viewunit",
				"select * from viewunit where id=",
				"delete from unit where id=",
				saveQueries,
				(Factory) dependencies.get("entityfactory")
			)
		);
		
		dependencies.put
		(
			"statistics",
			new StatisticsImpl((Connection) dependencies.get("connection"))
		);
		
	}
	
	
}