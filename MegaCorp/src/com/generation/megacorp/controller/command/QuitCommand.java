package com.generation.megacorp.controller.command;


public class QuitCommand extends MegacorpCommand
{

	@Override
	public String execute()
	{
		System.out.println("BYE");
		System.exit(-1);
		return "";
	}

	
	
}