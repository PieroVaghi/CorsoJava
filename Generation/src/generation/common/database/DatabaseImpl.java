package generation.common.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseImpl implements Database{
	
	Connection connection;
	Statement command;

	public DatabaseImpl(Connection connection) 
	{
		this.connection = connection;
	}

	
	/**
	 * Metodo che trasforma il ResultSet della nostra query in una lista di mappe
	 */
	@Override
	public List<Map<String, String>> rows(String sql) throws SQLException 
	{
		
		List<Map<String, String>> listres  = new ArrayList<Map<String, String>>();
		Map<String,String> res = new HashMap<String,String>();
		
		try 
		{
			command = connection.createStatement();
//			System.out.println(sql);
			ResultSet rows = command.executeQuery(sql);
			while(rows.next()) 
			{
				try {
					res = (_rowToMap(rows));
				} catch (Exception e) {
					e.printStackTrace();
				}	
				listres.add(res);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		command.close();
		return listres;
	}
	
	/**
	 * Metodo per ottenere una mappa da una singola riga di un ResultSet
	 * @param row
	 * @return
	 * @throws Exception
	 */
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
	public boolean executeOnDb(String sql) throws Exception {
		command = connection.createStatement();
		try {
			command.execute(sql);
		} catch (SQLException e) {
			System.out.println("Error query: "+sql);
			e.printStackTrace();
		}
		command.close();
		return true;
	}
}
