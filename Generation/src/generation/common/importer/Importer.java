package generation.common.importer;

import generation.common.entities.Entity;

/**
 * Un importer è una classe che genera oggetti 
 *aventi un metodo absord. Il metodo absord restituisce un ImportResult
 * @author FreePC
 *
 * @param <E>
 */
public interface Importer<E extends Entity> 
{
	ImportResult<E> absorb();
	
	
}