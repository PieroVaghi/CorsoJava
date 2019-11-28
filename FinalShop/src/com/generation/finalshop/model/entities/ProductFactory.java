package com.generation.finalshop.model.entities;

import java.util.Map;

public class ProductFactory 
{
	private ProductFactory() {}
	
	private static ProductFactory instance = new ProductFactory();
	
	public static ProductFactory getInstance() {return instance;}
	
	//Una factory generica, non ho figli comuni
	public Product makeProduct(Map<String,String> map)
	{
		Product product = new Product();
		product.fromMap(map);

		return product;
	}
	
}