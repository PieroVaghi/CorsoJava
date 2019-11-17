package dao;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import entities.Book;
import entities.Employee;
import entities.Person;
import entities.Product;

public class Main2 
{
	private static final String PWD = "piefragio1";

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://127.0.0.1:3306/shop?useSSL=false";
		// create a connection to the database
		Connection conn = DriverManager.getConnection(url,"root", PWD);
		
		//come chiave, il nome della classe
		//come valore la query di salvataggio
		Map<String, String> saveQueries = new HashMap<String,String>();
		saveQueries.put("Book", "insert into Product values([id],'[name]',[price],[quantity],'[description]');insert into Book values([id],'[author]','[category]',[pages])");
		saveQueries.put("CD", "insert into Product values([id],'[name]',[price],[quantity],'[description]');insert into CD values([id],'[artist]','[genre]',[length])");
		EntityDAO<Product> dao = new FlatEntityDAO<Product>
		(
			conn,
			"select * from viewproduct;",
			"select * from viewproduct where id=",
			"delete from product where id=[id]",//; delete from Book where id=[id]; delete from CD where id=[id];",
			saveQueries
		);

		System.out.println(dao.list());
		Book a = new Book();
		a.setAuthor("Camus");
		a.setCategory("Esistenzialismo");
		a.setDescription("Dicono sia uno dei libri più belli del novecento");
		a.setName("Lo Straniero");
		a.setId(6);
		a.setPages(250);
		a.setPrice(9);
		a.setQuantity(10);
		
		dao.save(a);
		
		System.out.println(dao.list());
        
	}

}