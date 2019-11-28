package com.generation.finalshop.controller.command;

public class AskCommand extends DomainCommand
{

	@Override
	protected String execute() 
	{
		return keyboard.readLine("ASKCOMMAND");
	}

}