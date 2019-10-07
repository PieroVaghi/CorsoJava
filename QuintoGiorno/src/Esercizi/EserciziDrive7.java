package Esercizi;

import java.util.Scanner;

public class EserciziDrive7 {

	public static void main(String[] args) {
		/*
		 * Come al punto sei, ma se l’utente inserisce un tempo negativo, il programma deve terminare senza stampare il montante, ma stampare invece un errore
		 */
		
		Scanner tastiera = new Scanner(System.in);
		String risposta = "";
		
		System.out.println("Inserisci il capitale iniziale in euro:");
		double capitale = Double.parseDouble(tastiera.nextLine());
		double nuovoCapitale = capitale;
		System.out.println("Inserisci il tasso di interesse annuo in percentuale:");
		int interesse = Integer.parseInt(tastiera.nextLine());
		
		boolean isCorretto = true;
		System.out.println("Inserisci la durata dell'investimento in numero di mesi:");
		int mesi = Integer.parseInt(tastiera.nextLine());
		
		if( mesi < 0 )
			isCorretto = false;
		
		if(isCorretto) {
			int cont = 0;
			
			while (cont != mesi/12) {
				nuovoCapitale += (nuovoCapitale/100)*interesse;
				cont ++;
			}
			
			nuovoCapitale -= capitale;
			int perditaDati = (int)(nuovoCapitale*100);		
			nuovoCapitale = perditaDati/100.00; 
			risposta += "Dopo " + mesi + " mesi di investimento ad un tasso del " + interesse + "%\n" +
						"Hai ottenuto un montante di: " + nuovoCapitale + " €";
		}
		else
			risposta += "ATTENZIONE! E' stato inserito un valore negativo di mesi.";
		
		System.out.println(risposta);
		
		tastiera.close();
		

	}

}
