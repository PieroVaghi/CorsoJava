package deprecate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import entities.*;

public class Main {

	public static void main(String[] args) throws Exception {

		

//		Map<String, String> status = new HashMap<String,String>();
//		
//		status.put("id", "1");
//		status.put("name", "Ferdinando");
//		status.put("surname", "Primeano");
//		status.put("dob", "05/02/1980");
//		status.put("salary", "5000");
//		status.put("mansion", "teacher");
//		status.put("type", "employee");
//		
//		Employee ferdinando = new Employee();
//		//Copio i dati dalla mappa nella entity
//		ferdinando.fromMap(status);
		
		String url = "jdbc:mysql://127.0.0.1:3306/shop?useSSL=false";
        // create a connection to the database
        Connection conn = DriverManager.getConnection(url,"root","root");
	
        //come chiave, il nome della classe
        //come valore la query di salvataggio
        Map<String, String> saveQueries = new HashMap<String,String>();
        
        saveQueries.put("Employee", "insert into person values([id],'[name]','[surname]','[dob]');insert into Employee values([id],'[mansion]',[salary]);");
        saveQueries.put("Client", "insert into person values([id],'[name]','[surname]','[dob]');insert into Client values([id],'[email]','[interests]');");
         
        
        EntityDAO<Person> dao = new FlatEntityDAO<Person>
        (
       	conn,
        	"select person.*, employee.mansion, employee.salary, client.email, client.interests, IF(employee.salary IS NULL  , 'Client', 'Employee') type from person left join employee on person.id = employee.id left join client on person.id=client.id",
        	"select person.*, employee.mansion, employee.salary, client.email, client.interests, IF(employee.salary IS NULL  , 'Client', 'Employee') type from person left join employee on person.id = employee.id left join client on person.id=client.id where person.id=",
        	"delete from person where id=[id]; delete from employee where id=[id]; delete from client where id=[id];",
        	saveQueries
       );
    
        Employee e = new Employee();
        
        e.setName("Viktor");
        e.setSurname("Frankenstein");
        e.setDob("01/01/1979");
        e.setMansion("scientist");
        e.setSalary(10000);
        e.setId(2);
        System.out.println("non mi sono ancora bloccato");
        dao.save(e);
//        System.out.println("Cancello da main");
//        dao.delete(2);
        
        
	
		
//		EntityDAO<Product> dao = new ProductDAOMySQL();
//		System.out.println("---- STAMPO LISTA PRODOTTI ----------------");
//		System.out.println(dao.list());
//		System.out.println("---- FINE STAMPA PRODOTTI -----------------");
//
//		Book b = new Book();
//		b.setId(3);
//		b.setName("Il signore dei signori");
//		b.setCategory("Commedia");
//		b.setPages(1200);
//		b.setPrice(12);
//		b.setAuthor("Leonardo");
//		b.setQuantity(15);
//		b.setDescription("Un gran libro!");
//		
//		dao.save(b);
//		
//		Product p = dao.load(3);
//		System.out.println("---- STAMPO P ----------------------------");
//		System.out.println(p);
//		System.out.println("---- FINE STAMPA P -----------------------");
//		
//		EntityDAO<Person> daoP = new PersonDAOMySQL();
//		System.out.println("---- STAMPO LISTA PERSONE ----------------");
//		System.out.println(daoP.list());
//		System.out.println("---- FINE SUTAMPA PERSONE  ---------------");
//
//		Employee d = new Employee();
//		d.setId(3);
//		d.setName("Carlo");
//		d.setSurname("Vaghi");
//		d.setDob("01/12/1997");
//		d.setMansion("SuperMegaSottoposto");
//		d.setSalary(1200);
//		
//		daoP.save(d);
////		daoP.delete(3);
//		
//		Person f = daoP.load(3);
//		
//		System.out.println("---- STAMPO F ----------------------------");
//		System.out.println(f);
//		System.out.println("---- FINE STAMPA F -----------------------");
	}

}
