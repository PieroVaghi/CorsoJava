package main;

import java.util.Scanner;

import entities.Libro;


public class Main {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		Libro l1 = new Libro();
		String intro = "\nBuongiorno! Grazie per aver inserito i tuoi dati all'interno del nostro programma!\n";
		String menu = "\nPer conoscere il costo del libro, premi\t\t\t--> 1\n"
					+ "Per conoscere l'eventuale costo scontato, premi\t\t--> 2\n"
					+ "Per sapere se è un audiolibro, premi\t\t\t--> 3\n"
					+ "Per sapere se è il genere preferito dal docente, premi\t--> 4\n"
					+ "Per visualizzare la scheda del libro, premi\t\t--> 5";
		
		int comando = 0;
		
		//INSERIMENTO DATI STUDENTE - ASSEGNAZIONI DELLE PROPRIETA? DI UN OGGETTO
		
		System.out.println("Inserisci titolo:");
		l1.titolo = tastiera.nextLine(); 
		System.out.println("Inserisci autore:");
		l1.autore = tastiera.nextLine();
		System.out.println("Inserisci numero di pagine:");
		l1.nPag = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci il genere:");
		l1.genere = tastiera.nextLine();
		System.out.println("Inserisci casa editrice:");
		l1.casaEditrice = tastiera.nextLine();
		
		do {
			String stampa = "";
			switch (comando) {
				case 0: 
					stampa += intro + menu;
				break;
				case 1: 
					stampa += "Il costo del libro inserito è: " + l1.costo();
				break;
				case 2:
					stampa += (l1.costo()!=l1.sconto()) ? 
						"Il prezzo scontato del libro inserito è: " + l1.sconto()
						:
						"Nessuno sconto può essere applicato al libro in questione.";
				break;
				case 3: 
					stampa += (l1.isAudioLibro()) ? "E' un audiolibro" : "Non è un audiolibro";
				break;
				case 4: 
					stampa += (l1.isGenereGloriaPref()) ? 	"Si, " + l1.genere + " è tra i generi preferiti del docente!" 
														:	"Il genere " + l1.genere + " non è tra i preferiti di Gloria";
				break;
				case 5:
					stampa += l1.scheda();
				break;
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
