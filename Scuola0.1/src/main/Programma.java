package main;

import java.io.File;
import java.util.Scanner;

import entities.Studente;

public class Programma {

	public static void main(String[] args) throws Exception {

		String menuITA = "";
		String percorso = "src/res/menuITA.txt";
		Scanner datiMenu = new Scanner(new File(percorso));
		while(datiMenu.hasNextLine()) {
			menuITA += datiMenu.nextLine() + "\n";
		}
		datiMenu.close();
		System.out.println(menuITA);	
		
		Studente s = new Studente();
		percorso = "src/res/dati.txt";
		Scanner datiStudente = new Scanner(new File(percorso));
		
		if(datiStudente.hasNextLine()) {
			s.nome = datiStudente.nextLine();
			s.cognome = datiStudente.nextLine();
			s.dataNascita = datiStudente.nextLine();
			s.genere = datiStudente.nextLine();
			s.mediaIta = Double.parseDouble(datiStudente.nextLine());
			s.mediaIng = Double.parseDouble(datiStudente.nextLine());
			s.mediaInf = Double.parseDouble(datiStudente.nextLine());
			s.mediaMat = Double.parseDouble(datiStudente.nextLine());
		}
		else
			System.out.println("Gentile cliente, la preghiamo di inserire correttamente nel file i dati relativi ad uno studente, rispettando l'ordine: nome, cognome, data nascita, genere, media ita, media ing, media info, media mat");
		datiStudente.close();
		
		Scanner tastiera = new Scanner(System.in);
		int comando = 0;
		String risposta = "";
		do {
			comando = Integer.parseInt(tastiera.nextLine());
			risposta = "";
			
			switch (comando) {
				case 0: 
					risposta = "Ciao Ciao..";
				break;
				case 1: 
					risposta = "La Media totale delle tue materie è: " + s.media();
				break;
				case 2: 
					risposta = "La somma dei voti è " + s.somma();
				break;
				case 3: 
					risposta = s.isPromosso() ? "Congratulazioni!!! Quest'anno sarai promosso!" : "Spiacenti, non sei stato promosso.. Impegniati di più e ritenta il prossimo anno!";
				break;
				case 4: 
					risposta = s.erasmus();
				break;
				case 5:
					risposta = s.toString();
				break;
				case 9:
					risposta = menuITA;
				break;
				default:
					risposta = "Hai inserito un comando errato LOLLONE!";
				break;
			}
			System.out.println(risposta);
		} while (comando != 0);
		

		tastiera.close();
	}

}
