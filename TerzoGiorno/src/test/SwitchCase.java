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
		
//		if(mese.equalsIgnoreCase("gennaio"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("febbraio"))
//			risposta = "28/29 giorni";
//		if(mese.equalsIgnoreCase("marzo"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("aprile"))
//			risposta = "30 giorni";
//		if(mese.equalsIgnoreCase("maggio"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("giugno"))
//			risposta = "30 giorni";
//		if(mese.equalsIgnoreCase("luglio"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("agosto"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("settembre"))
//			risposta = "30 giorni";
//		if(mese.equalsIgnoreCase("ottobre"))
//			risposta = "31 giorni";
//		if(mese.equalsIgnoreCase("novembre"))
//			risposta = "30 giorni";
//		if(mese.equalsIgnoreCase("dicembre"))
//			risposta = "31 giorni";

		switch(mese.toLowerCase())		//Stabilisco a priori una convenzione in modo da permettere la sicura uguaglianza con uno dei casi
		{
			case"gennaio":
				risposta = "31 giorni";
			break;
			case"febbraio":
				risposta = "28/29 giorni";
			break;
			case"marzo":
				risposta = "31 giorni";
			break;
			case"aprile":
				risposta = "30 giorni";
			break;
			case"maggio":
				risposta = "31 giorni";
			break;
			case"giugno":
				risposta = "30 giorni";
			break;
			case"luglio":
				risposta = "31 giorni";
			break;
			case"agosto":
				risposta = "31 giorni";
			break;
			case"settembre":
				risposta = "30 giorni";
			break;
			case"ottobre":
				risposta = "31 giorni";
			break;
			case"novembre":
				risposta = "30 giorni";
			break;
			case"dicembre":
				risposta = "31 giorni";
			break;
			default:					//Mi prevengo dagli errori!
				risposta = "Ma scrivi giusto!!!";
			break;
		}
		
		
		System.out.println(risposta);
		
		tastiera.close();
	}

}
