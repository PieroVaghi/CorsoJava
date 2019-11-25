package generation.office.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.generation.common.model.dao.deprecated.*;

import generation.office.entities.Employee;
import generation.office.statistics.StatisticsImpl;
import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;

// un cestone in cui metterò tutte le informazioni di configurazione del progetto
// SINGLETON

public class Context extends com.generation.common.comtroller.context.Context
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
			dependencies.put("connection",DriverManager.getConnection("jdbc:mysql://localhost:3306/office?useSSL=false","root","root"));
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
				"Employee", 
				"INSERT INTO employee (id, name, surname, role, salary, gender, dob) VALUES ([id],'[name]','[surname]','[role]',[salary],'[gender]', '[dob]');"
		);
		
		dependencies.put("entityfactory", new FlatEntityFactory("generation.office.entities"));
		
		dependencies.put
		(
			"employeedao",
			new FlatEntityDAOCached<Employee>(
				new FlatEntityDAO<Employee>
				(
					(Connection) dependencies.get("connection"),
					"select * from viewemployee",
					"select * from viewemployee where id=",
					"delete from employee where id=[id]",
					saveQueries,
					(Factory) dependencies.get("entityfactory")
				)
			)
		);
		
		dependencies.put
		(
			"statistics",
			new StatisticsImpl((Connection) dependencies.get("connection"))	
		);
		
	}
	
	
}