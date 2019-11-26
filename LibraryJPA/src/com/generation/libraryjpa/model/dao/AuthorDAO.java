package com.generation.libraryjpa.model.dao;

import java.util.List;

import com.generation.libraryjpa.model.entities.Author;

public interface AuthorDAO 
{
	//Paginato: se metto page = 1, prenderò tutti i soldier fra il primo e la dimensione di una pagina
		//ad esempio: da 1 a 500
		//con page = 2, da 501 a 1000
		
		//R
		default List<Author> list(int page)
		{
			return list("", "", page);
		}
		
		List<Author> list(String name, String nationality, int page);
		
		Author save(Author author);
		
		Author load(int id);
		
		boolean remove(Author author);
		
		default boolean remove(int id)
		{
		Author author = load(id);
			return remove(author);
		}
}
