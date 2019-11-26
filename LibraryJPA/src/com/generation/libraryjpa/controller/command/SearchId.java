package com.generation.libraryjpa.controller.command;

public class SearchId extends DomainCommand
{

	@Override
	protected String execute() 
	{
		{
			int id = keyboard.readInt("IDSEARCH", 1, Integer.MAX_VALUE, "IDERROR");


			return 
					view.render
					(
							dao.load
							(
									id

									)
							);
		}
	}
}
