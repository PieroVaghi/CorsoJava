package com.generation.shampoo.model.entities;

import generation.common.entities.Entity;

public class Shampoo extends Entity{
	
	private static final int MAXSIZE = 10000;
	private static final int MINSIZE = 0;
	private static final int MAXPRICE = 5000;
	private static final int MINPRICE = 0;
	private String producer, name, bio;
	private int price, size;
	
	

	public String getProducer() {
		return producer;
	}



	public String getName() {
		return name;
	}



	public String getBio() {
		return bio;
	}



	public int getPrice() {
		return price;
	}



	public int getSize() {
		return size;
	}



	public void setProducer(String producer) {
		this.producer = producer;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setBio(String bio) {
		this.bio = bio;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void setSize(int size) {
		this.size = size;
	}



	@Override
	public String toString() {
		return (producer != null ? "producer: " + producer + ",\n" : "") + (name != null ? "name: " + name + ",\n" : "")
				+ (bio != null ? "bio: " + bio + ",\n" : "") + "price: " + price + ",\nsize: " + size;
	}



	@Override
	public boolean valid() {
		return 	notVoid(producer)										&&
				notVoid(name)											&&
				(bio.equalsIgnoreCase("y")||bio.equalsIgnoreCase("n"))	&&
				between(price, MINPRICE, MAXPRICE)						&&
				between(size, MINSIZE, MAXSIZE)							;
	}

}
