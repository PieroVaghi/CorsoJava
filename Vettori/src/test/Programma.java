package test;

import java.util.Scanner;

public class Programma 
{

	public static void main(String[] args) 
	{
		Scanner tastiera = new Scanner(System.in);
		int[] numeri = new int[5];
		int contatore = 0;
		double media = 0;
		int max = 0;
		String risposta = "";
		
		while(contatore < numeri.length)
		{
			numeri[contatore] = Integer.parseInt(tastiera.nextLine());
			contatore++;
		}
		
		contatore = 0;
		while(contatore < numeri.length)
		{
			risposta += numeri[contatore] + "\t";
			contatore++;
		}
		
		contatore = 0;
		while(contatore < numeri.length)
		{
			media += numeri[contatore];
			contatore++;
		}
		media /= numeri.length;
		risposta += "\nLa media è: " + media; 
		
		contatore = 0;
		while(contatore < numeri.length)
		{
			if(max < numeri[contatore])
				max = numeri[contatore];
			contatore++;
		}
		risposta += "\nIl valore massimo è: " + max; 
		
		System.out.println(risposta);
		

		tastiera.close();
	}

}
