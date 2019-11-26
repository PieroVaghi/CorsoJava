package com.generation.libraryjpa.model.bi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.common.model.bi.BIFacade;

public class LibraryBIImpl implements LibraryBI
{
	private static final String SQLTOTALPRICE = "select sum(price) as totale from book";
	private static final String SQLAVGPRICEFORGENRE = "select genre, round(avg(price),2) as avg from book group by genre" ;
	private static final String SQLLIBLIST = "SELECT author.name, count(book.id) nrlib from author left join book on author.id = book.authorid group by author.name";
	
	//questo componente è un adapter di BIFacade
	//usa BIFacade, che è una vecchia interfaccia
	//per implementare ArmyBI (che è nuova)
	//Composition
	BIFacade bi;

	LibraryBIImpl(BIFacade bi) 
	{
		this.bi = bi;
	}
	
	@Override
	public int totalPriceLib()
	{
		try 
		{
			return (int) bi.singleNumber(SQLTOTALPRICE);
		} 
		catch (NumberFormatException | SQLException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public String avgPriceForGenre()
	{
		try 
		{
			String res = "";
			for(Map<String,String>  map : bi.rows(SQLAVGPRICEFORGENRE)) {
				res+="Genere: " + map.get("genre") + "\t";
				res+="Prezzo Medio: " + map.get("avg") + "\n";
			}
			return res ;
		} 
		catch (NumberFormatException | SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Map<String, Integer>> libList()
	{
		try 
		{
			List<Map<String,Integer>> res = new ArrayList<Map<String,Integer>>();
			Map<String,Integer> resm = new HashMap<String,Integer>();
			
			for(Map<String,String>  map : bi.rows(SQLLIBLIST)) {
				resm.put(map.get("name"), Integer.parseInt(map.get("nrlib")));
				res.add(resm);
				resm.clear();
			}
			
			return res;
		} 
		catch (NumberFormatException | SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
}
