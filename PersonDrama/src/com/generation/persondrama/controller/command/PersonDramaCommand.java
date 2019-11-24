package com.generation.persondrama.controller.command;

import java.util.Scanner;

import com.generation.persondrama.controller.context.Context;
import com.generation.persondrama.model.entities.Person;
import com.generation.persondrama.model.insert.CasualInsert;

import generation.common.controller.command.Command;
import generation.common.dao.EntityDAO;
import generation.common.database.Database;
import generation.common.view.entities.EntityView;
import generation.common.view.language.Language;

public abstract class PersonDramaCommand  extends Command {

	EntityDAO<Person> dao;
	EntityView<Person> view;
	Scanner keyboard;
	Language lan;
	Database db;
	CasualInsert ci;

	@Override
	protected void init() {
		dao = (EntityDAO<Person>) Context.getInstance().get("persondao");
		view = (EntityView<Person>) Context.getInstance().get("viewperson");
		keyboard = (Scanner) Context.getInstance().get("keyboard");
		lan = (Language) Context.getInstance().get("language");
		db = (Database) Context.getInstance().get("database");
		ci = (CasualInsert) Context.getInstance().get("insert");
}
	
	public void print (String s) {
		System.out.println(lan.translate(s));
	}

}
