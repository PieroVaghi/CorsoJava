package test;

import java.util.Scanner;

public class DoWhileMedia {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		
		double altezzaMedia = 0;
		int cont = 0;
		String continua = "no";
		
		do {
			System.out.println("Inserisci la tua altezzaMedia: ");
			altezzaMedia += Double.parseDouble(tastiera.nextLine());
			cont ++;
			
			System.out.println("Vuoi cotinuare?");
			continua = tastiera.nextLine();
		} while (continua.equalsIgnoreCase("si"));
		
		altezzaMedia /= cont;
		int perditaDati = (int)(altezzaMedia*100);	// Valore castato in intero
		altezzaMedia = perditaDati/100.00;  		// Divido il valore castato per un 100.00 in double perchè altrimenti la divisione di due interi restituisce un intero

		System.out.println(altezzaMedia);
		tastiera.close();

	}

}
