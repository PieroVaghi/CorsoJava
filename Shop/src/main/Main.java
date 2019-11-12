package main;

import dao.ProductDAO;
import dao.ProductDAOSQLite;
import entities.*;

public class Main {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAOSQLite("shop.db");
		System.out.println(dao.load(1));

	}

}
