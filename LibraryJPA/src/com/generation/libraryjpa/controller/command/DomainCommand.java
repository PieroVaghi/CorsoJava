package com.generation.libraryjpa.controller.command;

import java.sql.Connection;

import com.generation.common.controller.keyboard.Keyboard;
import com.generation.common.view.language.Language;
import com.generation.libraryjpa.controller.context.Context;
import com.generation.libraryjpa.model.bi.LibraryBI;
import com.generation.libraryjpa.model.dao.AuthorDAO;
import com.generation.libraryjpa.view.AuthorView;

public abstract class DomainCommand extends com.generation.common.controller.command.Command
{
	//Dipendenze che prendo con Init e che passerò ai miei figli
	protected AuthorDAO dao;
	protected LibraryBI librarybi;
	protected Connection connection;
	protected Keyboard keyboard;
	protected Language language;
	protected AuthorView view;
		
	@Override
	public void init()
	{
		dao = (AuthorDAO) Context.getInstance().get("dao");
		librarybi = (LibraryBI) Context.getInstance().get("librarybi");
		connection = (Connection) Context.getInstance().get("connection");
		keyboard = (Keyboard) Context.getInstance().get("keyboard");
		language = (Language) Context.getInstance().get("language");
		view = (AuthorView) Context.getInstance().get("view");
	}
	
	
}