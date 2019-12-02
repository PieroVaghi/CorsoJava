package com.generation.firefighter.model.fireBL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.firefighter.model.entities.Fireman;


public class FireJPA implements FireBL
{
	EntityManager em;
	
	public FireJPA(String persistanceUnit)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(persistanceUnit);
	    em = emfactory.createEntityManager();
	}
	

	@Override
	public List<Fireman> firemans() 
	{
		return (List<Fireman>) em.createNamedQuery("Fireman.findAll").getResultList();
	}

	@Override
	public Fireman load(int id) 
	{
		return (Fireman) em.find(Fireman.class, id);
	}

	@Override
	public Object save(Object obj)
	{
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		return obj;
	}

	
	
}