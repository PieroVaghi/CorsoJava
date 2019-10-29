package main;

import java.io.File;
import java.util.Scanner;

import aggregatore.IAmministrazione;
import aggregatore.INegozio;
import aggregatore.Negozio;

public class TestJavaShop1 {

	public static void main(String[] args) throws Exception{
		
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Scegli il negozio che ti interessa tra javaronics o javaworld");
		String nomeShop = tastiera.nextLine();
		String percorsoProd = "src/res/" + nomeShop+"/datiPc.txt";
		String percorsoDip = "src/res/" + nomeShop+"/datiDip.txt";
		
		System.out.println("Quant'è il budget attuale?");
		double budget = Integer.parseInt(tastiera.nextLine());
		
		System.out.println("Quale tipologia di funzioni devi effettuare? amministrazione o clientela?");
		INegozio shopC = new Negozio(percorsoProd, percorsoDip, budget);
		IAmministrazione shopA = new Negozio(percorsoProd, percorsoDip, budget);
		
		
		
		Scanner datimenu = new Scanner(new File("src/res/MenuJavaShop1.txt"));
		String menu = "";
		while(datimenu.hasNextLine()) {
			menu += datimenu.nextLine() + "\n";
		}
		datimenu.close();
		
		int comando = 0;
		
		do {
			System.out.println(menu);
			comando = Integer.parseInt(tastiera.nextLine());
			String risposta = "";
			switch (comando) {
				case 0:
					risposta = "Ciao Bello!";
				break;
				case 1:
					risposta = "Il numero di prodotti del negozio è: " + shopC.nprodotti() + "\n";
				break;
				case 2:
					risposta = "Il numero totale di Pc presenti in negozio è: " + shopC.npc() + "\n";
				break;
				case 3:
					risposta = "Il numero totale dei Laptop presenti in negozio è: " + shopC.nlaptop() + "\n";
				break;
				case 4:
					risposta = "Il numero totale degli Smarphone presenti in negozio è: " + shopC.nsmartphone() + "\n";
				break;
				case 5:
					risposta = "Il numero totale delle lavatrici presenti in negozio è: " + shopC.nlavatrici() + "\n";
				break;
				case 6:
					System.out.println("Inserisci la CPU da ricercare: ");
					risposta = shopC.nprodottipercpu(tastiera.nextLine()) + " prodotti del nostro negozio posseggono la CPU indicata\n";
				break;
				case 7:
					risposta = "Ecco i computer più economici:\n" + shopC.schedepiueconomici() + "\n";
					break;
				case 8:
					risposta = "Ecco i computer più costosi:\n" + shopC.schedepiucostosi() + "\n";
					break;
				case 9:
					risposta = "Ecco i computer da Gaming:\n" + shopC.schedegaming() + "\n";
					break;
				case 10:
					risposta = "Ecco i computer da ufficio:\n" + shopC.schedeoffice() + "\n";
					break;
				case 11:
					System.out.println("Inserisci la CPU da ricercare: ");
					String cpu = tastiera.nextLine();
					System.out.println("Inserisci la RAM da ricercare: ");
					int ram = Integer.parseInt(tastiera.nextLine());
					System.out.println("Inserisci il prezzo massimo: ");
					double prez = Double.parseDouble(tastiera.nextLine());
					risposta = shopC.ricerca(cpu, ram, prez) + " nel nostro negozio posseggono la CPU indicata\n";
				break;	
				case 12:
					risposta = "Il costo totale di tutti i prodotti del mio negozio è: " + shopA.totaleprezzi() + " €\n";
				break;
				case 13:
					risposta = "Il costo totale di tutti i pc del mio negozio è: " + shopA.totalePrezziPc() + " €\n";
				break;
				case 14:
					risposta = "Il media di tutti i prodotti del mio negozio è: " + shopA.media() + " €\n";
				break;	
				case 15:
					risposta = "Il prezzo più basso del negozio è: " + shopA.minimo() + " €\n";
				break;
				case 16:
					risposta = "Il prezzo più alto del negozio è: " + shopA.massimo() + " €\n";
				break;
				case 17:
					risposta = "Il guadagno del negozio è: " + shopA.guadagno() + " €\n";
				break;
				case 18:
					risposta = "La somma degli stipendi del negozio è: " + shopA.stipendi() + " €\n";
				break;
				case 19:
					risposta = "Lo stipendio minimo è: " + shopA.stipendiominino() + " €\n";
				break;
				case 20:
					risposta = "Lo stipendio massimo è: " + shopA.stipoendiomassimo() + " €\n";
				break;
				case 21:
					risposta = "Il numero dei dipendenti del negozio è: " + shopA.ndipendenti() + "\n";
				break;
				case 22:
					risposta = "Il numero dei capireparto è: " + shopA.nCapireparti() + "\n";
				break;
				case 23:
					System.out.println("Inserisci ID da ricercare: ");
					risposta = shopA.ricercadip(Integer.parseInt(tastiera.nextLine())) + "\n";
				break;
				case 24:
					System.out.println("Inserisci Ruolo da ricercare: ");
					risposta = shopA.ricercadip(tastiera.nextLine()) + "\n";
				break;
				case 25:
					System.out.println("Inserisci ruolo da ricercare: ");
					String ruolo = tastiera.nextLine();
					System.out.println("Inserisci stipendio max da ricercare: ");
					double sMax = Double.parseDouble(tastiera.nextLine());
					risposta = shopA.ricercadip(ruolo, sMax) + "\n";
				break;
				case 26:
					System.out.println("Inserisci ID personale da ricercare: ");
					risposta = shopA.stampaProdottiDip(Integer.parseInt(tastiera.nextLine())) + "\n";
				break;
				case 27:
					System.out.println("Inserisci ID prodotto da ricercare: ");
					risposta = shopA.stampaGestoreProd(Integer.parseInt(tastiera.nextLine())) + "\n";
				break;
				default:
					risposta = "Hai inserito un comando non valido BALUBA!!!";
				break;
			}
			System.out.println(risposta);
		} while (comando != 0);
		
		tastiera.close();

	}

}
