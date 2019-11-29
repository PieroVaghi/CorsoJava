package com.generation.finalshop.controller.command;

import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;

import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.entities.Review;

public class AddProductReview extends DomainCommand {

	@Override
	protected String execute() {
		if(autorized("Costumer")) {
			int idp = keyboard.readInt("ASKPRODUCTID", 0, Integer.MAX_VALUE, "ID non Corretto!");
			Product p = bl.loadProduct(idp);
			int idc = keyboard.readInt("ASKCUSTOMERID", 0, Integer.MAX_VALUE, "ID non Corretto!");
			Customer c = bl.loadCustomer(idc);
			
			Review r = (Review) fs.make("Review", null);
			r.setProduct(p);
			r.setCustomer(c);
			r.setTitle(keyboard.readLine("ASKREVIEWTITLE"));
			r.setContent(keyboard.readLine("ASKREVIEWCONTENT"));
			r.setStars(keyboard.readInt("ASKREVIWESTARS",0,5,"Non sai Leggere"));
			
			c.addReview(r);
			p.addReview(r);
			return bl.save(r)+"";
		} else {
			return language.translate("NOTAUTORIZED");
		}
	}
	
	

}
