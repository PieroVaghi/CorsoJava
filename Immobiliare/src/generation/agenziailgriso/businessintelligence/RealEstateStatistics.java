package generation.agenziailgriso.businessintelligence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RealEstateStatistics implements Statistics
{
	Connection connection = null;
	
	public RealEstateStatistics(Connection connection)
	{
		this.connection = connection;		
	}

	@Override
	public int avgCostByZone(String zone)
	{
		try
		{
			Statement command = connection.createStatement();
			ResultSet row = command.executeQuery("select avg(value) avg from property where address like '%"+zone+"%'");
			return row.next() ? row.getInt("avg") : -1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	
	}

	@Override
	public int avgTrafficByShop(String value) {
		try
		{
			Statement command = connection.createStatement();
			ResultSet row = command.executeQuery("SELECT " + 
												"    AVG(traffic) avg " + 
												" FROM " + 
												"    property inner join shop on property.id=shop.id " + 
												" WHERE " + 
												"    value >= " + value);
			return row.next() ? row.getInt("avg") : -1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
}