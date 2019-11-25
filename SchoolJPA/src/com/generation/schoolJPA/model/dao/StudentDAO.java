package com.generation.schoolJPA.model.dao;

import java.util.List;

import com.generation.schoolJPA.model.entities.Student;

public interface StudentDAO 
{
	//Paginato: se metto page = 1, prenderò tutti i Student fra il primo e la dimensione di una pagina
	//ad esempio: da 1 a 500
	//con page = 2, da 501 a 1000
	
	//R
	default List<Student> list(int page)
	{
		return list("", "", page);
	}
	
	List<Student> list(String race, String profession, int page);
	
	Student save(Student student);
	
	Student load(int id);
	
	boolean remove(Student student);
	
	default boolean remove(int id)
	{
		Student student = load(id);
		return remove(student);
	}
	
	
}