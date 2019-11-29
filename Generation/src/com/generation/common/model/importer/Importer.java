package com.generation.common.model.importer;
/**
 * Un importer è una classe che genera oggetti 
 *aventi un metodo absord. Il metodo absord restituisce un ImportResult
 * @author FreePC
 *
 * @param <E>
 */
public interface Importer
{
	ImportResult absorb();
	
	
}