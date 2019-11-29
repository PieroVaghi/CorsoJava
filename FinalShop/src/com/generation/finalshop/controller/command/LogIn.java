package com.generation.finalshop.controller.command;

import com.generation.finalshop.controller.context.Context;
import com.generation.finalshop.model.entities.Customer;

public class LogIn extends DomainCommand {

	@Override
	protected String execute() {
		String mail = keyboard.readLine("ASKMAILLOGIN");
		String pwd = keyboard.readLine("ASKPWDLOGIN");
		Customer user = bl.login(mail, pwd);
		if(user!=null) {
			Context.getInstance().put("user", user);
			return "LOG SUCCESS";
		} else {
			return "LOG FAIL";
		}
	}

}
