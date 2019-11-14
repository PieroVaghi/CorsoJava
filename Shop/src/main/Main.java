package main;

import dao.PersonDAO;
import dao.PersonDAOSQLite;
import dao.ProductDAO;
import dao.ProductDAOSQLite;
import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAOSQLite();
		System.out.println(dao.list());

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
		
		System.out.println(p);
		
		PersonDAO daoP = new PersonDAOSQLite();
		System.out.println(dao.list());

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
		
		System.out.println(f);
		
	}

}
