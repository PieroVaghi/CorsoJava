package com.generation.schoolJPA.test.jpatest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.schoolJPA.model.dao.StudentDAO;
import com.generation.schoolJPA.model.dao.StudentDAOJPA;
import com.generation.schoolJPA.model.entities.Mark;
import com.generation.schoolJPA.model.entities.Student;

public class Test 
{

	public static void main(String[] args) 
	{
		// EntityManager = DAO automatico
		//Leggi la tua configurazione da persistence.xml, e prendi i dati di "AOD2"
		//la mia persistence unit
		
		//lettura di UN oggetto, equivalente al load
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SchoolJPA");
	    EntityManager em = emfactory.createEntityManager();
		
	    StudentDAO dao = new StudentDAOJPA(em, 100);
	  	    
	    Student stu = dao.load(1);
	    System.out.println(stu.getMarks());
	    
	    Student s = dao.load(4);
	    s.setSurname("Primerano");
	    
//	    Mark c = new Mark();
//	    c.setSubject("StreetFighter");
//	    c.setGrade(11);
	    
//	    s.addMark(c);
	    
//	    System.out.println(dao.save(s));
	    System.out.println(dao.list("","",0));
	    
	    em.close();
	    
	}

}