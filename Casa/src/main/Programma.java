package main;

import entities.Stanza;

public class Programma {

	public static void main(String[] args) {

//		Qui dentro solo inserimento input
		Stanza s1 = new Stanza();

		s1.altezza = 6.0;
		s1.base = 5.0;
		s1.tipo = "Cucina";

//		la "chiamata a funzioni"
//		la stampa dell'output
		System.out.println(s1.descrizione());
		
	}

}
