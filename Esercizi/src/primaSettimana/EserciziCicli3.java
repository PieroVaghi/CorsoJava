package primaSettimana;

import java.util.Scanner;

public class EserciziCicli3 {

	public static void main(String[] args) {
		// Come in EserciziCicli2 ma vengono calcolate due somme, quella dei positivi e quella dei negativi
		
		Scanner tastiera = new Scanner(System.in);
		int sommaP = 0;
		int sommaN = 0;
		int num = 1;
		String risposta = "";
		
		while(num != 0) {
			System.out.println("Inserisci numero (0 per terminare): ");
			num = Integer.parseInt(tastiera.nextLine());
			if (num > 0)
				sommaP += num;
			else 
				sommaN += num;
		}
		risposta += "La somma dei numeri positivi inseriti è: " + sommaP + "\n" +
					"La somma dei numeri negativi inseriti è: " + sommaN;
		System.out.println(risposta);
		tastiera.close();

	}

}
