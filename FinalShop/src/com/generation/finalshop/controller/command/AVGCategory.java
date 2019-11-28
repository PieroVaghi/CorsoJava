package com.generation.finalshop.controller.command;

public class AVGCategory extends DomainCommand{

	@Override
	protected String execute() 
	{
		return language.translate("AVGCATEGORYBI")+" "+shopbi.average(keyboard.readLine("ASKCATEGORYBI"));
	}
}
