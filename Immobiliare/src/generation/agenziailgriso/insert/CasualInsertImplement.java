package generation.agenziailgriso.insert;

import generation.agenziailgriso.entities.Apartment;
import generation.agenziailgriso.entities.Ground;
import generation.agenziailgriso.entities.Property;
import generation.agenziailgriso.entities.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import generation.agenziailgriso.context.*;

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

	private final String[] address = {"Saronno","Cogliate","Gerenzano","Uboldo","Turate","RovelloPorro","Rovellasca","Empoli",};
	private final String[] owner = {"Giggino il Truce", "Pierpiero", "Paolo", "Pietro", "Ughwak", "DArtagnan", "Ursula", "Armin", "Arminio", "Armenio", "Almeno", "Arlecchino", "Kong il Conquistatore", "King di Kong", "Beatrice", "Elena", "Piero", "Simone", "Mauro", "Giada", "Tommaso", "Ferdinando", "Andrea", "Dennis", "Hertz", "Marco", "Simone", "Fabio", "Alessio", "Alessio 2 la vendetta", "Luca", "Antonietta"};
	private final String[] notes = {"Bello", "Bellissimo", "Non ci vivrei", "Fantastico", "Ha la piscina", "Puzza", "Verdastro il pavimento", "5 minuti dal centro 5 minuti dalla perdizione"};
	private final String[] permits = {"edificabile", "agreste", "pascolo", "forestale", "riservanaturale"};
	private final String[] state = {"Incolto", "Abbandonato", "Rudere", "Perfetto", "Foresta","Libero"};
		
	public int randomBetween(int i, int f) {
		Random rand = new Random();
		// Obtain a number between [0 - 49].
		int n = rand.nextInt(f);
		// Add 1 to the result to get a number from the required range
		// (i.e., [1 - 50]).
		return n += i;
	}
	
	@Override
	public List<Property> random(int s1, int s2) {
		int cont = s1;
		List<Property> res = new ArrayList<Property>();
		while(cont <= s2) {
			Property p = null;
			
			switch (randomBetween(1,3)){
			case 1:
				p = new Apartment();
				p.setId(cont);
				p.setAddress(address[randomBetween(0, address.length-1)]);
				p.setValue(randomBetween(100, 1000000));
				p.setNotes(notes[randomBetween(0, notes.length-1)]);
				p.setSqm(randomBetween(25, 1000));
				p.setOwner(owner[randomBetween(0, owner.length-1)]);
				((Apartment)p).setFloor(randomBetween(0, 50));
				((Apartment)p).setRooms(randomBetween(1, 10));
				((Apartment)p).setBalconis(randomBetween(0, 4));
				((Apartment)p).setBathrooms(randomBetween(1, 5));
				break;
			case 2:
				p = new Shop();
				p.setId(cont);
				p.setAddress(address[randomBetween(0, address.length-1)]);
				p.setValue(randomBetween(100, 1000000));
				p.setNotes(notes[randomBetween(0, notes.length-1)]);
				p.setSqm(randomBetween(25, 1000));
				p.setOwner(owner[randomBetween(0, owner.length-1)]);
				((Shop)p).setWindows(randomBetween(1, 5));
				((Shop)p).setWerehouse(randomBetween(0, 100));
				((Shop)p).setTraffic(randomBetween(0, 100000));
				break;
			case 3:
				p = new Ground();
				p.setId(cont);
				p.setAddress(address[randomBetween(0, address.length-1)]);
				p.setValue(randomBetween(100, 1000000));
				p.setNotes(notes[randomBetween(0, notes.length-1)]);
				p.setSqm(randomBetween(25, 1000));
				p.setOwner(owner[randomBetween(0, owner.length-1)]);
				((Ground)p).setPermits(permits[randomBetween(0, permits.length-1)]);
				((Ground)p).setState(state[randomBetween(0, state.length-1)]);
				break;
			}
			res.add(p);
			cont ++;
		}
		return res;
	}
	
	

}
