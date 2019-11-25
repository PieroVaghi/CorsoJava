package generation.office.insert;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import generation.office.entities.Employee;

/*
import java.util.Random;

Random rand = new Random();

// Obtain a number between [0 - 49].
int n = rand.nextInt(50);

// Add 1 to the result to get a number from the required range
// (i.e., [1 - 50]).
n += 1;
 */

public class CasualInsertImplement implements CasualInsert {

//	private final String[] genders = {"F","M"};
	private final String[] name = {"Giggino il Truce", "Pierpiero", "Paolo", "Pietro", "Ughwak", "DArtagnan", "Ursula", "Armin", "Arminio", "Armenio", "Almeno", "Arlecchino", "Kong il Conquistatore", "King di Kong", "Beatrice", "Elena", "Piero", "Simone", "Mauro", "Giada", "Tommaso", "Ferdinando", "Andrea", "Dennis", "Hertz", "Giovanni", "Francesco", "Matteo","Lancia", "Villa", "Rotondi", "Clerici", "Marta", "Marco", "Simone", "Fabio", "Alessio", "Alessio 2 la vendetta", "Luca", "Antonietta"};
	private final String[] roles = {"HR", "Programmatore Junior", "CEO", "Project Manager", "Inserviente", "Food&Beverage", "Vendite", "Marketing"};
		
	public int randomBetween(int i, int f) {
		int dif = f-i;
		Random rand = new Random();
		// Obtain a number between [0 - 49].
		int n = rand.nextInt(dif);
		// Add 1 to the result to get a number from the required range
		// (i.e., [1 - 50]).
		return n += i;
	}
	
	@Override
	public List<Employee> random(int s1, int s2) {
		int cont = s1;
		List<Employee> res = new ArrayList<Employee>();
		while(cont <= s2) {
			Employee p = new Employee();
			p.setId(cont);
			p.setName(name[randomBetween(0, name.length-1)]);
			p.setSurname(name[randomBetween(0, name.length-1)]);
			p.setRole(roles[randomBetween(0, roles.length-1)]);
			p.setSalary(randomBetween(800, 8000));
			p.setGender(randomBetween(0, 2) == 1 ? "M":"F");
			p.setDob(randomBetween(1950, 2002)+"-"+randomBetween(1, 12)+"-"+randomBetween(1, 28));
			res.add(p);
			cont ++;
		}
		return res;
	}
	
	

}
