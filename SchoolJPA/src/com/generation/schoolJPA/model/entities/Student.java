package com.generation.schoolJPA.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String surname;

	private int year;

	//bi-directional many-to-one association to Mark
	@OneToMany(mappedBy="student", cascade=CascadeType.PERSIST)
	private List<Mark> marks = new ArrayList<Mark>();

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Mark> getMarks() {
		return this.marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public Mark addMark(Mark mark) {
		getMarks().add(mark);
		mark.setStudent(this);

		return mark;
	}

	public Mark removeMark(Mark mark) {
		getMarks().remove(mark);
		mark.setStudent(null);

		return mark;
	}
	

	@Override
	public String toString() {
		return "\nid: " + id + ",\n" + (name != null ? "name: " + name + ",\n" : "")
				+ (surname != null ? "surname: " + surname + ",\n" : "") + "year: " + year + "\n" + getMarks();
	}

	
	

}