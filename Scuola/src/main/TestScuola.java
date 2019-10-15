package main;

import java.io.File;
import java.util.Scanner;

import aggregatore.Scuola;
import entities.Docente;
import entities.Studente;

public class TestScuola {

	public static void main(String[] args) throws Exception {
		
		//Creo l'oggetto della classe aggregatrice
		Scuola school = new Scuola();
		
		Scanner datimenu = new Scanner(new File("src/res/menu2.txt"));
		String menu = "";
		while(datimenu.hasNextLine()) {
			menu += datimenu.nextLine() + "\n";
		}
		datimenu.close();
		
		
		Scanner tastiera = new Scanner(System.in);
		int comando = 0;
		
		do {
			System.out.println(menu);
			comando = Integer.parseInt(tastiera.nextLine());
			String risposta = "";
			int cont = 0;
			switch(comando) {
				case 0:
					risposta = "Ciao Bello!";
				break;
				case 1:
					risposta = "La media globale di tutti gli studeti è: " + school.mediaVotiStudenti() + "\n";
				break;
				case 2:
					risposta = "Gli studenti promossi sono:\n" + school.studentiPromossi() + "\n";
				break;
				case 3:
					risposta = "Gli studenti bocciati sono:\n" + school.studentiBocciati() + "\n";
				break;
				case 4:
					risposta = "Gli studenti che andranno in erasmus sono:\n" + school.studentiInErasmus() + "\n";		
				break;
				case 5:
					risposta = "Elenco Studenti:\n\n" + school.stampaStudenti() + "\n";	
				break;
				case 6:
					risposta = "Il numero totale degli studenti è: " + school.numStudenti() + "\n";
				break;
				case 7:
					risposta = "Il numero totale dei docenti è: " + school.numDocenti() + "\n";
				break;
				case 8:
					risposta = "La somma totale degli stipendi dei docenti è: " + school.sommaStipendi() + " €\n";
				break;
				case 9:
					risposta = "La media degli stipendi dei docenti è: " + school.mediaStipendi() + "\n";
				break;
				case 10:
					risposta = "Elenco Docenti:\n\n" + school.stampaDocenti() + "\n";					
				break;
				case 11:
					risposta = "Il numero totale di persone presenti a scuola è: " + school.numTotale() + "\n";
				break;
				case 12:
					risposta = "Numero materie per docente:\n" + school.materiePerDocente() + "\n";	
				break;
				case 13:
					risposta = "Docenti di informatica:\n" + school.docentiInformatica() + "\n";
				break;
				default:
					risposta = "Hai inserito un comando non riconosciuto!";
				break;
			
				
			}
			System.out.println(risposta);
		} while (comando != 0);
		
		tastiera.close();
	}

}