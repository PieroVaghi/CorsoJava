package com.generation.finalshop.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.generation.common.model.entities.IEntity;


/**
 * The persistent class for the review database table.
 * 
 */
@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable, IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String content;

	private int stars;

	private String title;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public Review() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return true;
	}

}