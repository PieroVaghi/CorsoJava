package test;

import java.util.Scanner;

public class Iterazione {

	public static void main(String[] args) {
		// età media studenti generation
		// Interrogo ciascun utente
		// NON CONOSCO IL NUMERO
		
		Scanner tastiera = new Scanner(System.in);
		int count = 0;
		double media = 0;
		System.out.println("Ci sono studenti di Generation?");
		String continua = tastiera.nextLine();
		
		while(continua.equalsIgnoreCase("si"))
		{
			System.out.println("Quanti ani hai?");
			int eta = Integer.parseInt(tastiera.nextLine());
			media += eta;
			System.out.println("valore parziale di media " + media );
			count++; // count = count + 1; count +=1;
			System.out.println("persona numero " + count);
			System.out.println("Ci sono altri studenti di Generation?");
			continua = tastiera.nextLine();
		}

		System.out.println("totale età: " + media);
		System.out.println("totale persone: " + count);
		
		if(count!=0)
			media/=count;
		
		System.out.println(media);
		tastiera.close();
	}

}
