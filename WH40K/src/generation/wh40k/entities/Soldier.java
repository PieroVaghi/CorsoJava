package generation.wh40k.entities;

public class Soldier extends Unit
{
	private final static String[] RACES  = "ork,eldar,tyrannid,human,necron".split(",");
	private final static String[] RETIRINGRACES  = "human,eldar".split(",");
	private static final int SERVICELENGTH = 12;
	private static final double MAXSALARY = 10000;
	private static final double MINSALARY = 0;
	private String name, surname, dob;
	private int service; // mesi in servizio
	private String race; // ork, eldar, tyrannid, human, necron
	private int salary;	
	
	public String getName() {
		return name;
	}



	public String getSurname() {
		return surname;
	}



	public String getDob() {
		return dob;
	}



	public int getService() {
		return service;
	}



	public String getRace() {
		return race;
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



	public void setDob(String dob) {
		this.dob = dob;
	}



	public void setService(int service) {
		this.service = service;
	}



	public void setRace(String race) {
		this.race = race;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}





	@Override
	public boolean valid() {
		return 
				super.valid()									&&
				between(salary,MINSALARY,MAXSALARY)				&&
				belongs(race, RACES)							&&
				notVoid(name)									&&
				notVoid(surname)								&&
				notVoid(dob)									;
	}
	
	
	public boolean retires()
	{
		return belongs(race, RETIRINGRACES) && service>=SERVICELENGTH ;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\n" + (name != null ? "name: " + name + ",\n" : "") + (surname != null ? "surname: " + surname + ",\n" : "")
				+ (dob != null ? "dob: " + dob + ",\n" : "") + "service: " + service + ",\n"
				+ (race != null ? "race: " + race + ",\n" : "") + "salary: " + salary;
	}

	
}