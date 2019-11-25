package com.generation.megacorp.controller.main;

import java.util.Scanner;

import com.generation.common.controller.command.Behaviour;
import com.generation.megacorp.controller.context.Context;
import com.generation.megacorp.model.view.EmployeeView;

import generation.common.view.language.BasicLanguage;
import generation.common.view.language.Language;


public class Main 
{
	
	
	private static Behaviour behaviour = (Behaviour) Context.getInstance().get("behaviour");
	private static Scanner keyboard = (Scanner) Context.getInstance().get("keyboard");
	private static BasicLanguage _language = (BasicLanguage) Context.getInstance().get("language");
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(_language.translate("INTRO"));
		while(true) {
			System.out.println(_language.translate("ASKCOMMAND"));
			System.out.println(behaviour.get(keyboard.nextLine()).run());
		}
	}

}
