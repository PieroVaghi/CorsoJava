package com.generation.libraryjpa.controller.command;
public class AskCommand extends DomainCommand
{

	@Override
	protected String execute() 
	{
		return keyboard.readLine("ASKCOMMAND");
	}

}