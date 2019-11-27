package com.generation.common.model.importer;

import java.util.ArrayList;
import java.util.List;

import com.generation.common.model.entities.IEntity;

/**
 * Questa classe è il tipo di ritorno di una operazione di importazione
 * l'operazione di importazione genera non una, ma tre liste
 * una lista di entità valide
 * una lista di entità non valide
 * una lista di errori di importazione per cui non sono riuscito a creare entità
 * @author Ferdinando
 *
 * @param <E>
 */
public class ImportResult<E extends IEntity> 
{
		
	List<E> valid = new ArrayList<E>();
	List<E> invalid = new ArrayList<E>();
	List<String> errors = new ArrayList<String>();
	
	/**
	 * 
	 * @return
	 */
	public List<E> getValid() {
		return valid;
	}
	
	/**
	 * 
	 * @param valid
	 */
	public void setValid(List<E> valid) {
		this.valid = valid;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<E> getInvalid() {
		return invalid;
	}
	/**
	 * 
	 * @param invalid
	 */
	public void setInvalid(List<E> invalid) {
		this.invalid = invalid;
	}
	/**
	 * 
	 * @return
	 */
	public List<String> getErrors() {
		return errors;
	}
	/**
	 * 
	 * @param errors
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
	
}