package main;

import java.io.File;
import java.util.Scanner;

import aggregatore.INegozio;
import aggregatore.Negozio;

public class TestJavaShop1 {

	public static void main(String[] args) throws Exception{
		
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Scegli il negozio che ti interessa tra javaronics o javaworld");
		String percorso = "src/res/" + tastiera.nextLine()+"/dati.txt";
		
		INegozio shop = new Negozio(percorso);
		
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
					risposta = "Il numero di prodotti del negozio è: " + shop.nprodotti() + "\n";
				break;
				case 2:
					risposta = "Il numero totale di Pc presenti in negozio è: " + shop.npc() + "\n";
				break;
				case 3:
					risposta = "Il numero totale dei Laptop presenti in negozio è: " + shop.nlaptop() + "\n";
				break;
				case 4:
					risposta = "Il numero totale degli Smarphone presenti in negozio è: " + shop.nsmartphone() + "\n";
				break;
				case 5:
					risposta = "Il numero totale delle lavatrici presenti in negozio è: " + shop.nlavatrici() + "\n";
				break;
				case 6:
					System.out.println("Inserisci la CPU da ricercare: ");
					risposta = shop.nprodottipercpu(tastiera.nextLine()) + " prodotti del nostro negozio posseggono la CPU indicata\n";
				break;
				case 7:
					risposta = "Il costo totale di tutti i prodotti del mio negozio è: " + shop.totaleprezzi() + " €\n";
				break;
				case 8:
					risposta = "Il media di tutti i prodotti del mio negozio è: " + shop.media() + " €\n";
				break;	
				case 9:
					risposta = "Il prezzo più basso del negozio è: " + shop.minimo() + " €\n";
				break;
				case 10:
					risposta = "Il prezzo più alto del negozio è: " + shop.massimo() + " €\n";
				break;
				case 11:
					risposta = "Ecco i computer più economici:\n" + shop.schedepiueconomici() + "\n";
				break;
				case 12:
					risposta = "Ecco i computer più costosi:\n" + shop.schedepiucostosi() + "\n";
				break;
				case 13:
					risposta = "Ecco i computer da Gaming:\n" + shop.schedegaming() + "\n";
				break;
				case 14:
					risposta = "Ecco i computer da ufficio:\n" + shop.schedeoffice() + "\n";
				break;
				case 15:
					System.out.println("Inserisci l'ID da ricercare: ");
					int id = Integer.parseInt(tastiera.nextLine());
					risposta = shop.ricerca(id) + "\n";
				break;
				case 16:
					System.out.println("Inserisci una CPU tetto: ");
					String cpu = tastiera.nextLine();
					risposta = shop.ricerca(cpu) + "\n";
				break;
				case 17:
					System.out.println("Inserisci un tetto di prezzo: ");
					double prezzo = Double.parseDouble(tastiera.nextLine());
					risposta = shop.ricerca(prezzo) + "\n";
				break;
				case 18:
					risposta = "Ecco tutti i computer:\n" + shop.schede() + "\n";
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
