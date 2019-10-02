package test;

public class Rettangolo {

	public static void main(String[] args) {
		//Problema calcolare perimetro e area di un rettangolo
		
		//D.I.C.O.
		//D.ICHIARAZIONE
			//Variabili INPUT
		int base;
		int altezza;
			//Variabili CALCOLO
		int area;
		int perimetro;
			//VARIABILE RISPOSTA
		String risposta;
		
		//I.NPUT
		base = 10;
		altezza = 5;
		
		//C.ALCOLO
		area = base * altezza;
		perimetro = (base + altezza) * 2;
		risposta = "Dato un rettangolo di base -> " + base + " e altezza -> " + altezza + " otteniamo:\n"+
					"Area \t\t->\t"+ area + "\n" +
					"Perimetro \t->\t" + perimetro;
				
		//O.UTPUT
		System.out.println(risposta);

	}

}
