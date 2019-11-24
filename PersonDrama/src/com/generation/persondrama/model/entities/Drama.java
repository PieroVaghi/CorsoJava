package com.generation.persondrama.model.entities;

import generation.common.entities.Entity;

public class Drama extends Entity {

	private String info, date;
	private Person person;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public int getPersonId() {
		return person!=null ? person.getId() : -1;
	}
	
	@Override
	public boolean valid() {
		return 	notVoid(info)	&&
				notVoid(date)	;
	}


}
