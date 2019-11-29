package com.generation.megacorp.controller.command;

import java.util.Scanner;

import com.generation.common.controller.command.Command;
import com.generation.common.model.dao.EntityDAO;
import com.generation.megacorp.controller.context.Context;
import com.generation.megacorp.model.entities.Employee;

import generation.common.view.entities.EntityView;
import generation.common.view.language.Language;

public abstract class MegacorpCommand  extends Command {

	EntityDAO<Employee> dao;
	EntityView<Employee> view;
	Scanner keyboard;
	Language lan;

	@Override
	protected void init() {
		dao = (EntityDAO<Employee>) Context.getInstance().get("employeedao");
		view = (EntityView<Employee>) Context.getInstance().get("viewemployee");
		keyboard = (Scanner) Context.getInstance().get("keyboard");
		lan = (Language) Context.getInstance().get("language");
	}
	
	public void print (String s) {
		System.out.println(lan.translate(s));
	}

}
