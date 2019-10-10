package main;

import java.io.File;
import java.util.Scanner;

import entities.Pc;


public class Programma {

	public static void main(String[] args) throws Exception {

		String menuITA = "";
		String percorso = "src/res/menuPc.txt";
		Scanner datiMenu = new Scanner(new File(percorso));
		while(datiMenu.hasNextLine()) {
			menuITA += datiMenu.nextLine() + "\n";
		}
		datiMenu.close();
		System.out.println(menuITA);	
		
		Pc s = new Pc();
		percorso = "src/res/pcDiAldo.txt";
		Scanner datiStudente = new Scanner(new File(percorso));
		
		if(datiStudente.hasNextLine()) {
			s.id = Integer.parseInt(datiStudente.nextLine());
			s.marca = datiStudente.nextLine();
			s.modello = datiStudente.nextLine();
			s.cpu = datiStudente.nextLine();
			s.tiporam = datiStudente.nextLine();
			s.tipomma = datiStudente.nextLine();
			s.ram = Integer.parseInt(datiStudente.nextLine());
			s.mma = Integer.parseInt(datiStudente.nextLine());
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
					risposta = "Il costo complessivo del tuo PC � pari a: " + s.costo() + " �";
				break;
				case 2: 
					risposta = "Il costo della CPU � pari a: " + s.costocpu() + " �";
				break;
				case 3: 
					risposta = "Il costo della RAM � pari a: " + s.costoram() + " �";
				break;
				case 4: 
					risposta = "Il costo della MMA � pari a: " + s.costomma() + " �";
				break;
				case 5:
					risposta = s.isGaming() ? "Il tuo � un PC da Gaming!" : "Il tuo non sar� un PC da Gaming ma dai.. � bello lo stesso!";
				break;
				case 6:
					risposta = s.isOffice() ? "Il tuo � un dignitosissimo PC da ufficio! Non esagerare!" : "Nel mio ufficio, un PC come il tuo non lo voglio!!";
				break;
				case 7:
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
