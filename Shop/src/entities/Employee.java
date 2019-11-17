package entities;

public class Employee extends Person
{
	private static final double MAXSALARY = 5000;
	private static final double MINSALARY = 400;
	private static final String[] MANSIONLIST = "programmer,ceo,hr,teacher".split(",");
	String mansion;
	int salary;
	
	public String getMansion() {
		return mansion;
	}
	public void setMansion(String mansion) {
		this.mansion = mansion;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean valid()
	{
		return 
					super.valid() 							&&
					between(salary,MINSALARY, MAXSALARY)	&&
					belongs(mansion, MANSIONLIST)			;
	}
	@Override
	public String toString() {
		return "Employee [mansion=" + mansion + ", salary=" + salary + ", name=" + name + ", surname=" + surname
				+ ", dob=" + dob + ", id=" + id + "]";
	}
	

	
	
}