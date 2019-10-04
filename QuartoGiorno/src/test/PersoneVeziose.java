package test;

import java.util.Scanner;

public class PersoneVeziose {

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
		int personeF = 0;
		int personeM = 0;
		int personeEta = 0;
		int guadagno = 0;
		String risposta = "";
		
		System.out.println("C'è qualcuno a Vezio?");
		String continua = tastiera.nextLine();
		
		while(continua.equalsIgnoreCase("si")) {
			int biglietto = 10;
			System.out.println("Sei maschio(M) o femmina(F)?");
			String genere =tastiera.nextLine();
			if(genere.equalsIgnoreCase("M"))
				personeM ++;
			else if (genere.equalsIgnoreCase("F"))
				personeF ++;
			System.out.println("Quanti anni hai?");
			int eta = Integer.parseInt(tastiera.nextLine());
			if( eta<5 || eta>70 ) {
				personeEta ++;
				biglietto -= 5;
			}
			guadagno += biglietto;
			System.out.println("Per lei l'ingresso al castello costa: " + biglietto + " €");	
			System.out.println("Fin'ora hai contato Nr. " + (personeM + personeF) + " persone a Vezio, C'è qualcun'altro?");
			continua = tastiera.nextLine();
		}
		
		risposta =	"+---------------------------------------------------------------------------------------+\n"+
					"Persone totali a Vezio: " + (personeM + personeF) + "\n" +
					"Di cui donne: "	+ personeF + "\n" +
					"Mentre uomini: " 	+ personeM + "\n" +
					"Tra questi, le persone con più di 70 anni o meno di 5 sono: " + personeEta + "\n" +
					"Oggi l'ente del castello di Vezio ha guadagnato " + guadagno + " € tramite i biglietti!";
		
		
		System.out.println(risposta);
		
		tastiera.close();
 	
		
	}

}
