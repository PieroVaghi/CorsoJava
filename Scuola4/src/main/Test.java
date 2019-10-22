package main;

import java.io.File;
import java.util.Scanner;

import entities.Docente;
import entities.PnD;
import entities.Studente;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Scanner dati = new Scanner(new File("src/res/istitutoAlberghiero/dati.txt"));
		String[] lunghezze = dati.nextLine().split(",");
		Studente[] studenti = new Studente[Integer.parseInt(lunghezze[0])];
		Docente[] docenti = new Docente[Integer.parseInt(lunghezze[1])];
		PnD[] pnd = new PnD[Integer.parseInt(lunghezze[2])];
		int contS = 0;
		int contD = 0;
		int contP = 0;
		Studente s = null;
		Docente d = null;
		PnD p = null;
		
		while(dati.hasNextLine()) {
			String[] parti = dati.nextLine().split(",");
			switch (parti[0].toUpperCase()) {
				case "STUDENTE":
					if(Studente.isValido(parti)) {
						s = new Studente(Integer.parseInt(parti[1]), parti[2], parti[3], parti[4], parti[5], parti[6], parti[7]);
						studenti[contS] = s;
						contS ++;
					}
				break;
				case "DOCENTE":
					if(Docente.isValido(parti)) {
						d = new Docente(Integer.parseInt(parti[1]), parti[2], parti[3], parti[4], parti[5], parti[6], parti[0], Double.parseDouble(parti[7]), Integer.parseInt(parti[8]), parti[9]);
						docenti[contD] = d;
						contD ++;
					}
				break;
				case "PND":
					if(PnD.isValido(parti)) {
						p = new PnD(Integer.parseInt(parti[1]), parti[2], parti[3], parti[4], parti[5], parti[6], parti[0], Double.parseDouble(parti[7]), Integer.parseInt(parti[8]), parti[9]);
						pnd[contP] = p;
						contP ++;
					}
				break;
				default:
					System.out.println("Personaggio non idoneo alla nostra scuola..");
				
			}
		}
	
		dati.close();
		for(Studente s1 : studenti)
			System.out.println(s1.toString());
	}

}
