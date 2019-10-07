package Esercizi;

import java.util.Scanner;

public class EserciziDrive8 {

	public static void main(String[] args) {
		/*
		 * Inserire il numero di adulti e di bambini che devono acquistare un biglietto.
		 * Gli adulti pagano 10 euro, i bambini 5.
		 * Ogni 10 bambini, un adulto è gratis.
		 * Sopra i 50 bambini, il biglietto viene rifiutato (viene stampato un messaggio di errore al posto del biglietto)
		 * NON SERVE CICLARE
		 */

		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Quanti adulti devono acquistare il biglietto?");
		int adulti = Integer.parseInt(tastiera.nextLine());
		System.out.println("Quanti bambini devono acquistare il biglietto?");
		int bambini = Integer.parseInt(tastiera.nextLine());
		
		int prezzoA = 10;
		int prezzoB = 5; 
		
		int adultiGratis = bambini/10;
		
		
		
	}

}
