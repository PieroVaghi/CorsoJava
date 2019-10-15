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
		dati.close();											// sono arrivato in fondo al file per contarlo e per ricominciare devo chiuderlo e 
		dati = new Scanner(new File(percorso));					// riaprirlo
		
		double media = 0;
		String risposta = "";
		
		// Dichiaro Vettore
//		System.out.println("Quanti numeri vuoi inserire?"); 	//METODO CON PRIMO VALORE DEL FILE == LUNGHEZZA VETTORE
//		int num = Integer.parseInt(dati.nextLine());
		int[] numeri = new int[n];
		
		// Carico Vettore da file
		for(int i = 0; i < numeri.length; i++) {
			numeri[i] = Integer.parseInt(dati.nextLine());
		}
		dati.close();
		
		// Stampo su schermo i valori del vettore
		for(int i = 0; i < numeri.length; i++){
			risposta += numeri[i] + "; ";
		}
		
		// Calcolo la media dei valori inseriti
		for(int i = 0; i < numeri.length; i++){
			media += numeri[i];
		}
		media /= numeri.length;
		risposta += "\nLa media è: " + media; 
		
		// Trovo il valore max all'interno del vettore
		// NO FUNZIONA CON NUMERI NEGATIVI!
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < numeri.length; i++){
			if(max < numeri[i])
				max = numeri[i];
		}
		risposta += "\nIl valore massimo è: " + max; 
		
		// Trovo il valore min all'interno del vettore
		int min = max;		// op. Integer.MAX_VALUE
		for(int i = 0; i < numeri.length; i++){
			if(min > numeri[i])
				min = numeri[i];
		}
		risposta += "\nIl valore minimo è: " + min; 
		
		// OUTPUT
		System.out.println(risposta);
		

	}

}
