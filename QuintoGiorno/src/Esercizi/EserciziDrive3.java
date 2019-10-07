package Esercizi;

import java.util.Scanner;

public class EserciziDrive3 {

	public static void main(String[] args) {
		/*
		 * scrivere un programma che riceve in input i dati di una persona per determinare il prezzo dell’ingresso in discoteca.
		 * Il biglietto a prezzo pieno costa 20 euro.
		 * Le donne hanno diritto a uno sconto di 10 euro.
		 * Gli under 20 hanno diritto a uno sconto ulteriore di 5.
		 * Determinare il prezzo del biglietto in output.
		 */

		Scanner tastiera = new Scanner(System.in);
		int prezzo = 20;
		
		System.out.println("Inserisci il tuo genere: ");
		if(tastiera.nextLine().equalsIgnoreCase("f"))
			prezzo -= 10;
		
		System.out.println("Inserisci la tua età: ");
		if(Integer.parseInt(tastiera.nextLine()) < 20)
			prezzo -= 5;
		
		String risposta = "Per te il biglietto di ingresso costa: " + prezzo + " €";
		System.out.println(risposta);
		
		tastiera.close();
	}

}
