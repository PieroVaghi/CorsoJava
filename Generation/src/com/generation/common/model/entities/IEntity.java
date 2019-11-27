package com.generation.common.model.entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface IEntity {

	/**
	 * Valid DOVRA' essere implementato ALMENO dalle figlie concrete.
	 * Ogni sottoclasse di entity dovrà dirmi: io sono valido oppure no!
	 * @return
	 */
	boolean valid();

	/**
	 * RIEMPIO IL MIO STATO CON I DATI DI UNA MAPPA
	 * @param status
	 */
	default void fromMap(Map<String, String> status)
	{
	//per ora stampo solo i dati che mi arrivano:
		
		//keyset = insieme delle chiavi
		//ad esempio: id, name, surname...
		// status.get(key) -> valore della chiave key
		// status.get("name") = "Ferdinando" nel nostro esempio
		// keyset = elenco dei campi per noi
		//System.out.println("Mi stanno arrivando questi dati, nome del campo e valore");
		//for(String key:status.keySet())
		//	System.out.println(key+":"+status.get(key));
	
		//System.out.println("Io ho questi setter, nel caso...");
		
		// chi è this? l'oggetto attuale, la Entity
		// che potrebbe essere un Employee, un Book, un CD
		// un metallaro
		
		// this.getClass() mi restituisce la mia VERA classe
		// ferdinando.getClass() -> Employee
		
		// this.getClass().getMethods() -> VETTORE di METODI
		// tutti i metodi, ereditati o no, della classe Employee
		
		//for(Method m:this.getClass().getMethods())
		//	if(m.getName().startsWith("set"))
		//		System.out.println(m.getName());
			
		//per tutti i metodi della mia classe
		for(Method method:this.getClass().getMethods())
			if(method.getName().startsWith("set"))
			{
				//ho trovato un setter, habemus gaudio
				//che chiave setta?
				String key = method.getName().replace("set","").toLowerCase();
				if(status.containsKey(key))
				{
					//oh, bello, io sono setSurname e c'è la chiave Surname
					//dico per esempio
					//sarebbe bello ora chiamare 
					// setSurname(status.get(key));
					try 
					{
						//System.out.println("Ho trovato il metodo "+method.getName());
						//System.out.println("La chiave corrispondente mi sembra essere "+key);
						//System.out.println("Il suo valore è "+status.get(key));
						//System.out.println("Sto invocando "+method.getName()+"(\""+status.get(key)+"\")");
						String type = method.getParameters()[0].getType().getSimpleName();
						//System.out.println("Il setter si aspetta un parametro di tipo "+type);
						switch(type)
						{
						case "int":
							//il setter si aspetta un int
							//lo invoco:
							//è come scrivere: this.setSalary(Integer.parseInt(status.get(key)));
							// nel caso di salary
							method.invoke(this, Integer.parseInt(status.get(key)));
							break;
						case "double":
							method.invoke(this, Double.parseDouble(status.get(key)));
							break;
						default:
							//String
							method.invoke(this, status.get(key));
						}
						//System.out.println("RIUSCITO.");
					} 
					catch (IllegalAccessException e) 
					{
						//System.out.println("Fallito");
					} 
					catch (IllegalArgumentException e) 
					{
						//System.out.println("Fallito");
					} 
					catch (InvocationTargetException e) 
					{
						//System.out.println("Fallito");
					}
					//è come dire this.method(status.get(key));
					//è come dire ferdinando.setSurname(status.get("surname"));
				}
				
			}
	}

	default Map<String,String> toMap()
	{
		Map<String,String> res = new HashMap<String,String>();
		
		for(Method m:this.getClass().getMethods())
			if(m.getName().startsWith("get"))
				try 
				{
					res.put
					(
						m.getName().replace("get","").toLowerCase(),			// nome del campo come chiave
						(m.invoke(this)!=null ? m.invoke(this).toString() : "")	// ritorno del getter come VALORE
					);
				} catch (IllegalAccessException e) 
				{
				
				} 
				catch (IllegalArgumentException e) 
				{
				} 
				catch (InvocationTargetException e) 
				{
				}
				return res;
		
	}

}