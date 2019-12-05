package com.generation.pe.controller.servlet.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.pe.controller.context.Context;
import com.generation.pe.model.bl.peBL;
import com.generation.pe.model.entities.User;


public abstract class WebCommand 
{
	protected final static User GUEST = new User("","Guest", "");
	
	
	protected peBL pebl;
	//Io devo ricordarmi di chi sta usando il programma
	protected User user;
	
	
	protected void init(HttpServletRequest request)
	{
		//Prendo il model, prendo lo user da session, comincio a impostare in request un attributo user 
		pebl = (peBL) Context.getInstance().get("pe");
		user = request.getSession().getAttribute("user")==null ? GUEST : (User) request.getSession().getAttribute("user"); 
		request.setAttribute("user", user);
	}
	
	protected Map<String,String> parametersToMap(HttpServletRequest request)
	{
		Map<String,String> res = new HashMap<String,String>();
		for(String key:request.getParameterMap().keySet())
			res.put(key, request.getParameter(key));
		return res;		
	}
	
	protected java.util.Date stringToDate(String date){
		// mi aspetto una data nel formato gg/mm/aaaa
		// se così non fosse eccezione!
		java.util.Date res = new java.util.Date();
		int year = Integer.parseInt(date.split("/")[2]);
		res.setYear(year-1900);
		int month = Integer.parseInt(date.split("/")[1]);
		res.setMonth(month);
		int day = Integer.parseInt(date.split("/")[0]);
		res.setDate(day);
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