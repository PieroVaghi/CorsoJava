package com.generation.common.model.entities;

import java.util.Map;

public class FlatEntityFactory implements Factory
{
	private String entityPackage;

	public FlatEntityFactory(String entityPackage) 
	{
		this.entityPackage = entityPackage;
	}

	@Override
	public IEntity make(Map<String, String> status) throws FactoryException
	{
		if(status==null)
			throw new FactoryException("Invalid map, null passed. Expected not null map");
		
		if(!status.containsKey("type") || status.get("type")==null)
			throw new FactoryException("Required field type in map. Aborting");
		
		IEntity res = null;
		
		try 
		{
			res = (IEntity) Class.forName(entityPackage+"."+status.get("type")).newInstance();
			res.fromMap(status);
		} 
		catch (InstantiationException e) 
		{
			//sollevo una eccezione - chi mi usa dovr� gestirla.
			throw new FactoryException("Cannot instantiate class "+entityPackage+"."+status.get("type"));
		} 
		catch (IllegalAccessException e) 
		{
			throw new FactoryException("Cannot access default constructor for class "+entityPackage+"."+status.get("type"));
		} 
		catch (ClassNotFoundException e) 
		{
			throw new FactoryException("Cannot find class "+entityPackage+"."+status.get("type"));
		}
		
		
		return res;
	}
	
		

}