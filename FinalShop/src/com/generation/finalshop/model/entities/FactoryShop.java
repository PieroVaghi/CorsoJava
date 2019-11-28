package com.generation.finalshop.model.entities;

import java.util.Map;

import com.generation.common.model.entities.IEntity;

public class FactoryShop
{
	
	private FactoryShop(String type) {}
			
	private static FactoryShop instance = new FactoryShop("");
	
	public static FactoryShop getInstance() {return instance;}
	
	
	public IEntity make (String type, Map<String,String> map) {
		switch(type) {
			case "Customer":
				if(map != null)
					return makeCustomer(map);
				else
					return new Customer();
			case "Job":
				if(map != null)
					return makeJob(map);
				else
					return new Job();
			case "Product":
				if(map != null)
					return makeProduct(map);
				else
					return new Product();
			case "Review":
				if(map != null)
					return makeReview(map);
				else
					return new Review();
			default:
				return makeReview(null);
		}
	}
	
	//Una factory per Customer, non ho figli comuni
	private Customer makeCustomer(Map<String,String> map)
	{
		Customer customer = new Customer();
		customer.fromMap(map);

		return customer;
	}
	
	
	//Una factory Job, non ho figli comuni
	private Job makeJob(Map<String,String> map)
	{
		Job job = new Job();
		job.fromMap(map);

		return job;
	}
	
	//Una factory Review, non ho figli comuni
	private Review makeReview(Map<String,String> map)
	{
		Review review = new Review();
		review.fromMap(map);

		return review;
	}
		
	//Una factory Product, non ho figli comuni
	private Product makeProduct(Map<String,String> map)
	{
		Product product = new Product();
		product.fromMap(map);

		return product;
	}
	
}