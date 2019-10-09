package main;

import java.util.Scanner;

import entities.Libro;


public class Main {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		Libro gio = new Libro();
		String intro = "\nBuongiorno! grazie per aver inserito i tuoi dati all'interno del nostro programma!\n";
		String menu = "\nPer conoscere del libro, premi\t\t--> 1\n"
					+ "Per conoscere l'eventuale costo scontato, premi\t\t--> 2\n"
					+ "Per sapere se è un audiolibro, premi\t\t--> 3\n"
					+ "Per sapere se è il genere preferito dal docente, premi\t--> 4\n"
					+ "Per visualizzare la scheda del libro, premi\t\t--> 5";
		
		int comando = 0;
		
		//INSERIMENTO DATI STUDENTE - ASSEGNAZIONI DELLE PROPRIETA? DI UN OGGETTO
		
		System.out.println("Inserisci nome:");
		gio.nome = tastiera.nextLine();
		System.out.println("Inserisci cognome:");
		gio.cognome = tastiera.nextLine();
		System.out.println("Inserisci data di nascita:");
		gio.datanascita = tastiera.nextLine();
		System.out.println("Inserisci Titolo di Studio Pregresso:");
		gio.titolostudiopreg = tastiera.nextLine();
		System.out.println("Inserisci indirizzo di studi:");
		gio.indirizzo = tastiera.nextLine();
		System.out.println("Inserisci sezione:");
		gio.sezione = tastiera.nextLine();
		System.out.println("Inserisci Anno di Diploma:");
		gio.annodiploma = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di inglese:");
		gio.mediaing = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di italiano:");
		gio.mediaita = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di informatica:");
		gio.mediainf = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di matematica:");
		gio.mediamat = Double.parseDouble(tastiera.nextLine());



	}

}
