package test;

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
		String risposts = "";
		do {
			System.out.println(menuITA);		
		} while (comando != 0);
		
		

	}

}
