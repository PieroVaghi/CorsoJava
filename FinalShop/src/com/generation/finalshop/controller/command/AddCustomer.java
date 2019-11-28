package com.generation.finalshop.controller.command;

import java.util.HashMap;
import java.util.Map;

import com.generation.finalshop.model.entities.Customer;

public class AddCustomer extends DomainCommand{
	

		@Override
		protected String execute() {
			Map<String,String> map = new HashMap<String,String>();
			
			map.put("name", keyboard.readLine("ASKCUSTOMERNAME"));
			map.put("surname", keyboard.readLine("ASKCUSTOMERSURNAME"));
			map.put("email", keyboard.readLine("ASKCUSTOMERMAIL"));
			map.put("password", keyboard.readLine("ASKCUSTOMERPWD"));
			Customer c = (Customer) fs.make("Customer",map);

			return bl.save(c)+"";
		}

}
