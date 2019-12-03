package com.generation.webshop.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	
	public Customer(String email, String name, String surname) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String password;

	private String surname;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="customer")
	private List<Review> reviews;

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
	
	public int getLevel()
	{
		if(email.contentEquals(""))
			return 0;
		if(email.endsWith("generation.com"))
			return 2;
		return 1;		
		
	}
	

}