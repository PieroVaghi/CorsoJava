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

	/**
	 * @param connection
	 */
	public DatabaseImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List<Map<String, String>> rows(String sql) throws SQLException {
		
		List<Map<String, String>> listres  = new ArrayList<Map<String, String>>();
		Map<String,String> res = new HashMap<String,String>();
		
		Statement command;
		try 
		{
			command = connection.createStatement();
			ResultSet rows = command.executeQuery(sql);
			while(rows.next()) 
			{
				try {
					res = (_rowToMap(rows));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				listres.add(res);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listres;
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

}
