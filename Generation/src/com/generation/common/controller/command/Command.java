package com.generation.common.controller.command;

import com.generation.common.model.log.Event;
import com.generation.common.model.log.Log;

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
		String res = execute();
		Log.getInstance().addEvent(new Event(System.nanoTime(),"Executed "+this.getClass().getName()+":"+res));
		return res;
	}
	
}