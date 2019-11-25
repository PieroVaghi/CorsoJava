package com.generation.common.model.dao.deprecated;
import java.util.List;

public interface EntityDAO<E extends generation.common.entities.Entity>
{
	E load(int id) throws Exception;

	List<E> list() throws Exception;
	
	List<E> list(String condition) throws Exception;
		
	boolean delete(int id) throws Exception;
	
	boolean save(E e) throws Exception;
	
}