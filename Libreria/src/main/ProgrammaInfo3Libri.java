package main;

import java.io.File;
import java.util.Scanner;

import entities.Libro;


public class ProgrammaInfo3Libri {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		Libro lt = new Libro();
		Libro l1 = new Libro();
		Libro l2 = new Libro();
		Libro l3 = new Libro();
		
		//INSERIMENTO DATI LIBRO - ASSEGNAZIONI DELLE PROPRIETA? DI UN OGGETTO
//		System.out.println("Quanti libri vuole acquistare?");
		int numLib = 3;
		
//		Scanner dati = new Scanner(new File(""));
//		
//		String menu = "";
//		while(dati.hasNextLine()) {
//			
//		}
		
		String intro = "\nBuongiorno! Grazie per aver acquistato da noi!\n";
		String menu = "\nPer conoscere il costo totale dell'ordine, premi\t\t\t--> 1\n"
					+ "Per conoscere Il costo totale dei soli Fantasy, premi\t\t\t--> 2\n"
					+ "Per conoscere la media dei prezzi dell'ordine, premi\t\t\t--> 3\n"
					+ "Per visualizzare le schede complete di tutti gli acquisti, premi\t-->4\n";
		
		
		int comando = 0, cont = 0;
		
		while (cont<numLib) {
			
			switch (cont) {
				case 0:
					System.out.println("Inserisci il primo libro:\n");
				break;
				case 1:
					System.out.println("Inserisci il secondo libro:\n");
				break;
				case 2:
					System.out.println("Inserisci il terzo libro:\n");
				break;
				default:
				break;
			}
			
			System.out.println("Inserisci titolo:");
			lt.titolo = tastiera.nextLine(); 
			System.out.println("Inserisci autore:");
			lt.autore = tastiera.nextLine();
			System.out.println("Inserisci numero di pagine:");
			lt.nPag = Integer.parseInt(tastiera.nextLine());
			System.out.println("Inserisci il genere:");
			lt.genere = tastiera.nextLine();
			System.out.println("Inserisci casa editrice:");
			lt.casaEditrice = tastiera.nextLine();
			System.out.println("------------------------------------------------------\n");
			
			switch (cont) {
				case 0:
					l1 = lt.copia();
				break;
				case 1:
					l2 = lt.copia();
				break;
				case 2:
					l3 = lt.copia();
				break;
				default:
				break;
			}
			cont ++;
		}
		
		double costoTot = l1.costo() + l2.costo() + l3.costo();
		double costoF = 0.0;
		if(l1.genere.equalsIgnoreCase("Fantasy"))
			costoF += l1.sconto();
		if(l2.genere.equalsIgnoreCase("Fantasy"))
			costoF += l2.sconto();
		if(l3.genere.equalsIgnoreCase("Fantasy"))
			costoF += l3.sconto();
			
		String stampaTot =	l1.scheda() + 
				"\n------------------------------------------------------\n" +
							l2.scheda() +
				"\n------------------------------------------------------\n" +
							l3.scheda() +
				"\n------------------------------------------------------";
		
		do {
			String stampa = "";
			switch (comando) {
				case 0: 
					stampa += intro + menu;
				break;
				case 1: 
					stampa += "Il costo totale dei libri inseriti è: " + costoTot;
				break;
				case 2:
					stampa += "Il costo totale dei libri di genere Fantasy da te acquistati è pari a: " + costoF;
				break;
				case 3: 
					stampa += "La media dei prezzi dei tuoi acquisti è: " + (costoTot/3.0);
				break;
				case 4:
					stampa += stampaTot;
				case 9: 
					stampa += menu;
				break;
				default:
					stampa += "Hai inserito un comando errato LOLLONE!";
				break;
			}
			
			stampa += "\n\n--> Inserisci un comando, 9 per rileggere il menù oppure 0 per terminare:";
			System.out.println(stampa);
			comando = Integer.parseInt(tastiera.nextLine());
			
		} while(comando!=0);
		
		System.out.println("Ciaone!!!");
		tastiera.close();
		


	}

}
