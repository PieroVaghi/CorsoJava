package dao;

import entities.Book;
import entities.CD;
import entities.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOSQLite implements ProductDAO
{
	//i modelli delle query li creo sotto forma di COSTANTI
	private static final String UPDATEPRODUCT = "update Product set name='[name]', description='[description]', price=[price], quantity=[quantity] where id=[id]";
	private static final String INSERTPRODUCT = "insert into product values([id],'[name]','[description]',[price],[quantity])"	;
	private static final String UPDATEBOOK = "update Book set author='[author]', category='[category]', pages=[pages] where id=[id]";
	private static final String INSERTBOOK = "insert into Book values([id],'[author]','[category]',[pages])"	;
	private static final String UPDATECD = "update CD set artist='[artist]', genre='[genre]', length=[length] where id=[id]";
	private static final String INSERTCD = "insert into CD values([id],'[artist]','[genre]',[length])"	;
	
	
	private static final String SELECTPRODUCT = 
			"select product.*, cd.artist, cd.length, cd.genre, book.author, book.category, book.pages from product left join cd on product.id = cd.id left join book on product.id = book.id where product.id=";
	private static final String SELECTALL = 
			"select product.*, cd.artist, cd.length, cd.genre, book.author, book.category, book.pages from product left join cd on product.id = cd.id left join book on product.id = book.id";

	
	Connection connection;
	
	public ProductDAOSQLite(String dbfile)
	{
		try 
		{
	         Class.forName("org.sqlite.JDBC");
	         connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/azienda?useSSL=false","root","root");
	    } 
		catch 
		(Exception e ) 
		{
			e.printStackTrace();
			System.exit(0);
	    }
	}
	
	
	/**
	 * entra una riga SQL, esce un Product
	 * @param row
	 * @return
	 * @throws Exception
	 */
	private Product _productFromRow(ResultSet row) throws Exception
	{
		//la row contiene una riga di Product, e una riga di CD o una riga di Book
		String type = row.getString("artist")==null ? "Book" : "CD";
		
		//String[] fields = "id,name,description,artist,genre".split(",");
		//for(String field:fields)
		//	System.out.println(field+":"+row.getString(field));
		
		Product res;
		
		if(type.contentEquals("Book"))
			res = new Book();
		else
			res = new CD();
		
		
		
		//Questi campi li hanno tutti e due
		res.setName(row.getString("name"));
		res.setDescription(row.getString("description"));
		res.setPrice(row.getInt("price"));
		res.setQuantity(row.getInt("quantity"));
		res.setId(row.getInt("id"));
		
		if(type.contentEquals("Book"))
		{
			Book b = (Book) res;
			b.setAuthor(row.getString("author"));
			b.setPages(row.getInt("pages"));
			b.setCategory(row.getString("category"));
		}
		else
		{
			CD c = (CD) res;
			c.setArtist(row.getString("artist"));
			c.setLength(row.getInt("length"));
			c.setGenre(row.getString("genre"));
		}
		return res;	
	}
	

	@Override
	public Product load(int id) 
	{
		try
		{
			//Ho una connessione. Preparo un comando SQL:
			Statement command = connection.createStatement();
			//Leggo una riga
			//row contiene la riga
			//System.out.println(SELECTPRODUCT+id);
			ResultSet row = command.executeQuery(SELECTPRODUCT+id);
			// se c'ho robbba.
			return row.next() ? _productFromRow(row): null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	
	private String _prepareQuery(Product product, String sql)
	{
		sql = sql.replace("[id]", product.getId()+"");
		sql = sql.replace("[price]", product.getPrice()+"");
		sql = sql.replace("[quantity]", product.getQuantity()+"");
		sql = sql.replace("[name]", product.getName());
		sql = sql.replace("[description]", product.getDescription());
		if(product instanceof CD)
		{
			CD c = (CD) product;
			sql = sql.replace("[artist]", c.getArtist());
			sql = sql.replace("[genre]", c.getGenre());
			sql = sql.replace("[length]", c.getLength()+"");
		}
		
		if(product instanceof Book)
		{
			Book b = (Book) product;
			sql = sql.replace("[author]", b.getAuthor());
			sql = sql.replace("[category]", b.getCategory());
			sql = sql.replace("[pages]", b.getPages()+"");
		}
		// System.out.println(sql);
		return sql;
	}

	@Override
	public boolean save(Product product) 
	{
		//Primo: devo capire se il prodotto esiste o non esiste già
		try 
		{
			Statement command = connection.createStatement();
			boolean present = _exists(product.getId());
			
			command.execute(_prepareQuery(product,present ? UPDATEPRODUCT : INSERTPRODUCT));
			if(product instanceof Book)
				command.execute(_prepareQuery(product,present ? UPDATEBOOK : INSERTBOOK));
			if(product instanceof CD)
				command.execute(_prepareQuery(product,present ? UPDATECD : INSERTCD));
			
			
			command.close();
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}


	private boolean _exists(int id)
	{
		return id>0 && load(id)!=null;
	}


	@Override
	public boolean delete(int id) 
	{
		if(load(id)==null)
			return false;
		else
		{
			try 
			{
				Statement command = connection.createStatement();
				String sql = "delete from Product where id="+id;
				command.execute(sql);
				sql = "delete from Cd where id="+id;
				command.execute(sql);
				sql = "delete from Book where id="+id;
				command.execute(sql);
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		
	}


	@Override
	public List<Product> list()
	{
		List<Product> res = new ArrayList<Product>();
		try
		{
			Statement command = connection.createStatement();
			ResultSet rows = command.executeQuery(SELECTALL);
			
			while(rows.next())
				res.add(_productFromRow(rows));
			command.close();
			rows.close();
			return res;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return res;
		}
		
		
	}

}