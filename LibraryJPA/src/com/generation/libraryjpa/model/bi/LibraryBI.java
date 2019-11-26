package com.generation.libraryjpa.model.bi;

import java.util.List;
import java.util.Map;

public interface LibraryBI 
{
	List <Map<String,Integer>> libList();
	
	String avgPriceForGenre();

	int totalPriceLib();
}
