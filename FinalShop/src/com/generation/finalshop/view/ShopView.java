package com.generation.finalshop.view;
import java.util.List;

import com.generation.common.model.entities.IEntity;
import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;
import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.entities.Review;


public interface ShopView {

	String render(Product product);

	String render(Customer customer);
	
	String render(Review review);
	
	String render(Job job);

	default String render(List<IEntity> list) {
		String res = "";
		for(IEntity ie:list) {
			if (ie instanceof Product) 	
				res+=render((Product)ie);
			if (ie instanceof Customer) 	
				res+=render((Customer)ie);
			if (ie instanceof Job) 	
				res+=render((Job)ie);
			if (ie instanceof Review) 	
				res+=render((Review)ie);
		}
		return res;
	};
	
}