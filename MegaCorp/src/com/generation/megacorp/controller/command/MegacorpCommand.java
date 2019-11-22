package com.generation.megacorp.controller.command;

import java.util.Scanner;

import com.generation.megacorp.controller.context.Context;
import com.generation.megacorp.model.entities.Employee;

import generation.common.controller.command.Command;
import generation.common.dao.EntityDAO;
import generation.common.view.entities.EntityView;

public abstract class MegacorpCommand  extends Command {

	EntityDAO<Employee> dao;
	EntityView<Employee> view;
	Scanner keyboard;

	@Override
	protected void init() {
		dao = (EntityDAO<Employee>) Context.getInstance().get("employeedao");
		view = (EntityView<Employee>) Context.getInstance().get("viewemployee");
		keyboard = (Scanner) Context.getInstance().get("keyboard");
	}

}
