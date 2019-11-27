package com.generation.common.model.entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity implements IEntity 
{
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Valid DOVRA' essere implementato ALMENO dalle figlie concrete.
	 * Ogni sottoclasse di entity dovrà dirmi: io sono valido oppure no!
	 * @return
	 */
	@Override
	public abstract boolean valid();
	
	//metodi per validare le entities...
	//verranno usati principalmente nelle classi figlie
	//ma li lascio pubblici per un discorso di comodità.
	public static boolean notVoid(String value)
	{
		return value!=null && !value.trim().contentEquals("");
	}
	
	//verifica se un valore è compreso fra un massimo e un minimo
	public static boolean between(double value, double min, double max)
	{
		return value>=min && value<=max;
	}
	
	public static boolean validEmail(String email)
	{
		//email: non è vuota
		//ha una chiocciolina a partire dalla posizione 2 in poi (indexof = posizione di @ in email)
		//ha un punto DOPO la chiocciolina
		//c'è qualcosa dopo il punto
		String fromAt = email.substring(email.indexOf("@"),email.length());
		return 		notVoid(email) 							&& 
					email.indexOf("@")>0 					&& 
					fromAt.indexOf(".")>0				 	&& 
					fromAt.indexOf(".")!=fromAt.length()-1	&&
					fromAt.indexOf(".") != 1				&&
					email.indexOf(" ")<0					&&
					email.split("@").length==2				;
	}
	
	//verifica se un elemento appartiene a un insieme.
	public static boolean belongs(String value, String[] set)
	{
		for(String v:set)
			if(v.contentEquals(value))
				return true;
		return false;
	}


	

	
	
	
}