package com.generation.webshop.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.webshop.controller.context.Context;
import com.generation.webshop.model.entities.Customer;
import com.generation.webshop.model.shop.ShopBL;

public abstract class WebCommand 
{
	
	protected final static String MAINPAGE = "main.jsp";
	protected final static String PRODUCTPAGE = "productdetail.jsp";
	protected final static Customer GUEST = new Customer("","Guest", "");
	
	protected ShopBL shop;
	//Io devo ricordarmi di chi sta usando il programma
	
	protected void init()
	{
		shop = (ShopBL) Context.getInstance().get("shop");
	}
	
	protected abstract void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		init();
		handle(request,response);
	}
	
	public static WebCommand loadCommand(String cmd)
	{
		return (((Behaviour) Context.getInstance().get("behaviour"))).get(cmd);
	}
	

}