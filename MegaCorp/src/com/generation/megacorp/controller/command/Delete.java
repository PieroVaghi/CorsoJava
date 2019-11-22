package com.generation.megacorp.controller.command;

public class Delete extends MegacorpCommand
{


	
	@Override
	public String execute() 
	{
		
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