package com.generation.pe.controller.context;

import com.generation.pe.controller.servlet.command.AddExpense;
import com.generation.pe.controller.servlet.command.BadRequest;
import com.generation.pe.controller.servlet.command.Behaviour;
import com.generation.pe.controller.servlet.command.FormLogin;
import com.generation.pe.controller.servlet.command.ListProfile;
import com.generation.pe.controller.servlet.command.Login;
import com.generation.pe.controller.servlet.command.Logout;
import com.generation.pe.controller.servlet.command.NotFound;
import com.generation.pe.controller.servlet.command.OwnProfile;
import com.generation.pe.controller.servlet.command.RemoveExpense;
import com.generation.pe.controller.servlet.command.WebCommand;
import com.generation.pe.model.bl.peJPA;

public class Context extends com.generation.common.controller.context.Context
{
	private static Context instance = new Context();
	
	public static Context getInstance() {return instance;}
	
	private Context()
	{
		put("pe", new peJPA("PE"));
		
		put
		(
				"behaviour", 
				new Behaviour
				(
						new String[] 	 {	"notfound","formlogin","login","logout",
											"ownprofile","deleteexpense","badrequest",
											"addexpense","listprofile"}, 
						new WebCommand[] {	new NotFound(), new FormLogin(), new Login(), new Logout(),
											new OwnProfile(), new RemoveExpense(), new BadRequest(),
											new AddExpense(), new ListProfile()}
				)
		);
	
	}
	
	
	
	
}