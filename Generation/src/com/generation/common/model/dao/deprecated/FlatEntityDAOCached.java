package com.generation.common.model.dao.deprecated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.common.model.entities.Entity;

/**
 * è un PROXY di FlatEntityDAO
 * @author FreePC
 *
 */
public class FlatEntityDAOCached<E extends Entity> implements EntityDAO<E>
{
	//oggetto reale, PROXATO. lui fa il suo lavoro, io faccio il mio
	FlatEntityDAO<E> real;
	
	//la mia cache
	List<E> cache = new ArrayList<E>();
	
	public FlatEntityDAOCached(FlatEntityDAO<E> real)
	{
		this.real = real;
		try
		{
			cache = real.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public E load(int id) throws Exception 
	{
		// NON TOCCO IL DB ORA!
		for(E e:cache)
			if(e.getId()==id)
				return e;
		return null;
	}

	@Override
	public List<E> list() throws Exception 
	{
		return cache;
	}

	
	// da migliorare...
	@Override
	public List<E> list(String condition) throws Exception 
	{
		return real.list(condition);
	}

	@Override
	public boolean delete(int id) throws Exception 
	{
		boolean res = real.delete(id);
		if(!res) return false;
		int pos = -1;
		for(int i=0;i<cache.size();i++)
			if(cache.get(i).getId()==id)
			{
				pos = i;
				break;
			}
		if(pos>=0)
			cache.remove(pos);
		return res;
	}

	@Override
	public boolean save(E e) throws Exception 
	{
		boolean res = real.save(e);
		if(!res) return false;

		//parto dall'idea di non averlo prima
		int pos = -1;
		for(int i=0;i<cache.size();i++)
			if(cache.get(i).getId()==e.getId())
			{
				pos = i;
				break;
			}
		if(pos>=0)
			cache.remove(pos);
		cache.add(e);
		return res;
	}
	
	

}