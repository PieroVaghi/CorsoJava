package generation.office.entities;

import generation.common.entities.Entity;

public class Employee extends Entity {

	private String name, surname, role, gender, dob;
	private int salary;
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getRole() {
		return role;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public int getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return (name != null ? "name: " + name + ",\n" : "") + (surname != null ? "surname: " + surname + ",\n" : "")
				+ (role != null ? "role: " + role + ",\n" : "") + (gender != null ? "gender: " + gender + ",\n" : "")
				+ (dob != null ? "dob: " + dob + ",\n" : "") + "salary: " + salary;
	}

	@Override
	public boolean valid() {
		return notVoid(name)		&&
				notVoid(surname)	&&
				notVoid(role)		&&
				notVoid(gender)		&&
				notVoid(dob)		&&
				salary > 0;
	}

}
