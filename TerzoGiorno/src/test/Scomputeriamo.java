package test;

import java.util.Scanner;

public class Scomputeriamo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		double prezzo = 0;
		String cornice = "+---------------------------------------+";
		String risposta = cornice + "\n|\tScheda Tecnica:\t\t\t|\n|\tCPU = ";
		int vali3 = 30, vali5 = 80, vali7 = 150;
		int ddr3 = 1, ddr4 = 3, ddr5 = 5;
		int valoreGaming = 150;
		
		
		System.out.println("Seleziona modello di CPU: i3, i5, i7");
		String cpu = tastiera.nextLine().toLowerCase();
		System.out.println("Seleziona modello di RAM: DDR3, DDR4, DDR5");
		String ram = tastiera.nextLine().toUpperCase();
		System.out.println("Indica quanti GB di RAM hai bisogno:");
		int gbRam = Integer.parseInt(tastiera.nextLine());
		boolean isGaming = gbRam>=16 && (cpu.equals("i5")||cpu.equals("i7"));
		boolean schedaValida = true;
				
		switch (cpu) {
			case "i3":
				prezzo += vali3;
				break;
			case "i5":
				prezzo += vali5;
				break;
			case "i7":
				prezzo += vali7;
				break;
			default:
				schedaValida = false;
				System.out.println("ATTENZIONE! non risulta inserita una CPU valida!");
				break;
		}
		
		switch (ram) {
			case "DDR3":
				prezzo += ddr3*gbRam;
			break;
			case "DDR4":
				prezzo += ddr4*gbRam;
			break;
			case "DDR5":
				prezzo += ddr5*gbRam;
			break;
			default:
				prezzo = 0;
				schedaValida = false;
				System.out.println("ATTENZIONE! non risulta inserita una RAM valida!");
			break;
		}
		
		if(gbRam>64) {
			schedaValida = false;
			System.out.println("Mi dispiace ma non possediamo abbastanza RAM in ufficio");
		}
		
		if(isGaming)
			prezzo += valoreGaming;
		
		if(schedaValida) {
			risposta += cpu +
						"\t\t\t|\n|\tRAM = " + ram + " da " + gbRam + "GB" +
						"\t\t|\n|\tPrezzo Finale = " + prezzo + " €\t\t|\n" + cornice;
			System.out.println(risposta);
		} else 
			System.out.println("\nNon sono state inserite specifiche corrette");
		
		tastiera.close();

	}

}
