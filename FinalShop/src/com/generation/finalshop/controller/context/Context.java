package com.generation.finalshop.controller.context;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.common.controller.command.Behaviour;
import com.generation.common.controller.command.BehaviourFactory;
import com.generation.common.controller.keyboard.Keyboard;
import com.generation.common.controller.keyboard.KeyboardImpl;
import com.generation.common.model.bi.BIFacadeFactory;
import com.generation.common.view.language.Language;
import com.generation.common.view.language.LanguageFactory;
import com.generation.finalshop.controller.command.AVGCategory;
import com.generation.finalshop.controller.command.AddCustomer;
import com.generation.finalshop.controller.command.AddCustomerJob;
import com.generation.finalshop.controller.command.AddProduct;
import com.generation.finalshop.controller.command.AddProductReview;
import com.generation.finalshop.controller.command.AskCommand;
import com.generation.finalshop.controller.command.DomainCommand;
import com.generation.finalshop.controller.command.QuantityForCategory;
import com.generation.finalshop.controller.command.QuitCommand;
import com.generation.finalshop.controller.command.RemoveReview;
import com.generation.finalshop.controller.command.UpdateProduct;
import com.generation.finalshop.controller.command.XMLAbsorb;
import com.generation.finalshop.model.bi.FactoryShopBI;
import com.generation.finalshop.model.bi.ShopBI;
import com.generation.finalshop.model.entities.FactoryShop;
import com.generation.finalshop.model.shop.FactoryShopBL;
import com.generation.finalshop.model.shop.ShopBL;
import com.generation.finalshop.view.FactoryShopView;
import com.generation.finalshop.view.ShopView;


// Riempire

public class Context extends com.generation.common.controller.context.Context {
	private static Context instance = new Context();
	private final static String DBPATH = "jdbc:mysql://localhost:3306/finalshop?user=root&password=piefragio1";
	
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
			ShopBI shopbi = FactoryShopBI.make(BIFacadeFactory.make(connection));
			put("shopbi", shopbi);
			//Entity Manager JPA per fare DAO, ma io sono un CRIMINALE
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("FinalShop");
		    EntityManager em = emfactory.createEntityManager();
		    // Io Non ho più un DAO ma una BL...
		    ShopBL bl = FactoryShopBL.make(em);
		    put("bl", bl);
		    //Il comportamento
		    Behaviour behaviour = BehaviourFactory.make
		    (
		    	new String[] 	{
		    			"quit","askcommand","addcustomer", "addcustomerjob", "addproduct",	
		    			"addproductreview","removereview","avgcategory","quantityforcategory",
		    			"updateproduct","xmlabsorb"
		    					},	
		    	new DomainCommand[] {	
		    							new QuitCommand(), new AskCommand(), new AddCustomer(),
		    							new AddCustomerJob(), new AddProduct(), new AddProductReview(),
		    							new RemoveReview(), new AVGCategory(), new QuantityForCategory(),
		    							new UpdateProduct(), new XMLAbsorb()
		    						}	
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
		    
		    FactoryShop fs = FactoryShop.getInstance();
		    put("factoryshop", fs);
		    
		    //La view
		    ShopView shopview = FactoryShopView.make(language);
		    put("view", shopview);
		    
		    
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		
		
		
		
	}
	
}