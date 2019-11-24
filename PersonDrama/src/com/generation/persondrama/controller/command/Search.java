package com.generation.persondrama.controller.command;

public class Search extends PersonDramaCommand {

	@Override
	protected String execute() {
		try
		{
			print("SEARCHMAIN");
			String search = keyboard.nextLine();
			switch(search) {
			case "cognome" : 
				print("SEARCHSURNAME");
				String surname = keyboard.nextLine();
				if(dao.list("surname='"+surname+"'").isEmpty())
					print("NORESULTS");
				return view.render(dao.list("surname='"+surname+"'"));
			case "età" :
				print("SEARCHAGE");
				String age = keyboard.nextLine();
				if(dao.list("age='"+age+"'").isEmpty())
					print("NORESULTS");
				return view.render(dao.list("age='"+age+"'"));
			default :
				print("SEARCHERROR");
				break;
			}
			return lan.translate("SEARCHERROR");
			
		}
		catch(Exception e)
		{
			return e.getMessage();
		}	
	}

}
