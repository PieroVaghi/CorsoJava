package com.generation.finalshop.model.shop;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.generation.common.model.bi.BIFacadeFactory;
import com.generation.finalshop.model.bi.FactoryShopBI;
import com.generation.finalshop.model.bi.ShopBI;
import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;

public class Test 
{
	private final static String DBPATH = "jdbc:mysql://localhost:3306/finalshop?user=root&password=piefragio1";

	public static void main(String[] args) throws Exception
	{
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinalShop");
		EntityManager em = factory.createEntityManager();
		ShopBL shop = new ShopJPA(em);
		Connection connection = DriverManager.getConnection(DBPATH);
		ShopBI shopbi = FactoryShopBI.make(BIFacadeFactory.make(connection));
		
//		System.out.println(shopbi.numberForCategory());
		
//		Customer c = shop.loadCustomer(2);
//		
//		Job job = new Job();
//		job.setCategory("PC");
//		job.setRole("Sultano");
//		c.setJob(job);
		
//		c = (Customer) shop.save(c);
		System.out.println(shop.list().size());
		System.out.println(shop.list());
		
		System.out.println(shop.customers().size());
		
		
		
	}

}