package main;

import java.util.Scanner;

import entities.VigileDelFuoco;

public class Main {

	public static void main(String[] args) {

		Scanner tastiera = new Scanner(System.in);
		VigileDelFuoco v1 = new VigileDelFuoco();
		String risposta = "";
		
		
		
		v1.volontario = true;
		v1.nome = "Piero";
		v1.cognome = "Vaghi";
		v1.dataNascita = "01/12/1994";
		v1.grado = "Vigile";
		v1.id = 15591;
		v1.annoDec = 2018;
		v1.patente = "Primo Grado";
		v1.qualificazioni = "TPSS, NBCR 0";
		v1.comando = "Milano";
		v1.distaccamento = "Lazzate";
		
		risposta += v1.schedaPersonale() + 
					"\nIn servizio da: " + v1.anniDecreto() + " anno/i";
				
		System.out.println(risposta);
		
		tastiera.close();
		
		}

}
