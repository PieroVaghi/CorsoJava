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

	String render(List<IEntity> list);
	
}