package generation.office.statistics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import java.sql.Statement;

public class StatisticsImpl implements Statistics
{
	Connection connection;
	
	public StatisticsImpl(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public Map<String, Integer> avgSalaryByProfession() 
	{
		Map<String,Integer> res = new HashMap<String,Integer>();
		
		Statement command;
		try 
		{
			command = connection.createStatement();
			ResultSet row = command.executeQuery("select role, avg(salary) as total from employee where dob>2000-01-01 group by role");
			while(row.next())
				res.put(row.getString("role"), row.getInt("total"));
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	
	
	
	
}