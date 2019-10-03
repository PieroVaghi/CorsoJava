package test;

import java.util.Scanner;

public class Scomputeriamo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		double prezzo = 0;
		String risposta = "+---------------------------------------+\n|\tScheda Tecnica:\t\t\t|\n|\tCPU = ";
		
		System.out.println("Seleziona modello di CPU: i3, i5, i7");
		String cpu = tastiera.nextLine();
				
		switch (cpu.toLowerCase()) {
			case "i3":
				prezzo += 30;
			break;
			case "i5":
				prezzo += 80;
			break;
			case "i7":
				prezzo += 150;
			break;
			default:
				System.out.println("Mi dispiace ma non risulta inserita una CPU valida!");
			break;
		}
		
		System.out.println("Seleziona modello di RAM: DDR3, DDR4, DDR5");
		String ram = tastiera.nextLine();
				
		switch (ram.toUpperCase()) {
			case "DDR3":
				prezzo += 1*gbRam;
			break;
			case "DDR4":
				prezzo += 3*gbRam;
			break;
			case "DDR5":
				prezzo += 5*gbRam;
			break;
			default:
				System.out.println("Mi dispiace ma non risulta inserita una RAM valida!");
			break;
		}
		
		System.out.println("Indica quanti GB di RAM hai bisogno:");
		int gbRam = Integer.parseInt(tastiera.nextLine());
		
		if(gbRam>64)
			System.out.println("Mi dispiace ma non possediamo abbastanza RAM in ufficio");
		
		if(gbRam>=16 && (cpu.equalsIgnoreCase("i5")||cpu.equalsIgnoreCase("i7")))
			prezzo += 150;
		
		risposta = risposta + cpu +
					"\t\t\t|\n|\tRAM = " + ram.toUpperCase() + " da " + gbRam + "GB" +
					"\t\t|\n|\tPrezzo Finale = " + prezzo + " €\t\t|\n+---------------------------------------+";
		
		System.out.println(risposta);
		
		tastiera.close();

	}

}
