package test;

import java.util.Scanner;

public class Programma 
{

	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		int i = 0;
		double media = 0;
		String risposta = "";
		
		// Dichiaro Vettore
		System.out.println("Quanti numeri vuoi inserire?");
		int num = Integer.parseInt(tastiera.nextLine());
		int[] numeri = new int[num];
		
		// Carico Vettore da tastiera
		while(i < numeri.length)
		{
			System.out.println("Inserisci valore:");
			numeri[i] = Integer.parseInt(tastiera.nextLine());
			i++;
		}
		
		// Stampo su schermo i valori del vettore
		i = 0;
		while(i < numeri.length)
		{
			risposta += numeri[i] + "\t";
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
		

		tastiera.close();
	}

}
