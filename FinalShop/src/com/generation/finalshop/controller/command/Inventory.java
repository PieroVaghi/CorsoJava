package com.generation.finalshop.controller.command;

import com.generation.finalshop.model.entities.Product;

public class Inventory extends DomainCommand {

	@Override
	protected String execute() {
		return view.render((Product) bl.products());
	}

}
