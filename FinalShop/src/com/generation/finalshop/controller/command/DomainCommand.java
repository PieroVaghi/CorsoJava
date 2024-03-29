package com.generation.finalshop.controller.command;

import java.sql.Connection;

import javax.persistence.EntityManager;

import com.generation.common.controller.keyboard.Keyboard;
import com.generation.common.view.language.Language;
import com.generation.finalshop.controller.context.Context;
import com.generation.finalshop.model.bi.ShopBI;
import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.FactoryShop;
import com.generation.finalshop.model.shop.ShopBL;
import com.generation.finalshop.view.ShopView;

public abstract class DomainCommand extends com.generation.common.controller.command.Command
{
	//Dipendenze che prendo con Init e che passer� ai miei figli
	protected ShopBL bl;
	protected ShopBI shopbi;
	protected Connection connection;
	protected Keyboard keyboard;
	protected Language language;
	protected ShopView view;
	protected FactoryShop fs;
	protected EntityManager em;
	protected Customer user;
	
	public boolean access(String[] level) {
		if(user.getId()==0)
			return false;
		String role = bl.loadCustomer(user.getId()).getRole();
		if(role == null)
			return false;
		for(String s : level)
			return (role.equalsIgnoreCase(s))? true :false;
		return false;
	}
	
		
	@Override
	public void init()
	{
		user = (Customer) Context.getInstance().get("user");
		em = (EntityManager) Context.getInstance().get("em");
		bl = (ShopBL) Context.getInstance().get("bl");
		shopbi = (ShopBI) Context.getInstance().get("shopbi");
		connection = (Connection) Context.getInstance().get("connection");
		keyboard = (Keyboard) Context.getInstance().get("keyboard");
		language = (Language) Context.getInstance().get("language");
		view = (ShopView) Context.getInstance().get("view");
		fs = (FactoryShop) Context.getInstance().get("factoryshop");
	}
	
	
}