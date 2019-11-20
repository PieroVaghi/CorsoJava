package generation.common.importer;

import java.util.ArrayList;
import java.util.List;

import generation.common.entities.Entity;

public class ImportResult<E extends Entity> 
{
	List<E> valid = new ArrayList<E>();
	List<E> invalid = new ArrayList<E>();
	List<String> errors = new ArrayList<String>();
	
	
	public List<E> getValid() {
		return valid;
	}
	public void setValid(List<E> valid) {
		this.valid = valid;
	}
	public List<E> getInvalid() {
		return invalid;
	}
	public void setInvalid(List<E> invalid) {
		this.invalid = invalid;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
	
}