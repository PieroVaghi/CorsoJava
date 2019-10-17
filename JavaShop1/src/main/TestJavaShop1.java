package main;

import java.io.File;
import java.util.Scanner;

import aggregatore.Negozio;

public class TestJavaShop1 {

	public static void main(String[] args) throws Exception{
		
		Negozio shop = new Negozio();
		
		Scanner datimenu = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\JavaShop1\\src\\res\\MenuJavaShop1.txt"));
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
			switch (comando) {
				case 0:
					risposta = "Ciao Bello!";
				break;
				case 1:
					risposta = "Il guadagno del negozio è: " + shop.guadagno() + "\n";
				break;
				case 2:
					risposta = "Il costo totale di tutti i laptop è: " + shop.totalecostilaptop() + "\n";
				break;
				case 3:
					risposta = "Il costo totale di tutti i pc è: " + shop.totalecostipc() + "\n";
				break;
				case 4:
					risposta = "Il pc più costoso del negozio costa: " + shop.costomaxp() + "\n";
				break;
				case 5:
					risposta = "Il pc più economico del negozio costa: " + shop.costominp() + "\n";
				break;
				case 6:
					System.out.println("Inserisci una CPU da ricercare:");
					String cpu = tastiera.nextLine();
					risposta = shop.elencopcpercpu(cpu);
					risposta += risposta.isEmpty() ? "hai inserito un modello di CPU che non trattiamo o che non è momentaneamente disponibile in negozio\n" : "\n";
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
