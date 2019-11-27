package com.generation.finalshop.model.shop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Product;

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
	public List<Product> list() {
		String jpql = "SELECT c FROM Product AS c";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);    
		return query.getResultList();
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
	public Object save(Object object) 
	{
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		return object;
	}
	

}