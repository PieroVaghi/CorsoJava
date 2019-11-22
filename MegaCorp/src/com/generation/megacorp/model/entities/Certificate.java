package com.generation.megacorp.model.entities;

import generation.common.entities.Entity;

public class Certificate extends Entity{
	
	private String title, earnedon, expireson;
	private int cost;
	Employee employee;
	
	
	public String getTitle() {
		return title;
	}

	public String getEarnedon() {
		return earnedon;
	}

	public String getExpireson() {
		return expireson;
	}

	public int getCost() {
		return cost;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEarnedon(String earnedon) {
		this.earnedon = earnedon;
	}

	public void setExpireson(String expireson) {
		this.expireson = expireson;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	//un getter ARTIFICIALE
	//perchè quando salverò dovrò per forza dare anche
	//la colonna productid, che è chiave ESTERNA
	public int getEmployeeId()
	{
		return employee!=null ? employee.getId() : -1;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return true;
	}

}
