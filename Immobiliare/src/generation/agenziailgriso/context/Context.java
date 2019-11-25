package generation.agenziailgriso.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.generation.common.model.dao.deprecated.*;

import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;
import generation.agenziailgriso.businessintelligence.RealEstateStatistics;
import generation.agenziailgriso.entities.*;

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
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");  
			dependencies.put("connection",DriverManager.getConnection("jdbc:mysql://localhost:3306/agenziailgriso?useSSL=false","root","root"));
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
				"Apartment", 
				"insert into property(id,address,value,sqm,notes,owner)values([id],'[address]',[value],[sqm],'[notes]','[owner]');insert into apartment (id, floor, rooms, balconis, bathrooms) values ([id], [floor], [rooms], [balconis], [bathrooms])"
		);
		saveQueries.put
		(		
				"Shop", 
				"insert into property(id,address,value,sqm,notes,owner)values([id],'[address]',[value],[sqm],'[notes]','[owner]');insert into shop (id, windows, werehouse, traffic) values ([id], [windows], [werehouse], [traffic])"
		);
		saveQueries.put
		(		
				"Ground", 
				"insert into property(id,address,value,sqm,notes,owner)values([id],'[address]',[value],[sqm],'[notes]','[owner]');insert into ground (id, permits, state) values ([id], '[permits]', '[state]')"
		);
		
		dependencies.put("entityfactory", new FlatEntityFactory("generation.agenziailgriso.entities"));
		
		dependencies.put
		(
			"propertydao",	
			new FlatEntityDAO<Property>
			(
				(Connection) dependencies.get("connection"),
				"select * from viewproperty",
				"select * from viewproperty where id=",
				"delete from property where id=[id]",
				saveQueries,
				(Factory) dependencies.get("entityfactory")
			)
		);
		
		dependencies.put
		(
			"statistics",
			new RealEstateStatistics((Connection) dependencies.get("connection"))
		);
		
	}
	
	
}