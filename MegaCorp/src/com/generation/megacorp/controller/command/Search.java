package com.generation.megacorp.controller.command;


public class Search extends MegacorpCommand
{


	
	@Override
	public String execute() 
	{
		
		try
		{
			System.out.println("Vuoi cercare per cognome o per ruolo?");
			String search = keyboard.nextLine();
			if(search.equalsIgnoreCase("cognome")) {
				System.out.println("Inserisci il cognome:");
				String nome = keyboard.nextLine();
				return view.render(dao.list("surname='"+nome+"'"));
			}
			if(search.equalsIgnoreCase("ruolo")) {
				System.out.println("Inserisci il ruolo:");
				String role = keyboard.nextLine();
				return view.render(dao.list("role='"+role+"'"));
			}
			return "Ricerca non valida";
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}	
	}
}
