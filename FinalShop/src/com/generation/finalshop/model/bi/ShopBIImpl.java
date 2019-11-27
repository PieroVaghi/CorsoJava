package com.generation.finalshop.model.bi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.common.model.bi.BIFacade;

public class ShopBIImpl implements ShopBI
{
	private static final String SQLAVG = "SELECT category, round(AVG(price),2) AS avg FROM product where category = ";
	private static final String SQLNFORCAT = "SELECT category, count(id) AS tot FROM product group by category";
	
	//questo componente è un adapter di BIFacade
	//usa BIFacade, che è una vecchia interfaccia
	//per implementare ArmyBI (che è nuova)
	//Composition
	BIFacade bi;

	ShopBIImpl(BIFacade bi) 
	{
		this.bi = bi;
	}
	
	@Override
	public Map<String, Integer> numberForCategory() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		try {
			for(Map<String, String> map : bi.rows(SQLNFORCAT)) {
//				System.out.println(map.get("category"));
//				System.out.println(map.get("tot"));
				res.put(map.get("category"), Integer.parseInt(map.get("tot")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public double average(String category) {
		try 
		{
			return bi.singleNumber(SQLAVG+"'"+category+"'");
		} 
		catch (NumberFormatException | SQLException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	
}
