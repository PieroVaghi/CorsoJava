package com.generation.finalshop.model.shop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;
import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.entities.Review;

public class ShopJPA implements ShopBL
{
	EntityManager em;

	
	
	public ShopJPA(EntityManager em) {
		super();
		this.em = em;
	}

	public EntityManager getEm() 
	{
		return em;
	}

	public void setEm(EntityManager em) 
	{
		this.em = em;
	}


	@Override
	public List<Product> list(String cond) {
		String jpql = "SELECT c FROM Product AS c "+cond;
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);    
		return query.getResultList();
	}

	@Override
	public List<Customer> customers() {
		String jpql = "SELECT c FROM Customer AS c";
		TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);    
		return query.getResultList();
	}
	
	@Override
	public List<Product> products() {
		String jpql = "SELECT p FROM Product AS p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);    
		return query.getResultList();
	}

	@Override
	public Customer loadCustomer(int id) 
	{
		return em.find(Customer.class, id);
	}

	@Override
	public Product loadProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public void reOrder() 
	{
		// TODO Auto-generated method stub
		
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
	public Boolean deleteJob(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Job.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
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
	public Boolean deleteCustomer(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Customer.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Object save(Object object) 
	{
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		return object;
	}

	@Override
	public Review loadReview(int id) {
		return em.find(Review.class, id);
	}

	
	

}