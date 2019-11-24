package com.generation.persondrama.model.entities;

import java.util.ArrayList;
import java.util.List;

import generation.common.entities.Entity;

public class Person extends Entity{
	
	private String name, surname;
	private int age;
	List<Drama> dramas = new ArrayList<Drama>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Drama> getDramas() {
		return dramas;
	}
	
	public Person setDramas(List<Drama> dramas) 
	{
		this.dramas.clear();
		//aggiungo il drama alla mia persona
		//ma faccio un'altra cosa
		//dico alla recensione chi sono IO
		for(Drama drama:dramas)
			addDrama(drama);
		
		return this;
	}
	
	private void addDrama(Drama drama) {
		drama.setPerson(this);
		dramas.add(drama);
	}
	
	@Override
	public boolean valid() {
		return 	notVoid(name)		&&
				notVoid(surname)	&&
				between(age,0,150)	;
	}
	
	

}
