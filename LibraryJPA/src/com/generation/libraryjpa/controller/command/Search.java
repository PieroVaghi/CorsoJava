package com.generation.libraryjpa.controller.command;

public class Search extends DomainCommand{

	

	@Override
	protected String execute() {
		{
			String name = keyboard.readLine("INSERTNAME");
			String nationality = keyboard.readLine("INSERTNATIONALITY");
			
			return 
					view.render
					(
							dao.list
							(
									name, nationality,
									keyboard.readInt("ASKPAGE", 1, Integer.MAX_VALUE, "BADPAGE")
									)
							);
		}
	}
}
	
