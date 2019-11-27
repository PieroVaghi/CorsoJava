package com.generation.common.model.importer;

import com.generation.common.model.entities.IEntity;

/**
 * Un importer è una classe che genera oggetti 
 *aventi un metodo absord. Il metodo absord restituisce un ImportResult
 * @author FreePC
 *
 * @param <E>
 */
public interface Importer<E extends IEntity> 
{
	ImportResult<E> absorb();
	
	
}