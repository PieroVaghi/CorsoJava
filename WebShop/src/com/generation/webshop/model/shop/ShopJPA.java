package com.generation.webshop.model.shop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;
import com.generation.webshop.model.entities.Review;

public class ShopJPA implements ShopBL
{
	EntityManager em;
	
	public ShopJPA(String persistanceUnit)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(persistanceUnit);
	    em = emfactory.createEntityManager();
	}
	

	@Override
	public List<Product> products() 
	{
		return (List<Product>) em.createNamedQuery("Product.findAll").getResultList();
	}

	@Override
	public Product load(int id) 
	{
		return (Product) em.find(Product.class, id);
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
	public Customer login(String email, String password)
	{
		List<Customer> list = em.createQuery("select c from Customer c where c.email='"+email+"' and c.password='"+password+"'").getResultList();
		return list.size()==0 ? null : list.get(0);
	}


	@Override
	public Review loadReview(int id) {
		return em.find(Review.class, id);
	}


	@Override
	public Boolean deleteReview(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Review.class, id));
			em.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public Boolean deleteProduct(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Product.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public Customer loadCustomer(int id) {
		return em.find(Customer.class, id);
	}

	
	
}