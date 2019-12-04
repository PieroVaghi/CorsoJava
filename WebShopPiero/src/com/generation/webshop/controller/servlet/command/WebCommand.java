package com.generation.webshop.controller.servlet.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	protected Customer user;
	
	
	protected void init(HttpServletRequest request)
	{
		//Prendo il model, prendo lo user da session, comincio a impostare in request un attributo user 
		shop = (ShopBL) Context.getInstance().get("shop");
		user = request.getSession().getAttribute("user")==null ? GUEST : (Customer) request.getSession().getAttribute("user"); 
		request.setAttribute("user", user);
	}
	
	protected Map<String,String> parametersToMap(HttpServletRequest request)
	{
		Map<String,String> res = new HashMap<String,String>();
		for(String key:request.getParameterMap().keySet())
			res.put(key, request.getParameter(key));
		return res;		
	}
	
	//Ogni comando dovrà avere un livello
	protected abstract int getLevel();
	
	protected abstract void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		init(request);
		//io qui ho già la variabile user
		if(user.getLevel()<this.getLevel())
			request.getRequestDispatcher("forbidden.jsp").forward(request, response);
		else
			handle(request,response);
	}
	
	public static WebCommand loadCommand(String cmd)
	{
		return (((Behaviour) Context.getInstance().get("behaviour"))).get(cmd);
	}
}