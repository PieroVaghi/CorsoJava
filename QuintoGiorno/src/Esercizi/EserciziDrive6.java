package Esercizi;

import java.util.Scanner;

public class EserciziDrive6 {

	public static void main(String[] args) {
		/*
		 * scrivere un programma che riceve in ingresso il capitale, il tasso di interesse annuo e la durata dell’investimento, espressa in mesi.
		 * Stampare il montante
		 */

		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci il capitale iniziale in euro:");
		double capitale = Double.parseDouble(tastiera.nextLine());
		double nuovoCapitale = capitale;
		System.out.println("Inserisci il tasso di interesse annuo in percentuale:");
		int interesse = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci la durata dell'investimento in numero di mesi:");
		int mesi = Integer.parseInt(tastiera.nextLine());
		
		int cont = 0;
		
		while (cont != mesi/12) {
			nuovoCapitale += (nuovoCapitale/100)*interesse;
			cont ++;
		}
		
		nuovoCapitale -= capitale;
		int perditaDati = (int)(nuovoCapitale*100);		
		nuovoCapitale = perditaDati/100.00; 
		
		String risposta = 	"Dopo " + mesi + " mesi di investimento ad un tasso del " + interesse + "%\n" +
							"Hai ottenuto un montante di: " + nuovoCapitale + " €";
		
		System.out.println(risposta);
		
		tastiera.close();
		
	}

}
