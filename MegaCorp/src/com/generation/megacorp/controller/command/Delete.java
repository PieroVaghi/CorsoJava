package com.generation.megacorp.controller.command;

public class Delete extends MegacorpCommand
{


	
	@Override
	public String execute() 
	{
		
		try
		{
			System.out.println("inserisci l'ID della persona da cancellare!");
			String id = keyboard.nextLine();
			return dao.delete(Integer.parseInt(id))+"";
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}	
	}
}