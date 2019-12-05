package com.generation.pe.model.bl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.pe.model.entities.Expense;
import com.generation.pe.model.entities.User;

public class peJPA implements peBL {
	
	EntityManager em;
	
	public peJPA(String persistanceUnit)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(persistanceUnit);
	    em = emfactory.createEntityManager();
	}

	@Override
	public User load(int id) {
		return (User) em.find(User.class, id);
	}

	@Override
	public Object save(Object obj)
	{
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		return obj;
	}

	@Override
	public List<User> list() {
		return (List<User>) em.createNamedQuery("User.findAll").getResultList();
	}

	@Override
	public User login(String email, String password) {
		List<User> list = em.createQuery("select c from User c where c.email='"+email+"' and c.password='"+password+"'").getResultList();
		return list.size()==0 ? null : list.get(0);
	}

	@Override
	public Expense loadExpence(int id) {
		return (Expense) em.find(Expense.class, id);
	}

	public boolean delete(Object obj)
	{
		
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		return true;
	}
}
