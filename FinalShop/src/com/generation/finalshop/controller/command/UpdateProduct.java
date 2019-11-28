package com.generation.finalshop.controller.command;
import java.util.HashMap;
import java.util.Map;

import com.generation.finalshop.model.entities.Product;

public class UpdateProduct extends DomainCommand{
	

		@Override
		protected String execute() {
			Product p = bl.loadProduct(keyboard.readInt("ASKPRODUCTUPDATEID", 1, Integer.MAX_VALUE, "ID Errato"));
					
			String name = keyboard.readLine("ASKUPDATENAMEOREMPTY");	
			String description = keyboard.readLine("ASKUPDATEDESCRIPTIONOREMPTY");
			String quantity = keyboard.readLine("ASKUPDATEQUANTITYOREMPTY");
			String price = keyboard.readLine("ASKUPDATEPRICEOREMPTY");
			String category = keyboard.readLine("ASKUPDATECATEGORYOREMPTY");
			
			if(!name.isEmpty())
				p.setName(name);
			if(!description.isEmpty())
				p.setDescription(description);
			if(!quantity.isEmpty())
				p.setQuantity(Integer.parseInt(quantity));
			if(!price.isEmpty())
				p.setPrice(Integer.parseInt(price));
			if(!category.isEmpty())
				p.setName(category);
			
			return bl.save(p)+"";
		}

}