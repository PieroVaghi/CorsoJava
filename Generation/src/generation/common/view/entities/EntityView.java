package generation.common.view.entities;

import java.util.List;
import java.util.Map;

import generation.common.entities.Entity;

public interface EntityView<E extends Entity> 
{
	
	/**
	 * TUTTA la classe, tranne translate, dipende da questo metodo
	 * restituisce una mappa con chiave nome della classe e valore il template per graficarla
	 * @return
	 */
	Map<String,String> getTemplates();
	
	/**
	 * GRAFICA, cioè trasforma in Stringa, una Entity
	 * @param e
	 * @return
	 */
	default String render(E e)
	{
		String name = e.getClass().getSimpleName();
		return 	getTemplates().containsKey(name)		?
				fill(e,getTemplates().get(name))		:
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