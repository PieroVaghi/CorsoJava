package test;

import java.io.File;
import java.util.Scanner;

import aggregatore.CD;
import entities.Traccia;

public class testCDTracce {

	public static void main(String[] args) throws Exception{
//		Traccia t1 = new Traccia(1,"Elicrisio","Folkstone",5);
//		Traccia t2 = new Traccia(2,"JingleBels","Folkstone",3);
//		Traccia t3 = new Traccia(1,"Caramelle","TonyEffe,Wayne,Pyrex",3.4);
//		Traccia t4 = new Traccia(4,"You make me wanna","Blue,BackstreetBoys",4.2);
		
		Scanner datimenu = new Scanner(new File("src/res/menuCD.txt"));
		String menu = "";
		while(datimenu.hasNextLine()) {
			menu += datimenu.nextLine() + "\n";
		}
		datimenu.close();
		
		Scanner dati = new Scanner(new File("src/res/CD.txt"));
		
		String titolo = dati.nextLine();
		String etichetta = dati.nextLine();
		String data = dati.nextLine();
		double costo = Double.parseDouble(dati.nextLine());
		int ntracce = Integer.parseInt(dati.nextLine());
		String tracce = dati.nextLine();
		
		dati.close();
		
		CD c = new CD(titolo, etichetta, data, costo, ntracce, tracce);
		
		Scanner tastiera = new Scanner(System.in);
		int comando = 0;
		
		do {
			System.out.println(menu);
			comando = Integer.parseInt(tastiera.nextLine());
			String risposta = "";
			switch(comando) {
				case 0: 
					risposta = "CIAONE!!";
				break;
				case 1: 
					risposta = c.titoli();
				break;
				case 2: 
					risposta = "Il numero di artisti presenti in questo CD è: " + c.totaleNumeroArtisti();
				break;
				case 3: 
					System.out.println("Inserisci nome artista desiderato:");
					String artista = tastiera.nextLine();
					risposta = c.nomeTracce(artista);
				break;
				case 4: 
					System.out.println("Inserisci nome artista desiderato");
					artista = tastiera.nextLine();
					risposta = artista + " canta in questo disco per " + c.durataTracceArtista(artista) + " minuti!";
				break;
				case 5: 
					risposta = "La durata media delle canzoni e' " + c.mediaDurata();
				break;
				case 6: 
					risposta = "La durata totale del cd e' " + c.durata();
				break;
				case 7: 
					risposta = "La durata più breve è "+ c.minimo();
				break;
				case 8: 
					risposta = "La canzone più breve ha il titolo " + c.canzonePiuBreve();
				break;
				case 9:
					System.out.println("Inserisci la durata massima per la canzone che vuoi ascoltare:");
					double duratamassima = Double.parseDouble(tastiera.nextLine());
					risposta = c.titoliDurataSufficiente(duratamassima);
				break;
				case 10: 
					risposta = "RIASSUNTONE!\n" + c.toString();
				break;
				default: 
					risposta += "NON C'E' INTERNETTTTTTTTT!!!!";
				break;
			}
		
			System.out.println(risposta);
			
		} while (comando != 0);
		
		tastiera.close();
		
//		diariodiunultimo.tracce[0] = t1;
//		diariodiunultimo.tracce[1] = t2;
//		diariodiunultimo.tracce[2] = t3;
//		diariodiunultimo.tracce[3] = t4;
		
	}

}
