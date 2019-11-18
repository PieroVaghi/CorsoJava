package entities;

public class Soldier extends Unit
{
	String name, surname, dob;
	int service; // mesi in servizio
	String race; // ork, eldar, tyrannid, human, necron
	int salary;
	
	//ragionare in base all'anzianità
	public boolean retires()
	{
		return false;
	}
	
	@Override
	public boolean valid() {
		return 	super.valid()			&&
				notVoid(name)			&&
				notVoid(surname)		&&
				notVoid(dob)			&&
				between(service,0,100)	&&
				notVoid(race)			&&
				between(salary,0,10000)	;
	}
	
}