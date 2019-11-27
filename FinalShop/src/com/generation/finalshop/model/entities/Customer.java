package com.generation.finalshop.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.generation.common.model.entities.IEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable , IEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	private String surname;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
	private List<Review> reviews = new ArrayList<Review>();

	//bi-directional one-to-one association to Job
	@OneToOne(mappedBy="customer", cascade = CascadeType.PERSIST)
	private Job job;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setCustomer(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setCustomer(null);

		return review;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) 
	{
		job.setId(this.getId());
		this.job = job;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

}