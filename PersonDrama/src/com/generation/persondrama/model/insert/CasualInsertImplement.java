package com.generation.persondrama.model.insert;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.generation.persondrama.model.entities.Person;

public class CasualInsertImplement implements CasualInsert {

	private final String[] name = {"Giggino il Truce", "Pierpiero", "Paolo", "Pietro", "Ughwak", "DArtagnan", "Ursula", "Armin", "Arminio", "Armenio", "Almeno", "Arlecchino", "Kong il Conquistatore", "King di Kong", "Beatrice", "Elena", "Piero", "Simone", "Mauro", "Giada", "Tommaso", "Ferdinando", "Andrea", "Dennis", "Hertz", "Giovanni", "Francesco", "Matteo","Lancia", "Villa", "Rotondi", "Clerici", "Marta", "Marco", "Simone", "Fabio", "Alessio", "Alessio 2 la vendetta", "Luca", "Antonietta"};
		
	public int randomBetween(int i, int f) {
		int dif = f-i;
		Random rand = new Random();
		int n = rand.nextInt(dif);
		return n += i;
	}
	
	@Override
	public List<Person> random(int s1, int s2) {
		int cont = s1;
		List<Person> res = new ArrayList<Person>();
		while(cont <= s2) {
			Person p = new Person();
			p.setId(cont);
			p.setName(name[randomBetween(0, name.length-1)]);
			p.setSurname(name[randomBetween(0, name.length-1)]);
			p.setAge(randomBetween(10,80));
			res.add(p);
			cont ++;
		}
		return res;
	}
	
	

}
