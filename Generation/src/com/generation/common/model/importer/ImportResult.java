package com.generation.common.model.importer;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe � il tipo di ritorno di una operazione di importazione
 * l'operazione di importazione genera non una, ma tre liste
 * una lista di entit� valide
 * una lista di entit� non valide
 * una lista di errori di importazione per cui non sono riuscito a creare entit�
 * @author Ferdinando
 *
 * @param <E>
 */
public class ImportResult
{
		
	List<Object> valid = new ArrayList<Object>();
	List<Object> invalid = new ArrayList<Object>();
	List<String> errors = new ArrayList<String>();
	
	/**
	 * 
	 * @return
	 */
	public List<Object> getValid() {
		return valid;
	}
	
	/**
	 * 
	 * @param valid
	 */
	public void setValid(List<Object> valid) {
		this.valid = valid;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<Object> getInvalid() {
		return invalid;
	}
	/**
	 * 
	 * @param invalid
	 */
	public void setInvalid(List<Object> invalid) {
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