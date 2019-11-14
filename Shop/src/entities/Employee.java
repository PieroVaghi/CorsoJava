package entities;

public class Employee extends Person {
	
	private String mansion;
	private int salary;
	public String getMansion() {
		return mansion;
	}
	public int getSalary() {
		return salary;
	}
	public void setMansion(String mansion) {
		this.mansion = mansion;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return super.toString() + (mansion != null ? "mansion: " + mansion + ",\n" : "") + "salary: " + salary+ "\n--------------------------------\n";
	}
	
	@Override
	public boolean valid()
	{
		return 
				super.valid()			&&
				mansion!=null			&&
				!mansion.contains("")	&&
				salary>0;

	}
	
	
}
