package main;

import dao.ProductDAO;
import dao.ProductDAOSQLite;
import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAOSQLite("shop.db");
		System.out.println(dao.list());

		Book b = new Book();
		b.setId(3);
		b.setName("Il signore degli anelli");
		b.setCategory("Fantasy");
		b.setPages(1200);
		b.setPrice(12);
		b.setAuthor("Tolkien");
		b.setQuantity(15);
		b.setDescription("Un gran bel libro!");
		
		dao.save(b);
		
		Product p = dao.load(3);
		
		System.out.println(p);
		
	}

}
