package com.generation.common.model.dao.deprecated;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generation.common.database.Database;
import generation.common.entities.*;

public class FlatEntityDAO<E extends generation.common.entities.Entity> implements EntityDAO<E>
{
	//DIPENDENZE
	Database database;
	String dataquery;
	String datasinglequery;
	String deletequery;
	Map<String,String> saveQueries = new HashMap<String,String>();
	Factory factory;
	
	public FlatEntityDAO(Database database, String dataquery, String datasinglequery, String deletequery, Map<String,String> saveQueries, Factory factory)
	{
		//la query da cui prendere i dati
		this.database = database;
		this.dataquery = dataquery;
		this.datasinglequery = datasinglequery;
		this.deletequery = deletequery;
		this.saveQueries = saveQueries;
		this.factory = factory;
	}
	
	
	@Override
	public E load(int id) throws Exception
	{
		return (E) factory.make(database.row(datasinglequery+id));
	}


//	private Map<String, String> _rowToMap(ResultSet row) throws Exception
//	{
//		Map<String,String> res = new HashMap<String,String>();
//		
//		for(int i=1;i<=row.getMetaData().getColumnCount();i++)
//		{
//			String fieldName = row.getMetaData().getColumnLabel(i);	//nome del campo
//			String fieldValue = row.getString(i);					//valore
//			res.put(fieldName, fieldValue);
//		}
//		
//		return res;		
//	}


	@Override
	public List<E> list() throws Exception
	{
		return list(" 1=1 ");
	}


	@Override
	public boolean delete(int id) throws Exception
	{
		return database.executeOnDb(deletequery.replace("[id]",(id+"")));
	
	}


	@Override
	public boolean save(E e) throws Exception
	{
		// Devo prendere il modello della query.
		//è qui che fondo il modello, preso da saveQueries
		//con la mappa ricavata dalla entity
		String sql = saveQueries.get(e.getClass().getSimpleName());	
		for(String key:e.toMap().keySet())
			sql = sql.replace("["+key+"]", _notNull(e.toMap().get(key)));
		delete(e.getId());
		
		for(String cmd:sql.split(";"))
		{
			return database.executeOnDb(cmd);
		}
		return true;
	}

	private String _notNull(String s)
	{
		return s==null ? "" : s;
	}


	@Override
	public List<E> list(String condition) throws Exception 
	{
		List<E> res = new ArrayList<E>();
//		System.out.println(dataquery + " where "+ condition);
		for(Map<String,String> m : database.rows(dataquery + " where "+ condition))
			res.add((E) factory.make(m));	
//		System.out.println(res);
		return res;	
	}
	
	
	
}