package generation.wh40k.businessintelligence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatisticsImpl implements Statistics
{
	Connection connection = null;
	
	public StatisticsImpl(Connection connection)
	{
		this.connection = connection;		
	}

	@Override
	public int costByTheater(String theater)
	{
		try
		{
			Statement command = connection.createStatement();
			ResultSet row = command.executeQuery("select sum(cost) as n from unit where deployment='"+theater+"'");
			return row.next() ? row.getInt("n") : -1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	
	}
	
	
	
	
}