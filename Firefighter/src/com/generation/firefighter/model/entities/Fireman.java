package com.generation.firefighter.model.entities;

import java.io.Serializable;
import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the fireman database table.
 * 
 */
@Entity
@NamedQuery(name="Fireman.findAll", query="SELECT f FROM Fireman f")
public class Fireman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String level;

	private String name;

	private int salary;

	private String surname;

	//bi-directional many-to-one association to Badge
	@OneToMany(mappedBy="fireman", cascade=CascadeType.PERSIST)
	private List<Badge> badges = new ArrayList<Badge>();

	public Fireman() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Badge> getBadges() {
		return this.badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public Badge addBadge(Badge badge) {
		getBadges().add(badge);
		badge.setFireman(this);

		return badge;
	}

	public Badge removeBadge(Badge badge) {
		getBadges().remove(badge);
		badge.setFireman(null);

		return badge;
	}

}