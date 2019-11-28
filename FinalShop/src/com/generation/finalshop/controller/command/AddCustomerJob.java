package com.generation.finalshop.controller.command;

import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;

public class AddCustomerJob extends DomainCommand {

	@Override
	protected String execute() {
		int id = keyboard.readInt("ASKCUSTOMERID", 0, Integer.MAX_VALUE, "ID non Corretto!");
		Customer c = bl.loadCustomer(id);
		
		Job j = (Job) fs.make("Job", null);
		j.setCustomer(c);
		j.setRole(keyboard.readLine("ASKJOBROLE"));
		j.setCategory(keyboard.readLine("ASKJOBCATEGORY"));
		
		c.setJob(j);
		bl.save(c);
		bl.save(j);
		return "OK";
	}
	
	

}
