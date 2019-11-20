package generation.common.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import generation.common.dao.FlatEntityDAO;
import generation.common.entities.Factory;
import generation.common.entities.FlatEntityFactory;

public abstract class Context 
{
	protected Map<String, Object> dependencies = new HashMap<String,Object>();
	
	public Object get(String key)
	{
		return dependencies.get(key);
	}

	// cerco per contratto
	public Object get(Class oneinterface) 
	{
		for(String s : dependencies.keySet()) 
			for(Class c : dependencies.get(s).getClass().getInterfaces())
				if(c.getName().equals(oneinterface.getName()))
					return dependencies.get(s);
		return null;
	}

	
	
}