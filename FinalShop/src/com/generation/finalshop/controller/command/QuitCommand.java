package com.generation.finalshop.controller.command;
import java.sql.SQLException;

public class QuitCommand extends DomainCommand
{

	@Override
	protected String execute() 
	{
		try 
		{
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyboard.close();
		System.out.println(language.translate("QUITCOMMAND"));
		System.exit(0);
		return "";
	}

	
}