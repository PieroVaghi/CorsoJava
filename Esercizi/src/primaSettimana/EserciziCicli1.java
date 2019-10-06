package primaSettimana;

import java.util.Scanner;

public class EserciziCicli1 {

	public static void main(String[] args) {
		// L'utente continua a inserire numeri fino a quando non inserisce "0". Una volta inserito 0, il programma termina e viene stampata la somma dei numeri
		
		Scanner tastiera = new Scanner(System.in);
		int somma = 0;
		int num = 1;
		String risposta = "";
		
		while(num != 0) {
			System.out.println("Inserisci numero (0 per terminare): ");
			num = Integer.parseInt(tastiera.nextLine());
			somma += num;
		}
		risposta += "La somma dei numeri inseriti è: " + somma;
		System.out.println(risposta);
		tastiera.close();

	}

}
