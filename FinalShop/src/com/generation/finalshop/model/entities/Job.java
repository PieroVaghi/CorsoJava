package com.generation.finalshop.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.generation.common.model.entities.IEntity;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable, IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String category;

	private String role;

	//bi-directional one-to-one association to Customer
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="id")
	private Customer customer;

	public Job() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}