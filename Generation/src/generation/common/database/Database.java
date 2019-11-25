package generation.common.database;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;
//Io trovo noioso lavorare con JDBC
//JDBC mi costringe a usare diverse interfacce per fare 
//cavolate... compiti semplici.

//ad esempio, per leggere una media devo scrivere:

// Statement ...
// ResultSet row = ... select as ...
// if (row.next())... ecc

// uso TRE interfacce (o classi astratte) per fare roba banale.

// sarebbe bello se avessi un qualcosa di questo tipo:

public interface Database 
{

	//dopo tutto un ResultSet è solo una lista di mappe...
	List<Map<String,String>> rows(String sql) throws SQLException;
	// questo prende il posto di 
	// ResultSet row = statement.executeQuery(sql)
	// e ha senso visto che ottengo direttamente una lista di MAPPE
	
	//tu mi farai questo. Io in cambio...
	
	// Map<String,String> map = database.row("select * from person where id=1");
	default Map<String,String> row(String sql) throws SQLException
	{
		//Arriva una sql che restituisce una sola riga al massimo
		//come per load
		List<Map<String,String>> rows = rows(sql);
		return rows.size()==1 ? rows.get(0) : null;
	}
	
	//Se tu mi dai un metodo che restituisce una sola riga..
	//e anche una sola colonna
	//esempio: int totalespese = database.singleInt("select sum(salary) as n from employee");
	default int singleInt(String sql) throws SQLException
	{
		Map<String,String> row = row(sql);
		for(String key:row.keySet())
			return Integer.parseInt(row.get(key));
		return 0;
	}
	
	default double singleDouble(String sql) throws SQLException
	{
		Map<String,String> row = row(sql);
		for(String key:row.keySet())
			return Double.parseDouble(row.get(key));
		return 0;
	}
	
	
	
	boolean executeOnDb(String sql) throws Exception;
}