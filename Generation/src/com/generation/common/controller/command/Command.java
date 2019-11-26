package com.generation.common.controller.command;

import com.generation.common.model.log.Event;
import com.generation.common.model.log.Log;

public abstract class Command 
{
	//init prender� le dipendenze da Context... ma non le prender� in fase di creazione
	//ma quando verr� eseguito run. DOPO
	protected abstract void init();
	
	// execute eseguir�
	protected abstract String execute();
	
	//OBBLIGA il componente Command a eseguire PRIMA init e poi execute.
	//questo metodo verr� eseguito che il context sar� gi� COMPLETO
	//PATTERN: Template Method... ne parleremo
	public String run()
	{
		init();
		String res = execute();
		Log.getInstance().addEvent(new Event(System.nanoTime(),"Executed "+this.getClass().getName()+":"+res));
		return res;
	}
	
}