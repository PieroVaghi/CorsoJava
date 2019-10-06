package primaSettimana;

import java.util.Scanner;

public class EserciziCicli2 {

	public static void main(String[] args) {
		// Come EserciziCicli1, ma vengono sommati solo numeri positivi non negativi
		
		Scanner tastiera = new Scanner(System.in);
		int somma = 0;
		int num = 1;
		String risposta = "";
		
		while(num != 0) {
			System.out.println("Inserisci numero (0 per terminare): ");
			num = Integer.parseInt(tastiera.nextLine());
			if (num > 0)
				somma += num;
		}
		risposta += "La somma dei numeri positivi inseriti è: " + somma;
		System.out.println(risposta);
		tastiera.close();

	}

}