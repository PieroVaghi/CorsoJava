package com.generation.libraryjpa.controller.command;
public class ListCommand extends DomainCommand
{

	@Override
	protected String execute() 
	{
		return 
				view.render
				(
					dao.list
					(
						keyboard.readInt("ASKPAGE", 1, Integer.MAX_VALUE, "BADPAGE")
					)
				);
	}

}