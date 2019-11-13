package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Book;
import entities.CD;
import entities.Product;

public class ProductDAOSQLite implements ProductDAO {
	
	private static final String SELECTPRODUCT = "select product.*, cd.artist, cd.length, cd.genere, book,author, book.category, book.pages from Product left join cd where id=";
	private static final String INSERTQUERY = "insert into product values([id],'[name]','[description]',[price],[quantity]);";
	private static final String UPDATEQUERY = "update Product set name='[name], description='[description]', price=[price], quantity=[quantity] where id = [id];";
	Connection connection;
	
	public ProductDAOSQLite (String dbfile) {
	      try {
	         Class.forName("org.sqlite.JDBC");
	         connection = DriverManager.getConnection("jdbc:sqlite:"+dbfile);
	      } catch ( Exception e ) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	}

	/**
	 * Entra una riga SQL esce un prodotto
	 * @param row
	 * @return
	 */
	private Product _programFromRow (ResultSet row) throws Exception {	//row può contenere più righe ma ne inquadra sempre una sola 
		// La row contiene una riga di product, una riga di cd e una riga di book
		String type = row.getString("artist") == null ? "Book" : "CD";
		Product res;
		if(type.contentEquals("Book"))
			res = new Book();
		else 
			res = new CD();
		
		res.setName(row.getString("name"));
		res.setDescription(row.getString("description"));
		res.setPrice(row.getInt("price"));
		res.setQuantity(row.getInt("quantity"));
		res.setId(row.getInt("id"));
		
		if(type.contentEquals("Book")) {
			Book b = (Book) res;							// b non è un oggetto nuovo, è solo un nuovo modo di vedere res!
			b.setAuthor(row.getString("author"));			// modificando b noi in verità modifichiamo res
			b.setPages(row.getInt("pages"));
			b.setCategory(row.getString("category"));
		} else {
			CD c = (CD) res;
			c.setArtist(row.getString("author"));
			c.setLength(row.getInt("pages"));
			c.setGenere(row.getString("category"));
		}
		
		return res;
	}
	
	@Override
	public Product load(int id) {
		
		try {
			// Ho una connessione. Preparo comando SQL
			Statement command = connection.createStatement();
			//Leggo una riga
			//row contiene la riga
			//sto inviando un comando (query) lungo il "tubo"
			ResultSet row = command.executeQuery(SELECTPRODUCT+id);
			//se c'ho robbba
			return (row.next()) ? _programFromRow(row) : null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private String _prepareQuery (Product product, String sql) {
		sql = sql.replace("[id]",  product.getId()+"");		// replace sostituisce il valore [id] con l'id el prodotto e così via
		sql = sql.replace("[price]",  product.getPrice()+"");
		sql = sql.replace("[quantity]",  product.getQuantity()+"");
		sql = sql.replace("[name]",  product.getName()+"");
		sql = sql.replace("[description]",  product.getDescription()+"");
		return sql;
	}
	
	private boolean _exist(int id) {
		return id>0 && load(id)!=null;
	}
	
	@Override
	public boolean save(Product product) {
		// Primo: devo capire se il prodotto esiste o non esiste già
		// provo a caricarlo e vedo se esiste
		// devo inviare un updare
			try {
				Statement command = connection.createStatement();
				command.execute
				(
						_prepareQuery
						(
								product,
								(_exist(product.getId()))	?	UPDATEQUERY	: INSERTQUERY
						)
				);
				return true;				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean delete(int id) {
		if (_exist(id)) {
			return false;
		} else {
			try {
				Statement command = connection.createStatement();
				String sql = "delete from product where id=" + id;
				command.execute(sql);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	@Override
	public List<Product> list() {
		List<Product> res = new ArrayList<Product>();
		try {
			Statement command = connection.createStatement();
			ResultSet rows = command.executeQuery("select * from Product");
			while(rows.next()) 
				res.add(_programFromRow(rows));
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
	}

}
