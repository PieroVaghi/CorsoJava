package com.generation.libraryjpa.model.bi;

import com.generation.common.model.bi.BIFacade;

public abstract class FactoryLibraryBI 
{
	public static LibraryBI make(BIFacade oldcomponent)
	{
		return new LibraryBIImpl(oldcomponent);
		
	}
}
