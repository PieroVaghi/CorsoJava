package com.generation.finalshop.model.shop;
import java.util.List;
import com.generation.finalshop.model.entities.*;

public interface ShopBL 
{
	List<Product> list();
	//cond sar� in JPQL
	List<Product> list(String cond);
	
	List<Customer> customers();
	
	Customer loadCustomer(int id);
	
	Product loadProduct(int id);
	
	Object save(Object object);
	
	void reOrder();
	
}