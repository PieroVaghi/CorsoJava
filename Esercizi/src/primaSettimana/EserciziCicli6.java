package primaSettimana;

import java.util.Scanner;

public class EserciziCicli6 {

	public static void main(String[] args) {
		/*
		 * L'utente inserisce i dati di n vetture.
		 * Per ogni vettura inserire marcaa, modello, cilindrata, prezzo.
		 * Calcola il costo medio delle auto Fiat e VolksWagen. 
		 * Calcolo il costo medio di tutte le vetture.
		 * calcolo il costo massimo di una vettura
		 */
		
		Scanner tastiera = new Scanner(System.in);
		String risposta = "";
		int cont = 0;
		
		System.out.println("Quante auto vuoi inserire?");
		int numAuto = Integer.parseInt(tastiera.nextLine());
		
		double mediaCosto = 0, mediaFiat = 0, mediaVolk = 0;
		int contFiat = 0, contVolk = 0;
		int prezzoMax = 0;
		
		while (cont != numAuto) {
			cont ++;
			System.out.println("Inserisci marca:");
			String marca = tastiera.nextLine();
			risposta += "Auto " + cont + " - \tMarca: " + marca;
			System.out.println("Inserisci modello:");
			risposta += "\tModello: " + tastiera.nextLine();
			System.out.println("Inserisci cilindrata:");
			risposta += "\tCilindrata: " + tastiera.nextLine();
			System.out.println("Inserisci prezzo:");
			int prezzo = Integer.parseInt(tastiera.nextLine());
			risposta += "\tPrezzo: " + prezzo + " €\n";
			
			mediaCosto += prezzo;
			if(prezzoMax < prezzo)
				prezzoMax = prezzo;
			if(marca.equalsIgnoreCase("fiat")) {
				contFiat ++;
				mediaFiat += prezzo;
			} else if(marca.equalsIgnoreCase("volkswagen")) {
				contVolk ++;
				mediaVolk += prezzo;
			}			
		}
		
		if(numAuto != 0)
			mediaCosto /= numAuto;
		if(contFiat != 0)
			mediaFiat /= contFiat;
		if(contVolk != 0)
			mediaVolk /= contVolk;
		
		risposta += "-----------------------------------------------------------------------------------------\n" + 
					"Costo medio di tutte le vetture:\t" + mediaCosto + " €\n" +
					"Costo medio vetture Fiat:\t\t" + mediaFiat + " €\n" +
					"Costo medio vetture VolksWagen:\t\t" + mediaVolk + " €\n" + 
					"Il costo massimo di una vettura è:\t" + prezzoMax + " €";
		
		System.out.println(risposta);
		tastiera.close();

	}

}
