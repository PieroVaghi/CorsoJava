package com.generation.finalshop.model.bi;

import java.util.Map;

// ottenetelo adattando (ADAPTER) BIFacade
public interface ShopBI 
{

	// esempio: Smartwatch 50000
	Map<String,Integer> numberForCategory();
	
	// esempio: average cost for category
	double average(String category);
	
	
	
}