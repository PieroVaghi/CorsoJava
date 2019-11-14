package main;

import dao.EntityDAO;
import dao.PersonDAO;
import dao.PersonDAOMySQL;
import dao.ProductDAO;
import dao.ProductDAOMySQL;
import entities.*;

public class Main {

	public static void main(String[] args) {

		EntityDAO<Product> dao = new ProductDAOMySQL();
		System.out.println("---- STAMPO LISTA PRODOTTI ----------------");
		System.out.println(dao.list());
		System.out.println("---- FINE STAMPA PRODOTTI -----------------");

		Book b = new Book();
		b.setId(3);
		b.setName("Il signore dei signori");
		b.setCategory("Commedia");
		b.setPages(1200);
		b.setPrice(12);
		b.setAuthor("Leonardo");
		b.setQuantity(15);
		b.setDescription("Un gran libro!");
		
		dao.save(b);
		
		Product p = dao.load(3);
		System.out.println("---- STAMPO P ----------------------------");
		System.out.println(p);
		System.out.println("---- FINE STAMPA P -----------------------");
		
		EntityDAO<Person> daoP = new PersonDAOMySQL();
		System.out.println("---- STAMPO LISTA PERSONE ----------------");
		System.out.println(daoP.list());
		System.out.println("---- FINE SUTAMPA PERSONE  ---------------");

		Employee d = new Employee();
		d.setId(3);
		d.setName("Carlo");
		d.setSurname("Vaghi");
		d.setDob("01/12/1997");
		d.setMansion("SuperMegaSottoposto");
		d.setSalary(1200);
		
		daoP.save(d);
//		daoP.delete(3);
		
		Person f = daoP.load(3);
		
		System.out.println("---- STAMPO F ----------------------------");
		System.out.println(f);
		System.out.println("---- FINE STAMPA F -----------------------");
	}

}
