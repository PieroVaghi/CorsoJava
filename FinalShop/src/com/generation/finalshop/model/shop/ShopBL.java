package com.generation.finalshop.model.shop;
import java.util.List;
import com.generation.finalshop.model.entities.*;

public interface ShopBL 
{
	List<Product> list();
	//cond sarà in JPQL
	List<Product> list(String cond);
	
	List<Customer> customers();
	
	Customer loadCustomer(int id);
	Review loadReview(int id);
	
	Product loadProduct(int id);
	
	Object save(Object object);
	
	void reOrder();
	
	Boolean deleteProduct(int id);
	Boolean deleteCustomer(int id);
	Boolean deleteJob(int id);
	Boolean deleteReview(int id);
	
}