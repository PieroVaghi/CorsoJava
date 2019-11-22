package com.generation.megacorp.controller.command;


public class Search extends MegacorpCommand
{


	
	@Override
	public String execute() 
	{
		
		try
		{
			print("SEARCHMAIN");
			String search = keyboard.nextLine();
			if(search.equalsIgnoreCase("cognome")) {
				print("SEARCHSURNAME");
				String nome = keyboard.nextLine();
				return view.render(dao.list("surname='"+nome+"'"));
			}
			if(search.equalsIgnoreCase("ruolo")) {
				print("SEARCHROLE");
				String role = keyboard.nextLine();
				return view.render(dao.list("role='"+role+"'"));
			}
			return lan.translate("SEQRCHERROR");
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}	
	}
}
