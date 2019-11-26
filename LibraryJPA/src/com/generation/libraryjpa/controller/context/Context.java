package com.generation.libraryjpa.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.common.model.bi.*;
import com.generation.common.controller.command.Behaviour;
import com.generation.common.controller.command.BehaviourFactory;
import com.generation.common.view.language.*;
import com.generation.libraryjpa.controller.command.AskCommand;
import com.generation.libraryjpa.controller.command.DomainCommand;
import com.generation.libraryjpa.controller.command.ListCommand;
import com.generation.libraryjpa.controller.command.QuitCommand;
import com.generation.libraryjpa.controller.command.Search;
import com.generation.libraryjpa.controller.command.SearchId;
import com.generation.libraryjpa.controller.command.TotalCost;
import com.generation.libraryjpa.model.bi.FactoryLibraryBI;
import com.generation.libraryjpa.model.bi.LibraryBI;
import com.generation.libraryjpa.model.dao.AuthorDAO;
import com.generation.libraryjpa.model.dao.FactoryAuthorDAO;
import com.generation.libraryjpa.view.AuthorView;
import com.generation.libraryjpa.view.FactoryAuthorView;
import com.generation.common.controller.keyboard.*;

public class Context extends com.generation.common.controller.context.Context
{
	private static Context instance = new Context();
	private final static String DBPATH = "jdbc:mysql://localhost:3306/libraryjpa?user=root&password=root";
	private static final int PAGESIZE = 100;
	
	public static Context getInstance() {return instance;}
	
	private Context()
	{
		// Qui definisco:
		// la connessione
		// il behaviour
		// eventuali dipendenze
		try 
		{
			//Connessione
			Connection connection = DriverManager.getConnection(DBPATH);
			put("connection", connection);
			//Business intelligence di dominio, ottenuta adattando quella generica
			LibraryBI librarybi = FactoryLibraryBI.make(BIFacadeFactory.make(connection));
			put("librarybi", librarybi);
			//Entity Manager JPA per fare DAO, ma io sono un CRIMINALE
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryJPA");
		    EntityManager em = emfactory.createEntityManager();
		    // Io HO un DAO...
		    AuthorDAO dao = FactoryAuthorDAO.make(em, PAGESIZE);
		    put("dao", dao);
		    //Il comportamento
		    Behaviour behaviour = BehaviourFactory.make
		    (
		    	new String[] {"list","quit","askcommand","search", "searchId","totalcost"},	
		    	new DomainCommand[] {new ListCommand(), new QuitCommand(), new AskCommand(), new Search(), new SearchId(), new TotalCost()}	
		    );
		    put("behaviour", behaviour);
		    
		    
		    //La lingua
		    Language language = LanguageFactory.make("Ita.lang");
		    put("language", language);

		    //La tastiera (per ora)
		    //Keyboard è un adapter di Scanner
		    Keyboard keyboard = KeyboardImpl.getInstance();
		    keyboard.setLanguage(language);
		    put("keyboard", keyboard);
		    
		    
		    //La view
		    AuthorView authorview = FactoryAuthorView.make(language);
		    put("view", authorview);
		    
		    
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		
		
		
		
	}
	
}