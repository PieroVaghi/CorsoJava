package primaSettimana;

import java.util.Scanner;

public class EserciziCicli4 {

	public static void main(String[] args) {
		// Come in EserciziCicli1 ma calcola la media dei numeri inseriti
		
		Scanner tastiera = new Scanner(System.in);
		double media = 0;
		int num = 1;
		int cont = 0;
		
		String risposta = "";
		
		while(num != 0) {
			System.out.println("Inserisci numero (0 per terminare): ");
			num = Integer.parseInt(tastiera.nextLine());
			cont ++;
			media += num;
		}
		
		risposta += "La media dei numeri inseriti è: " + (media / (cont - 1));
		System.out.println(risposta);
		tastiera.close();

	}

}