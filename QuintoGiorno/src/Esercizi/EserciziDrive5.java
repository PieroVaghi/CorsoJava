package Esercizi;

import java.util.Scanner;

public class EserciziDrive5 {

	public static void main(String[] args) {
		/*
		 * scrivere un programma che inserisce i dati di un rettangolo (base e altezza) e di un quadrato.
		 *  Stampare perimetro e area di rettangolo e quadrato, e stampare quale dei due è il più grande
		 */
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci base del rettangolo");
		int baseR = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci altezza del rettangolo");
		int altezzaR = Integer.parseInt(tastiera.nextLine());
		System.out.println("Inserisci lato del quadrato");
		int latoQ = Integer.parseInt(tastiera.nextLine());

		String grande = "";
		int areaQ = latoQ * latoQ, areaR = baseR * altezzaR;
		
		if (areaR > areaQ)
			grande += "Rettangolo";
		else
			grande += "Quadrato";
		
		
		String risposta =	"L'area del rettangolo è: " + areaR + "\n" +
							"Il perimetro del rettangolo è: " + ((baseR + altezzaR) * 2) + "\n" +
							"L'area del quadrato è: " + areaQ + "\n" +
							"Il perimetro del quadrato è: " + (latoQ * 4) + "\n" +
							"Il più grande dei due è il " + grande;
		
		
		System.out.println(risposta);
		tastiera.close();

	}

}
