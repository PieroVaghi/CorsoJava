package com.generation.finalshop.controller.command;

public class QuantityForCategory extends DomainCommand{

	@Override
	protected String execute() 
	{
		return shopbi.numberForCategory()+"";
	}
}
