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
		
		Person b = new Person();
		
		p.setId(4);
		p.setName("Vlad");
		p.setSurname("Rossi");
		p.setDateofbirth("16/03/1999");

	}

}
