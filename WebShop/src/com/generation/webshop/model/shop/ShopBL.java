package com.generation.webshop.model.shop;

import java.util.List;

import com.generation.webshop.model.entities.Review;
import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.entities.Product;

public interface ShopBL 
{
	List<Product> products();
	Product load(int id);
	Customer loadCustomer(int id);
	// Em salva qualunque cosa.
	Object save(Object obj);
	Customer login(String email, String password);
	Review loadReview(int id);
	Boolean deleteReview(int id);
	Boolean deleteProduct(int id);
}