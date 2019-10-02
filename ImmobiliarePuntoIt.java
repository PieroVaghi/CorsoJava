package test;

public class ImmobiliarePuntoIt {

	public static void main(String[] args) {
		// Problema: costo casa (rettangolare) (1200 m2) + giardino
		//DICHIARAZIONE
		int base, altezza, costom2;
		//INPUT
		base = 50;
		altezza = 1;
		costom2 = 1200;
		//CALCOLO
		int m2 = base * altezza;
		int costoCasa = m2 * costom2;
		String risposta = 	"La casa che vuoi comprare misura:\t" + m2 + " metri quadrati.\n" +
							"La casa che vuoi comprare costa:\t" + costoCasa + " €";
		int mq2Giardino = 1000;
		m2 = m2 + mq2Giardino;
		costoCasa = m2 * costom2;
		//OUTPUT
		System.out.println(risposta);
		risposta =	"Con giardino la casa misurerà:\t\t" + m2 + " metri quadrati.\n" +
					"Con giardino la casa costerà:\t\t" + costoCasa + " €";
		System.out.println(risposta);

	}
	
}
