package Esercizi;

import java.util.Scanner;

public class EserciziDrive2 {

	public static void main(String[] args) {
		// Riceve in input numNumeri numeri e stampa il più grande
		
		Scanner tastiera = new Scanner(System.in);
		int cont = 0;
		int numNumeri = 10;
		
		System.out.println("Inserisci numero:");
		int max = Integer.parseInt(tastiera.nextLine());
		while (cont != numNumeri - 1) {
			cont ++;
			System.out.println("Inserisci numero:");
			int num = Integer.parseInt(tastiera.nextLine());
			if(num > max)
				max = num;
		}
		
		String risposta = "Max = " + max;
		System.out.println(risposta);

		tastiera.close();
	}

}
