package com.generation.pe.model.bl;

import java.util.List;

import com.generation.pe.model.entities.Expense;
import com.generation.pe.model.entities.User;

public interface peBL {
	
		User load(int id);
		Expense loadExpence(int id);
		Object save(Object obj);
		List<User> list();
		User login(String email, String password);
		boolean delete(Object obj);
		
}