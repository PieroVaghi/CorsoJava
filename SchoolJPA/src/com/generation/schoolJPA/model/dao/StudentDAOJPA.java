package com.generation.schoolJPA.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.generation.schoolJPA.model.entities.Student;


public class StudentDAOJPA implements StudentDAO
{
	//CONTENGO UN ENTITYMANAGER
	//è una mia dipendenza
	EntityManager em;
	int pagesize;
	
	public StudentDAOJPA(EntityManager em, int pagesize)
	{
		this.em = em;
		this.pagesize = pagesize;
	}
	

	@Override
	public List<Student> list(String name, String year, int page) 
	{
		//per ora la pagina la ignoro
		
		String jpql = "select s from Student s where s.id>"+ (page-1)*pagesize;
		if(name!=null && !name.contentEquals(""))
			jpql+=" and s.name='"+name+"' ";
		if(year!=null && !year.contentEquals(""))
			jpql+=" and s.year="+year+" ";
//		System.out.println(jpql);
		TypedQuery<Student> query = em.createQuery(jpql, Student.class);    
		query.setMaxResults(pagesize);

		return query.getResultList();
	}

	@Override
	public Student save(Student student)
	{
		em.getTransaction().begin(); //inizio operazione di modifica
		em.persist(student);
		em.getTransaction().commit(); //esegui davvero
		//restituisco il soldato modificato, aggiornato con id ecc...
		return student;
	}

	@Override
	public Student load(int id) 
	{
		return (Student) em.find(Student.class, id);
	}

	@Override
	public boolean remove(Student student) 
	{
		try
		{
			em.getTransaction().begin(); //inizio operazione di modifica
			em.remove(student);
			em.getTransaction().commit(); //esegui davvero
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}