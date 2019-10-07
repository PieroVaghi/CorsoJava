package Esercizi;

import java.util.Scanner;

public class EserciziDrive4 {

	public static void main(String[] args) {
		// scrivere un programma che riceve in ingresso i dati di un rettangolo (base e altezza) e ne stampa perimetro e area
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci base del rettangolo");
		int base = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci altezza del rettangolo");
		int altezza = Integer.parseInt(tastiera.nextLine());
		
		String risposta =	"L'area del rettangolo è: " + (base * altezza) + "\n" +
							"Il perimetro del rettangolo è: " + ((base + altezza) * 2);
		
		System.out.println(risposta);
		tastiera.close();		

	}

}
