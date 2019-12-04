package com.generation.webshop.model.shop;

import java.util.List;

import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;
import com.generation.webshop.model.entities.Review;

public interface ShopBL 
{
	List<Product> products();
	Product load(int id);
	Review loadReview(int id);
	Customer loadCustomer(int id);
	// Em salva qualunque cosa.
	Object save(Object obj);
	Customer login(String email, String password);
	List<Product> findSimilar(int id);
	boolean delete(Object obj);
	
}