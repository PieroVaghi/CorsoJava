package main;

import java.util.Scanner;

import aggregatore.ScuolaCSV;

public class Programma {

	public static void main(String[] args) throws Exception {

		Scanner tastiera = new Scanner(System.in);
		String scuola = "";
		do {
		System.out.println("Puoi scegliere di vederi i dati dell'Alberghiero o dell'Agraria:");
		scuola = tastiera.nextLine().toLowerCase();
		} while(!scuola.equals("alberghiero") || !scuola.equals("agraria"));
		String percorso = "src/res/" + scuola + "/dati.txt";
		
		ScuolaCSV s = new ScuolaCSV(percorso);
		
		//menu
		
		//metodi
		
		System.out.println("Tot stipendi " + scuola + " :" + s.totstipendi());
		
		tastiera.close();
	}
}
