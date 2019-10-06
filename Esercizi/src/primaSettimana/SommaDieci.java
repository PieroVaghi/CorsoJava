package primaSettimana;

import java.util.Scanner;

public class SommaDieci {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int somma = 0, count = 0, limite = 10;
		String risposta;
		while (count!=limite) {
			count ++;
			System.out.println("Inserisci numero: ");
			somma += Integer.parseInt(tastiera.nextLine());
		}
		risposta = "La somma dei numeri inseriti è pari a: " + somma;
		System.out.println(risposta);
		tastiera.close();
	}

}
