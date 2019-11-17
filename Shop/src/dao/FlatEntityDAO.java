package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Employee;
import entities.Entity;

public class FlatEntityDAO<E extends Entity> implements EntityDAO<E>
{
	Connection connection;
	String dataquery;
	String datasinglequery;
	String deletequery;
	Map<String,String> saveQueries = new HashMap<String,String>();
	
	public FlatEntityDAO(Connection connection, String dataquery, String datasinglequery, String deletequery, Map<String,String> saveQueries)
	{
		//la query da cui prendere i dati
		this.connection = connection;
		this.dataquery = dataquery;
		this.datasinglequery = datasinglequery;
		this.deletequery = deletequery;
		this.saveQueries = saveQueries;
	}
	
	
	@Override
	public E load(int id) throws Exception
	{
		E res = null;
		String sql = datasinglequery+id;
		Statement command = connection.createStatement();
		ResultSet row = command.executeQuery(sql);

		if(row.next())
		{
			String classToCreate = row.getString("type");
					
			res = (E) Class.forName("entities."+classToCreate).newInstance();
			res.fromMap(_rowToMap(row));
		}
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
		List<E> res = new ArrayList<E>();
		Statement command = connection.createStatement();
		ResultSet rows = command.executeQuery(dataquery);
		while(rows.next())
		{
			String classToCreate = rows.getString("type");
			E single = (E) Class.forName("entities."+classToCreate).newInstance();
			single.fromMap(_rowToMap(rows));
			res.add(single);		
		}
			
		rows.close();
		command.close();
		return res;
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
	
	
	
}