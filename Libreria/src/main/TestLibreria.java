package main;

import java.io.File;
import java.util.Scanner;

import entities.Libro;


public class TestLibreria {

	public static void main(String[] args) throws Exception {
		
		Scanner tastiera = new Scanner(System.in);		
		String intro = "\nBuongiorno! Grazie per aver inserito i tuoi dati all'interno del nostro programma!\n";
		String menu = "\nPer conoscere il costo del libro, premi\t\t\t--> 1\n"
					+ "Per conoscere l'eventuale costo siato, premi\t\t--> 2\n"
					+ "Per sapere se è un audiolibro, premi\t\t\t--> 3\n"
					+ "Per sapere se è il genere preferito dal docente, premi\t--> 4\n"
					+ "Per visualizzare la scheda del libro, premi\t\t--> 5";
		
		int comando = 0;
		String percorso = "src/res/dati.txt";
		
		Scanner dati = new Scanner(new File(percorso));
		int nlibri = Integer.parseInt(dati.nextLine());
		Libro[] libri = new Libro[nlibri];
		
		int i = 0;
		while(dati.hasNextLine()) {					// Faccio new tante volte quanti sono gli oggetti che devo creare
			Libro l = new Libro();
			String[] riga = dati.nextLine().split(",");		
			l.titolo = riga[0];
			l.autore = riga[1];
			l.genere = riga[2];
			l.casaEditrice = riga[3];
			l.nPag = Integer.parseInt(riga[4]);
			libri[i] = l;
			i ++;
		}
		dati.close();
		
//		for(int j = 0; j < libri.length; j++)
//			System.out.println(libri[j].titolo);
		
		do {
			String stampa = "";
			switch (comando) {
				case 0: 
					stampa += intro + menu;
				break;
				case 1: 
					stampa += "Il costo del libro inserito è: " + libri[0].costo();
				break;
				case 2:
					stampa += (libri[0].costo()!=libri[0].sconto()) ? 
						"Il prezzo siato del libro inserito è: " + libri[0].sconto()
						:
						"Nessuno sconto può essere applicato al libro in questione.";
				break;
				case 3: 
					stampa += (libri[0].isAudioLibro()) ? "E' un audiolibro" : "Non è un audiolibro";
				break;
				case 4: 
					stampa += (libri[0].isGenereGloriaPref()) ? 	"Si, " + libri[0].genere + " è tra i generi preferiti del docente!" 
														:	"Il genere " + libri[0].genere + " non è tra i preferiti di Gloria";
				break;
				case 5:
					stampa += libri[0].scheda();
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
		
		System.out.println("Ciao Proprio!");
		tastiera.close();
		


	}

}
