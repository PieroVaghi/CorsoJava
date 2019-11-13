package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Person;

public class PersonDAOSQLite implements PersonDAO {
	
	private static final String SELECT_FROM_PERSON = "select * from person";
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
	         System.exit(0); //Chiudi tutto ci stanno tracciando
	      }
	}

	/**
	 * Entra riga SQL esce persona
	 * @param row
	 * @return una person
	 */
	private Person _personFromRow (ResultSet row) throws Exception {	//row può contenere più righe ma ne inquadra sempre una sola 
		Person res = new Person();
		res.setId(row.getInt("id")); // Prendo il valore della riga in colonna ID e lo metto in res al suo posto
		res.setName(row.getString("name"));
		res.setSurname(row.getString("surname"));
		res.setDob(row.getString("dateofbirth"));
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
			return (row.next()) ? _personFromRow(row) : null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private String _prepareQuery (Person product, String sql) {
		sql = sql.replace("[id]",  product.getId()+"");		// replace sostituisce il valore [id] con l'id el prodotto e così via
		sql = sql.replace("[name]",  product.getName()+"");
		sql = sql.replace("[surname]",  product.getSurname()+"");
		sql = sql.replace("[dateofbirth]",  product.getDob()+"");
		return sql;
	}
	
	private boolean _exist(int id) {
		return id>0 && load(id)!=null;
	}
	
	@Override
	public boolean save(Person person) {
		// Primo: devo capire se il prodotto esiste o non esiste già
		// provo a caricarlo e vedo se esiste
		// devo inviare un updare
			try {
				Statement command = connection.createStatement();
				command.execute	//esegue la query compilata
				(
						_prepareQuery	//query compilata coi dati corretti
						(
								person,	//origine dei dati
								(_exist(person.getId()))	?	UPDATE_QUERY	: INSERT_QUERY // Stringa modello
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
				command.execute(DELETE_QUERY + id);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	@Override
	public List<Person> list() {
		List<Person> persons = new ArrayList<Person>();
		try {
			Statement command = connection.createStatement();
			ResultSet rows = command.executeQuery(SELECT_FROM_PERSON);
			while(rows.next()) {
				persons.add(_personFromRow(rows));
			}
			rows.close();
			return persons;					
		} catch (Exception e) {
			e.printStackTrace();
			return persons;
		}
	}
	
	

}


