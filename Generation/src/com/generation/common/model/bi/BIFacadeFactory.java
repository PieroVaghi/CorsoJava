package com.generation.common.model.bi;

import java.sql.Connection;

public abstract class BIFacadeFactory 
{
	//Applico il pattern factory
	//il mio Product, stavolta, è un BIFacade
	//la Facade, per la factory, è un prodotto
	//non voglio che il client si crei la facade da solo
	//e infatti il costruttore è package. Non si può creare la facade da fuori
	//l'unico modo per creare un BIFacade è tramite questo metodo
	public static BIFacade make(String dbpath) throws Exception
	{
		return new StandardBI(dbpath);
	}

	public static BIFacade make(Connection connection) throws Exception
	{
		return new StandardBI(connection);
	}

	
}