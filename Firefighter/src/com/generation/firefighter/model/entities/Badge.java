package com.generation.firefighter.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the badge database table.
 * 
 */
@Entity
@NamedQuery(name="Badge.findAll", query="SELECT b FROM Badge b")
public class Badge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int risklevel;

	private String title;

	//bi-directional many-to-one association to Fireman
	@ManyToOne
	@JoinColumn(name="firemanid")
	private Fireman fireman;

	public Badge() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRisklevel() {
		return this.risklevel;
	}

	public void setRisklevel(int risklevel) {
		this.risklevel = risklevel;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Fireman getFireman() {
		return this.fireman;
	}

	public void setFireman(Fireman fireman) {
		this.fireman = fireman;
	}

}