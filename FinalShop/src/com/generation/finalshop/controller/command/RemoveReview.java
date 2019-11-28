package com.generation.finalshop.controller.command;

import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.entities.Review;

public class RemoveReview extends DomainCommand {

	@Override
	protected String execute() {
		int id = keyboard.readInt("ASKREVIEWID", 1, Integer.MAX_VALUE, "ID ERRATO!!!");
		System.out.println(id + "id");
		for(Product p : bl.list())
			for(Review r : p.getReviews())
				if(r.getId()==id) {
					p.removeReview(r);
					break;
				}
		
		for(Customer c : bl.customers())
			for(Review r : c.getReviews())
				if(r.getId()==id) {
					c.removeReview(r);
					break;
				}		
		return bl.deleteReview(id)+"";
	}

}
