package generation.common.view;

import java.util.List;
import java.util.Map;

import generation.common.entities.Entity;

public interface View<E extends Entity> 
{
	/**
	 * traduce una stringa in una lingua
	 * @param key
	 * @return
	 */
	String translate(String key);	
	
	/**
	 * TUTTA la classe, tranne translate, dipende da questo metodo
	 * restituisce una mappa con chiave nome della classe e valore il template per graficarla
	 * @return
	 */
	Map<String,String> getTemplates();
	
	/**
	 * GRAFICA, cio� trasforma in Stringa, una Entity
	 * @param e
	 * @return
	 */
	default String render(E e)
	{
		String name = e.getClass().getSimpleName();
		return 	getTemplates().containsKey(name)		?
				fill(e,getTemplates().get(name))+"\n"	:
				e.toString()+"\n"						;
	}
	
	
	
	
	default String fill(E e, String template)
	{
		String res = template;
		for(String key:e.toMap().keySet())
			res = res.replace("["+key+"]", e.toMap().get(key));
		return res;		
	}

	/**
	 * RENDERIZZA una LISTA di Entities
	 * @param list
	 * @return
	 */
	default String render(List<E> list)
	{
		String res = "";
		for(E e:list)
			res+=render(e);
		return res;
	}
	
	
}