package com.generation.firefighter.controller.servlet.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.firefighter.controller.context.Context;
import com.generation.firefighter.model.fireBL.FireBL;


public abstract class WebCommand 
{
	
	protected final static String MAINPAGE = "main.jsp";
	protected final static String FIREMANPAGE = "firemandetails.jsp";
	
	protected FireBL fire;
	
	protected void init()
	{
		fire = (FireBL) Context.getInstance().get("fire");
	}
	
	protected abstract void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		init();
		handle(request,response);
	}

}