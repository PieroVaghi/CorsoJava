package com.generation.persondrama.controller.command;

public class BIavgdrama extends PersonDramaCommand {

	@Override
	protected String execute() {
		try
		{
			print("BIAVGDRAMA");
			return ""+db.singleDouble("select round(avg(totSfighe),2) media from (SELECT count(*) totSfighe FROM person INNER JOIN drama ON person.id = drama.personid group by person.id) view");
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
