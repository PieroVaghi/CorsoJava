package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shop.INegozio;
import shop.Negozio;

public class TestJavaShop1 {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Scegli il negozio che ti interessa tra javaronics o javaworld");
		String nomeShop = tastiera.nextLine();
		String percorsoProd = "src/res/" + nomeShop+"/datiPc.txt";
		String percorsoDip = "src/res/" + nomeShop+"/datiDip.txt";
		
		System.out.println("Quant'è il budget attuale?");
		double budget = Integer.parseInt(tastiera.nextLine());
		
		System.out.println("Quale tipologia di funzioni devi effettuare? amministrazione o clientela?");
		String ruolo = tastiera.nextLine();
		INegozio shopC = new Negozio(percorsoProd, percorsoDip, budget);
//		IAmministrazione shopC = new Negozio(percorsoProd, percorsoDip, budget);
//		
		
		
		String menu = "";
		Scanner datimenu = null;
		try {
			datimenu = new Scanner(new File("src/res/MenuJavaShop1.txt"));
			while(datimenu.hasNextLine()) 
				menu += datimenu.nextLine() + "\n";
		} 
		catch(FileNotFoundException f) {
			System.out.println(f.getMessage());
		}
		finally {
			try {
				datimenu.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
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
					risposta = "Ecco i prodotti più economici:\n" + shopC.schedepiueconomici() + "\n";
					break;
				case 8:
					risposta = "Ecco i prodotti più costosi:\n" + shopC.schedepiucostosi() + "\n";
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
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il costo totale di tutti i prodotti del mio negozio è: " + shopC.totaleprezzi() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 13:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il costo totale di tutti i pc del mio negozio è: " + shopC.totalePrezziPc() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 14:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il media di tutti i prodotti del mio negozio è: " + shopC.media() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;	
				case 15:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il prezzo più basso del negozio è: " + shopC.minimo() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 16:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il prezzo più alto del negozio è: " + shopC.massimo() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 17:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il guadagno del negozio è: " + shopC.guadagno() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 18:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "La somma degli stipendi del negozio è: " + shopC.stipendi() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 19:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Lo stipendio minimo è: " + shopC.stipendiominino() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 20:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Lo stipendio massimo è: " + shopC.stipoendiomassimo() + " €\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 21:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il numero dei dipendenti del negozio è: " + shopC.ndipendenti() + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 22:
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? "Il numero dei capireparto è: " + shopC.nCapireparti() + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 23:
					System.out.println("Inserisci ID da ricercare: ");
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? shopC.ricercadip(Integer.parseInt(tastiera.nextLine())) + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 24:
					System.out.println("Inserisci Ruolo da ricercare: ");
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? shopC.ricercadip(tastiera.nextLine()) + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 25:
					System.out.println("Inserisci ruolo da ricercare: ");
					String ruolop = tastiera.nextLine();
					System.out.println("Inserisci stipendio max da ricercare: ");
					double sMax = Double.parseDouble(tastiera.nextLine());
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? shopC.ricercadip(ruolop, sMax) + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 26:
					System.out.println("Inserisci ID personale da ricercare: ");
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? shopC.stampaProdottiDip(Integer.parseInt(tastiera.nextLine())) + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
				break;
				case 27:
					System.out.println("Inserisci ID prodotto da ricercare: ");
					risposta = (ruolo.equalsIgnoreCase("amministrazione")) ? shopC.stampaGestoreProd(Integer.parseInt(tastiera.nextLine())) + "\n" : "Non possiedi i privilegi per visualizzare questi risultati";
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
