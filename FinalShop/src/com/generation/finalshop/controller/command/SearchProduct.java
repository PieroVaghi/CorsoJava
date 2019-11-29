package com.generation.finalshop.controller.command;

import com.generation.finalshop.model.entities.Product;

public class SearchProduct extends DomainCommand{

	@Override
	protected String execute() {
		
		String search = keyboard.readLine("ASKSEARCHFIELD");
		String condition = "where " + search + " = ";
		switch (search) {
		case "id":
			return view.render((Product) bl.list(condition + keyboard.readInt("SEARCHPRODUCTID",1,Integer.MAX_VALUE,"ID ERRATO")));
		case "name":
			return view.render((Product) bl.list(condition + keyboard.readLine("ASKPRODUCTNAME")));
		case "maxprice":
			return view.render((Product) bl.list(condition + keyboard.readInt("ASKMAXPRICE",1,Integer.MAX_VALUE,"VALUE ERRATO")));
		case "minprice":
			return view.render((Product) bl.list(condition + keyboard.readInt("ASKMINPRICE",1,Integer.MAX_VALUE,"VALUE ERRATO")));
		default: 
			return language.translate("SEARCHFAIL");
		}

	}

}
