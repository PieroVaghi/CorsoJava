package test;

import java.util.Scanner;

public class EsercizioInserimento {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);
		int eta;
		double altezza;
		String genere;
		String risposta = "";
		boolean corretto = true;
		
		do {
			System.out.println("Inserisci la tua età:");
			eta = Integer.parseInt(tastiera.nextLine());
			if(eta < 0 || eta > 130)
				System.out.println("INSERIMENTO SCORRETTO: (0-130)");
		} while (eta < 0 || eta > 130);
		
		do {
			System.out.println("Inserisci la tua altezza in metri:");
			altezza = Double.parseDouble(tastiera.nextLine());
			if(altezza < 0.5 || altezza > 3.10)
				System.out.println("INSERIMENTO SCORRETTO: (0.5-3.10)");
		} while (altezza < 0.5 || altezza > 3.10);
		
		do {
			System.out.println("Inserisci il tuo genere:");
			genere = tastiera.nextLine();
			if(	!genere.equalsIgnoreCase("m") &&
				!genere.equalsIgnoreCase("f") &&
				!genere.equalsIgnoreCase("n")) {
					System.out.println("INSERIMENTO SCORRETTO: (M,F,N)");
					corretto = false;
			}
				
//			switch (genere.toUpperCase()) {
//				case "M":
//					corretto = true;
//				break;
//				case "F":
//					corretto = true;
//				break;
//				case "G":
//					corretto = true;
//				break;
//				default:
//					corretto = false;
//					System.out.println("INSERIMENTO SCORRETTO");
//				break;					
//			}
			
		} while (!corretto);
		
		risposta += "+-----------------------------------------------+\n" 	+ 
					"|\tBravo! Hai inserito i dati corretti\t|\n" 	+
					"+-----------------------------------------------+";
		System.out.println(risposta);
		tastiera.close();

	}

}
