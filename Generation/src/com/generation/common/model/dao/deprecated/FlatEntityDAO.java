package com.generation.common.model.dao.deprecated;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.common.model.entities.*;

public class FlatEntityDAO<E extends IEntity> implements EntityDAO<E>
{
	//DIPENDENZE
	Connection connection;
	String dataquery;
	String datasinglequery;
	String deletequery;
	Map<String,String> saveQueries = new HashMap<String,String>();
	Factory factory;
	
	/**
	 * Funziona solo per entità semplicissime! Product, entity, ecc!!
	 * DANGEROUS!
	 * @param entityClass
	 */
	@Deprecated
	public FlatEntityDAO(Class entityClass, Connection connection, Factory factory)
	{
		// ABNORMAL! Do not USE!
		// unless you know what it does... for real.
		this.connection = connection;
		this.factory = factory;
		
		
		String entityName = entityClass.getSimpleName().toLowerCase();
		this.dataquery="select * from view"+entityName;
		this.datasinglequery=this.dataquery+" where id=";
		this.deletequery="delete from "+entityName;
		//uso i getter
		List<String> fields = new ArrayList<String>();
		
		for(Method method:entityClass.getMethods())
			if(method.getName().startsWith("get"))
				fields.add(method.getName().replace("get", "").toLowerCase());
		
		//black magic
		String sql = "insert into "+entityName+"(";
		for(String field:fields)
			sql+=field+",";
		sql = sql.substring(0, sql.length()-1)+") VALUES (";
		for(String field:fields)
			sql+="["+field+"],";
		sql = sql.substring(0, sql.length()-1)+");";
		
		saveQueries.put
		(
			entityName,
			sql			
		);
		
		
	}
	
	
	public FlatEntityDAO(Connection connection, String dataquery, String datasinglequery, String deletequery, Map<String,String> saveQueries, Factory factory)
	{
		//la query da cui prendere i dati
		this.connection = connection;
		this.dataquery = dataquery;
		this.datasinglequery = datasinglequery;
		this.deletequery = deletequery;
		this.saveQueries = saveQueries;
		this.factory = factory;
	}
	
	
	@Override
	public E load(int id) throws Exception
	{
		E res = null;
		String sql = datasinglequery+id;
		Statement command = connection.createStatement();
		ResultSet row = command.executeQuery(sql);

		if(row.next())
			res = (E) factory.make(_rowToMap(row));
		
		row.close();
		command.close();
		
		return res;
	}


	private Map<String, String> _rowToMap(ResultSet row) throws Exception
	{
		Map<String,String> res = new HashMap<String,String>();
		
		for(int i=1;i<=row.getMetaData().getColumnCount();i++)
		{
			String fieldName = row.getMetaData().getColumnLabel(i);	//nome del campo
			String fieldValue = row.getString(i);					//valore
			res.put(fieldName, fieldValue);
		}
		
		return res;		
	}


	@Override
	public List<E> list() throws Exception
	{
		return list(" 1=1 ");
	}


	@Override
	public boolean delete(int id) throws Exception
	{
		Statement command = connection.createStatement();
		
		String sql = deletequery.replace("[id]",id+"");
		
		command.execute(sql);
		
		command.close();
		
		return true;
		
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
			Statement command = connection.createStatement();
			command.execute(cmd);
			command.close();
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
		Statement command = connection.createStatement();
		ResultSet rows = command.executeQuery(dataquery + " where "+ condition);
		while(rows.next())
			res.add((E) factory.make(_rowToMap(rows)));		
			
		rows.close();
		command.close();
		return res;	
	}
	
	
	
}