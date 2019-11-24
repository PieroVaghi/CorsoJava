package com.generation.persondrama.controller.command;

import com.generation.persondrama.model.entities.Person;

public class RandomInsert extends PersonDramaCommand {

	@Override
	protected String execute() {
		
		boolean res = true;
		System.out.println("Inserisci primo ID:");
		int s1 = Integer.parseInt(keyboard.nextLine());
		System.out.println("Inserisci secondo ID:");
		int s2 = Integer.parseInt(keyboard.nextLine());
		for( Person p : ci.random(s1, s2))
			try {
				res &= dao.save(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return res+"";
	}

}
