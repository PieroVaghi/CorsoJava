package com.generation.persondrama.controller.command;

public class BIavgage extends PersonDramaCommand {

	@Override
	protected String execute() {
		try
		{
			print("BIAVGAGE");
			return ""+db.singleDouble("select round(avg(age),2) media from person");
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
