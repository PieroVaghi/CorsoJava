package main;

import dao.PersonDAO;
import dao.PersonDAOSQLite;
import entities.Person;

public class Main {

	public static void main(String[] args) {
		
		PersonDAO dao = new PersonDAOSQLite("school.db");
		System.out.println(dao.load(1).getName());
		
		Person p = new Person();
		
		p.setId(1);
		p.setName("Vlad");
		p.setSurname("Rossi");
		p.setDateofbirth("16/03/1999");
		dao.save(p);
		System.out.println("modificato");
		Person b = new Person();
		
		b.setId(4);
		b.setName("Mario");
		b.setSurname("Mariotti");
		b.setDateofbirth("16/03/1954");
		dao.save(b);
		System.out.println("salvato");
		dao.delete(4);
		System.out.println("cancellato");

	}

}
