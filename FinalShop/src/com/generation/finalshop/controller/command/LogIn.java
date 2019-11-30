package com.generation.finalshop.controller.command;

import com.generation.finalshop.controller.context.Context;
import com.generation.finalshop.model.entities.Customer;

public class LogIn extends DomainCommand {

	@Override
	protected String execute() {
		System.out.println(language.translate("WELCOME"));
		System.out.println(language.translate("LOGINIT"));
		boolean flag = false;
		boolean log = false;
		while(!flag) {
			String mail = keyboard.readLine("ASKMAILLOGIN");
			String pwd = keyboard.readLine("ASKPWDLOGIN");
			Customer user = bl.login(mail, pwd);
			if(user!=null) {
				Context.getInstance().put("user", user);
				log = true;
				flag = true;
			} else {
				flag = (keyboard.readLine("RETRYLOG").equalsIgnoreCase("y"))? false : true;
			}
		}
		return (log) ? language.translate("LOGSUCCESS") : language.translate("LOGFAIL");
	}

}
