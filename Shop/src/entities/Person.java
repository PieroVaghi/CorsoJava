package entities;

import java.util.Calendar;

public class Person extends Entity
{

	String name, surname, dob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int birthYear()
	{
		int res = 0;
		if(!notVoid(dob) || dob.split("/").length!=2)
			return res;
		try
		{
			res = Integer.parseInt(dob.split("/")[2]);
		}
		catch(NumberFormatException e)
		{
			res = 0;
		}
		return res;
	}
	
	
	public int age()
	{
		return 	birthYear()>0 												? 
				Calendar.getInstance().get(Calendar.YEAR) - birthYear()		:
				-1															;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + (name != null ? "name: " + name + ", \n" : "") + (surname != null ? "surname: " + surname + ", \n" : "")
				+ (dob != null ? "dob: " + dob : "");
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return 
				notVoid(name)		&&
				notVoid(surname)	&&
				notVoid(dob)		&&
				between(age(), 0, 130);
	}
	
	
	

}