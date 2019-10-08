package main;

import java.util.Scanner;

import entities.Studente;

public class Main {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);
		Studente s1 = new Studente();
		String intro = "\nBuongiorno! grazie per aver inserito i tuoi dati all'interno del nostro programma!\n";
		String menu = "\nPer conoscere la media dei tuoi voti, premi\t\t--> 1\n"
					+ "Per sapere se sarai promosso o no, premi\t\t--> 2\n"
					+ "Per sapere se e dove andrai in erasmus, premi\t\t--> 3\n"
					+ "Per conoscere quanti anni ti mancano al diploma, premi\t--> 4\n"
					+ "Per un'anteprima del tuo curriculum, premi\t\t--> 5";
		
		int comando = 0;
		
		//INSERIMENTO DATI STUDENTE
		
		System.out.println("Inserisci nome:");
		s1.nome = tastiera.nextLine();
		System.out.println("Inserisci cognome:");
		s1.cognome = tastiera.nextLine();
		System.out.println("Inserisci data di nascita:");
		s1.datanascita = tastiera.nextLine();
		System.out.println("Inserisci Titolo di Studio Pregresso:");
		s1.titolostudiopreg = tastiera.nextLine();
		System.out.println("Inserisci indirizzo di studi:");
		s1.indirizzo = tastiera.nextLine();
		System.out.println("Inserisci sezione:");
		s1.sezione = tastiera.nextLine();
		System.out.println("Inserisci Anno di Diploma:");
		s1.annodiploma = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di inglese:");
		s1.mediaing = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di italiano:");
		s1.mediaita = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di informatica:");
		s1.mediainf = Double.parseDouble(tastiera.nextLine());
		System.out.println("Inserisci la media dei voti di matematica:");
		s1.mediamat = Double.parseDouble(tastiera.nextLine());
		
		do {
			String stampa = "";
			switch (comando) {
				case 0: 
					stampa += intro;
				break;
				case 1: 
					stampa += "La Media totale delle tue materie è: " + s1.media();
				break;
				case 2: 
					stampa += s1.isPromosso() ? "Congratulazioni!!! Quest'anno sarai promosso!" : "Spiacenti, non sei stato promosso.. Impegniati di più e ritenta il prossimo anno!";
				break;
				case 3: 
					stampa += "Quest'anno.. " + s1.erasmus();
				break;
				case 4: 
					stampa += (s1.anniAlDiploma() == 0) ? 	"Ti manca meno di un anno al diploma o ti sei già diplomato, quindi non stressare!" 
														:	"Per diplomarti ti mancano " + s1.anniAlDiploma() + "anni";
				break;
				case 5:
					stampa += s1.stampaStudente();
				break;
				default:
					stampa += "Hai inserito un comando errato LOLLONE!";
				break;
			}
			
			stampa += "\n\nInserisci un nuovo comando oppure 0 per terminare:" + menu;
			System.out.println(stampa);
			comando = Integer.parseInt(tastiera.nextLine());
		} while(comando!=0);
		
		System.out.println("Ciaone!!!");
		tastiera.close();
	}

}
