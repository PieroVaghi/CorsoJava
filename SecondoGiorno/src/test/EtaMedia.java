package test;

public class EtaMedia {

	public static void main(String[] args) {
		// Et� media di 5 persone e tot anni complessivi
			//DICHIARAZIONE INPUT
		int eta1 = 22;
		int eta2 = 25;
		int eta3 = 31;
		int eta4 = 25;
		int eta5 = 29;
		int numPers = 5;	
			//CALCOLO
		double totAnni = eta1 + eta2 + eta3 + eta4 + eta5;
		double mediaAnni = totAnni / numPers;
		String risposta =	"Somma et� =\t" +  totAnni +
							"\nMedia et� =\t" + mediaAnni;
			//OUTPUT
		System.out.println(risposta);
	}

}
