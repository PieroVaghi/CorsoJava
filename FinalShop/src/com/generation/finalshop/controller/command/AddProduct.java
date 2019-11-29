package com.generation.finalshop.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.generation.finalshop.model.entities.Product;

public class AddProduct extends DomainCommand{
	

		@Override
		protected String execute() {
			Map<String,String> map = new HashMap<String,String>();
			
			map.put("name", keyboard.readLine("ASKPRODUCTNAME"));
			map.put("description", keyboard.readLine("ASKPRODUCTDESCRIPTION"));
			map.put("quantity", keyboard.readLine("ASKPRODUCTQUANTITY"));
			map.put("price", keyboard.readLine("ASKPRODUCTPRICE"));
			map.put("category", keyboard.readLine("ASKPRODUCTCATEGORY"));


			return bl.save((Product) fs.make("Product", map))+"";
		}

}