package com.generation.webshop.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends com.generation.common.model.entities.Entity implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String category;

	private String description;

	private String name;

	private int price;

	private int quantity;
	
	String image;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="product", cascade=CascadeType.PERSIST)
	private List<Review> reviews = new ArrayList<Review>();

	public Product() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setProduct(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setProduct(null);

		return review;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShortDescription()
	{
		if(description.length()<100)
			return description;
		
		String res = "";
		int spacepos = -2;
		while(spacepos<100 && spacepos!=-1)
			spacepos = description.indexOf(" ", spacepos+1);
		System.out.println(spacepos);
		if(spacepos != -1)
			return description.substring(0, spacepos)+"...";
		else 
			return description.substring(0, 100)+"...";
	}

	@Override
	public boolean valid() 
	{
		return 
				notVoid(name)					&&
				notVoid(description)			&&
				notVoid(category)				&&
				quantity>=0						&&
				price>=0;
	}
	
}