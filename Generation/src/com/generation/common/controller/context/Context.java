package com.generation.common.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.generation.common.model.dao.deprecated.FlatEntityDAO;
import com.generation.common.model.entities.Factory;
import com.generation.common.model.entities.FlatEntityFactory;

public abstract class Context 
{
	protected Map<String, Object> dependencies = new HashMap<String,Object>();
	
	public Object get(String key)
	{
		//Tu non puoi passare
		if(!dependencies.containsKey(key) || dependencies.get(key)==null)
		{
			System.out.println("UNSATISFIED DEPENDENCY "+key+". UNABLE TO CONTINUE");
			System.exit(-1);
		}
		return dependencies.get(key);
	}

	public void put(String key,Object value)
	{
		dependencies.put(key,value);
	}

	
	// cerco per contratto
	public Object get(Class oneinterface) 
	{
		// ritornare un oggetto(--> dependencies) 
		//che implementa un interfaccia del tipo passato
		Object res = null;
		for(String s : dependencies.keySet()) 
			for(Class c : dependencies.get(s).getClass().getInterfaces())
				if(c.getName().equals(oneinterface.getName()))
					res = dependencies.get(s);
		if(res==null)
		{
			System.out.println("UNSATISFIED DEPENDENCY "+oneinterface.getClass().getName()+". UNABLE TO CONTINUE");
			System.exit(-1);	
		}
		
		return null;
	}

	
	
}