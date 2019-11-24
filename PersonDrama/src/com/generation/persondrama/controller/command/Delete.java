package com.generation.persondrama.controller.command;

public class Delete extends PersonDramaCommand {

	@Override
	protected String execute() {
		try
		{
			print("DELETE");
			String id = keyboard.nextLine();
			return dao.delete(Integer.parseInt(id))+"";
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
