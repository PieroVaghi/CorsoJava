package com.generation.schoolJPA.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mark database table.
 * 
 */
@Entity
@NamedQuery(name="Mark.findAll", query="SELECT m FROM Mark m")
public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int grade;

	private String subject;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;

	public Mark() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "id: " + id + ",\ngrade: " + grade + ",\n" + (subject != null ? "subject: " + subject + ",\n" : "")
				+ (student != null ? "student: " + student : "");
	}
	
	

}