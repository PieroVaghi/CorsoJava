package test;

import java.io.File;
import java.util.Scanner;

public class Programma 
{

	public static void main(String[] args) throws Exception
	{
		String percorso = "src/res/dati.txt";
		Scanner dati = new Scanner(new File(percorso));
		
		int n = 0;
		while(dati.hasNextLine()) {								// .hasNextLine() controlla solo se c'è un'altra riga, non va a capo nel file! CICLO INFINITO!!!
			n++;												//
			dati.nextLine();									// mettiamo dati.nextLine per mandare a capo DOPO l'incremento di n!
		}
		dati.close();
		dati = new Scanner(new File(percorso));
		
		int i = 0;
		double media = 0;
		String risposta = "";
		
		// Dichiaro Vettore
//		System.out.println("Quanti numeri vuoi inserire?"); 	//METODO CON PRIMO VALORE DEL FILE == LUNGHEZZA VETTORE
//		int num = Integer.parseInt(dati.nextLine());
		int[] numeri = new int[n];
		
		// Carico Vettore da tastiera
		while(i < numeri.length)
		{
			numeri[i] = Integer.parseInt(dati.nextLine());
			i++;
		}
		dati.close();
		
		// Stampo su schermo i valori del vettore
		i = 0;
		while(i < numeri.length)
		{
			risposta += numeri[i] + "; ";
			i++;
		}
		
		// Calcolo la media dei valori inseriti
		i = 0;
		while(i < numeri.length)
		{
			media += numeri[i];
			i++;
		}
		media /= numeri.length;
		risposta += "\nLa media è: " + media; 
		
		// Trovo il valore max all'interno del vettore
		// NO FUNZIONA CON NUMERI NEGATIVI!
		i = 0;
		int max = Integer.MIN_VALUE;
		while(i < numeri.length)
		{
			if(max < numeri[i])
				max = numeri[i];
			i++;
		}
		risposta += "\nIl valore massimo è: " + max; 
		
		// Trovo il valore min all'interno del vettore
		i = 0;
		int min = max;		// op. Integer.MAX_VALUE
		while(i < numeri.length)
		{
			if(min > numeri[i])
				min = numeri[i];
			i++;
		}
		risposta += "\nIl valore minimo è: " + min; 
		
		// OUTPUT
		System.out.println(risposta);
		

	}

}
