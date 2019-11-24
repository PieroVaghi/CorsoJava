package com.generation.persondrama.controller.command;

public class QuitCommand extends PersonDramaCommand {

	@Override
	protected String execute() {
		print("BYE");
		System.exit(-1);
		return "";
	}



}
