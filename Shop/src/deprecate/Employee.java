package deprecate;

public class Employee extends Person {
	
	private static final double MINSALARY = 0;
	private static final double MAXSALARY = 10000;
	private static final String[] MANSIONLIST = null;
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
				super.valid()							&&
				between(salary, MINSALARY, MAXSALARY)	&&
				belongs(mansion, MANSIONLIST)			;

	}
	
	
}
