package com.generation.finalshop.controller.command;


import com.generation.finalshop.model.entities.Product;

public class Inventory extends DomainCommand {

	@Override
	protected String execute() {
		String res = "";
		for(Product p : bl.products())
			res  += view.render(p);
		return res;
	}

}
