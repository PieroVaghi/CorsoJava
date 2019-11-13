package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.Employee;
import entities.Person;

public class PersonDAOSQLite implements PersonDAO {
	
	
	private static final String UPDATEPERSON = "update person set name='[name]', surname='[surname]', dateofbirth='[dateofbirth]' where id = [id];";
	private static final String INSERTPERSON = "insert into person values([id],'[name]','[surname]','[dob]');"	;
	private static final String UPDATEEMPLOYEE = "update Employee set mansion='[mansion]', salary=[salary] where id=[id]";
	private static final String INSERTEMPLOYEE = "insert into Employee values([id],'[mansion]',[salary])"	;
	private static final String UPDATECLIENT = "update client set mail='[mail]', interest='[interest]' where id=[id]";
	private static final String INSERTCLIENT = "insert into client values([id],'[mail]','[interest]')"	;
	
	
	private static final String SELECTPERSON = 
			"select person.*, employee.mansion, employee.salary, client.mail, client.interest from person left join employee on person.id = employee.id left join client on person.id = client.id where person.id=";
	private static final String SELECTALL = 
			"select person.*, employee.mansion, employee.salary, client.mail, client.interest from person left join employee on person.id = employee.id left join client on person.id = client.id";

	
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
		String type = row.getString("mail")==null ? "Employee" : "Client"; 
		Person res;
		res = (type.contentEquals("Employee")) ? new Employee() : new Client();

		res.setId(row.getInt("id")); // Prendo il valore della riga in colonna ID e lo metto in res al suo posto
		res.setName(row.getString("name"));
		res.setSurname(row.getString("surname"));
		res.setDob(row.getString("dob"));
		if(type.contentEquals("Employee"))
		{
			Employee b = (Employee) res;
			b.setMansion(row.getString("mansion"));
			b.setSalary(row.getInt("salary"));
		}
		else
		{
			Client c = (Client) res;
			c.setMail(row.getString("mail"));
			c.setInterest(row.getString("interest"));
		}
		
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
			ResultSet row = command.executeQuery(SELECTPERSON+id);
			//se c'ho robbba
			return (row.next()) ? _personFromRow(row) : null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private String _prepareQuery (Person person, String sql) {
		sql = sql.replace("[id]",  person.getId()+"");		// replace sostituisce il valore [id] con l'id el prodotto e così via
		sql = sql.replace("[name]",  person.getName()+"");
		sql = sql.replace("[surname]",  person.getSurname()+"");
		sql = sql.replace("[dateofbirth]",  person.getDob()+"");
		if(person instanceof Employee)
		{
			Employee e = (Employee)person;
			sql = sql.replace("[mansion]", e.getMansion());
			sql = sql.replace("[salary]", e.getSalary()+"");
		}
		if(person instanceof Client)
		{
			Client c = (Client) person;
			sql = sql.replace("[mail]", c.getMail());
			sql = sql.replace("[interest]", c.getInterest());
		}
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
				boolean present = _exist(person.getId());
				command.execute(_prepareQuery(person,present ? UPDATEPERSON : INSERTPERSON));
				if(person instanceof Employee)
					command.execute(_prepareQuery(person,present ? UPDATEEMPLOYEE : INSERTEMPLOYEE));
				if(person instanceof Client)
					command.execute(_prepareQuery(person,present ? UPDATECLIENT : INSERTCLIENT));
				
				
				command.close();
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
				String sql = "delete from Person where id="+id;
				command.execute(sql);
				sql = "delete from Employee where id="+id;
				command.execute(sql);
				sql = "delete from Client where id="+id;
				command.execute(sql);
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
			ResultSet rows = command.executeQuery(SELECTALL);
			while(rows.next()) 
				persons.add(_personFromRow(rows));
			command.close();
			rows.close();
			return persons;					
		} catch (Exception e) {
			e.printStackTrace();
			return persons;
		}
	}
	
	

}


