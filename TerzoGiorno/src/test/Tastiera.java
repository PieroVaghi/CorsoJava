package test;
import java.util.Scanner;

public class Tastiera {

	public static void main(String[] args) 
	{
		// Voglio stampare un biglietto del cinema a seconda delle promozioni
		// per un qualsiasi utente uin arrivo
		
		Scanner tastiera = new Scanner(System.in); 
		
		System.out.println("Inserisci il giorno attuale: LUN, MAR, MER, GIO, VEN, SAB, DOM");
		String giorno = tastiera.nextLine();
		System.out.println("Ciao! Come ti chiami?");
		String nome = tastiera.nextLine();
		System.out.println("Quanti anni hai?");
		String valoreEta = tastiera.nextLine();
		int eta = Integer.parseInt(valoreEta);
		System.out.println("Di che genere sei? M/F");
		String genere = tastiera.nextLine().toUpperCase();
		boolean isM = genere.equals("M");
		System.out.println("Tifoso? S/N");
		boolean isTifoso = tastiera.nextLine().equalsIgnoreCase("S");
		boolean isLun = giorno.equalsIgnoreCase("LUN");
		boolean isMar = giorno.equalsIgnoreCase("MAR");
		boolean isDom = giorno.equalsIgnoreCase("DOM");
		
		double prezzo = 9.50;
		double sconto1 = 5;
		double sconto2 = 6.60;
		
		if((isLun && isM)||(isMar && isTifoso))
			prezzo -= sconto1;
		
		if(isDom)
			prezzo -= sconto2;
		
		
		String risposta = "Ciao " + nome + "! Il tuo biglietto costa: " + prezzo + " €";
		
		System.out.println(risposta);
		

	}

}
