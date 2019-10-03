package test;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) 
	{
		//voglio stampare i giorni presenti in ciascun mese
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci il mesi di interesse:");
		String mese = tastiera.nextLine();
		String risposta = "";
		
		if(mese.equalsIgnoreCase("gennaio"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("febbraio"))
			risposta = "28 giorni";
		if(mese.equalsIgnoreCase("marzo"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("aprile"))
			risposta = "30 giorni";
		if(mese.equalsIgnoreCase("maggio"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("giugno"))
			risposta = "30 giorni";
		if(mese.equalsIgnoreCase("luglio"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("agosto"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("settembre"))
			risposta = "30 giorni";
		if(mese.equalsIgnoreCase("ottobre"))
			risposta = "31 giorni";
		if(mese.equalsIgnoreCase("novembre"))
			risposta = "30 giorni";
		if(mese.equalsIgnoreCase("dicembre"))
			risposta = "31 giorni";
	
		System.out.println(risposta);
		
		
	}

}
