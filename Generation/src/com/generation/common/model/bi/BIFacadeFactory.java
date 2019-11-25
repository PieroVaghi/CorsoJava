package com.generation.common.model.bi;

import java.sql.Connection;

public abstract class BIFacadeFactory 
{
	//Applico il pattern factory
	//il mio Product, stavolta, � un BIFacade
	//la Facade, per la factory, � un prodotto
	//non voglio che il client si crei la facade da solo
	//e infatti il costruttore � package. Non si pu� creare la facade da fuori
	//l'unico modo per creare un BIFacade � tramite questo metodo
	public static BIFacade make(String dbpath) throws Exception
	{
		return new StandardBI(dbpath);
	}

	public static BIFacade make(Connection connection) throws Exception
	{
		return new StandardBI(connection);
	}

	
}