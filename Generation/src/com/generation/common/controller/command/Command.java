package com.generation.common.controller.command;

public abstract class Command 
{
	//init prenderà le dipendenze da Context... ma non le prenderà in fase di creazione
	//ma quando verrà eseguito run. DOPO
	protected abstract void init();
	
	// execute eseguirà
	protected abstract String execute();
	
	//OBBLIGA il componente Command a eseguire PRIMA init e poi execute.
	//questo metodo verrà eseguito che il context sarà già COMPLETO
	//PATTERN: Template Method... ne parleremo
	public String run()
	{
		init();
		return execute();
	}
	
}