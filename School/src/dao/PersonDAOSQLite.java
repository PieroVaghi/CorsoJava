package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Person;

public class PersonDAOSQLite implements PersonDAO {
	
	private static final String DELETE_QUERY = "delete from person where id=";
	private static final String SELECT_QUERY = "select * from person where id=";
	private static final String INSERT_QUERY = "insert into person values([id],'[name]','[surname]','[dateofbirth]');";
	private static final String UPDATE_QUERY = "update person set name='[name]', surname='[surname]', dateofbirth='[dateofbirth]' where id = [id];";
	
	
	Connection connection;
	
	public PersonDAOSQLite (String dbfile) {
	      try {
	         Class.forName("org.sqlite.JDBC");
	         connection = DriverManager.getConnection("jdbc:sqlite:"+dbfile);
	      } catch ( Exception e ) {
	         e.printStackTrace();
	         System.exit(0);
	      }
	}

	/**
	 * Entra riga SQL esce persona
	 * @param row
	 * @return una person
	 */
	private Person _programFromRow (ResultSet row) throws Exception {	//row può contenere più righe ma ne inquadra sempre una sola 
		Person res = new Person();
		res.setName(row.getString("name"));
		res.setSurname(row.getString("surname"));
		res.setDateofbirth(row.getString("dateofbirth"));
		res.setId(row.getInt("id"));
		return res;
	}
	
	@Override
	public Person load(int id) {
		try {
			// Ho una connessione. Preparo comando SQL
			Statement command = connection.createStatement();
			//Leggo una riga
			//row contiene la riga
			//sto inviando un comando (query) lungo il "tubo"
			ResultSet row = command.executeQuery(SELECT_QUERY+id);
			//se c'ho robbba
			return (row.next()) ? _programFromRow(row) : null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private String _prepareQuery (Person product, String sql) {
		sql = sql.replace("[id]",  product.getId()+"");		// replace sostituisce il valore [id] con l'id el prodotto e così via
		sql = sql.replace("[name]",  product.getName()+"");
		sql = sql.replace("[surname]",  product.getSurname()+"");
		sql = sql.replace("[dateofbirth]",  product.getDateofbirth()+"");
		return sql;
	}
	
	private boolean _exist(int id) {
		return id>0 && load(id)!=null;
	}
	
	@Override
	public boolean save(Person product) {
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
								(_exist(product.getId()))	?	UPDATE_QUERY	: INSERT_QUERY
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
		if (load(id) == null) {
			return false;
		} else {
			try {
				Statement command = connection.createStatement();
				String sql = DELETE_QUERY + id;
				command.execute(sql);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	

}
