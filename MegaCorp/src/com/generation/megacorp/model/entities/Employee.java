package com.generation.megacorp.model.entities;

import java.util.ArrayList;
import java.util.List;

import com.generation.megacorp.model.entities.Certificate;

import generation.common.entities.Entity;

public class Employee extends Entity{

	private String name, surname, role, dob;
	private int salary;
	List<Certificate> certificates = new ArrayList<Certificate>();
	
		
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getRole() {
		return role;
	}

	public String getDob() {
		return dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public List<Certificate> getCertificates() {
		return certificates;
	}
	public Employee setCertificates(List<Certificate> certificates) 
	{
		this.certificates.clear();
		//aggiungo la recensione al mio interno
		//ma faccio un'altra cosa
		//dico alla recensione chi sono IO
		for(Certificate certificate:certificates)
			addCertificates(certificate);
		
		return this;
	}

	public void addCertificates(Certificate certificate)
	{
		certificate.setEmployee(this);
		certificates.add(certificate);
	}


	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return true;
	}

}
