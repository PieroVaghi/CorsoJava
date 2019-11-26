package com.generation.libraryjpa.controller.command;

public class TotalCost extends DomainCommand
{

	@Override
	protected String execute() 
	{
		return language.translate("TOTALCOST")+" "+(long)librarybi.totalPriceLib();
	}

}