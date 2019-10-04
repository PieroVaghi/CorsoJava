package test;

import java.util.Scanner;

public class Scomputeriamo {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		double prezzo = 0;
		String cornice = "+---------------------------------------+";
		String risposta = "";
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
				risposta += ("ATTENZIONE! non risulta inserita una CPU valida!\n");
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
				risposta += ("ATTENZIONE! non risulta inserita una RAM valida!\n");
			break;
		}
		
		if(gbRam>64 || gbRam<1 && gbRam%2==0) {
			risposta += ("Mi dispiace ma non possediamo abbastanza RAM in ufficio\n");
		}
		
		if(isGaming)
			prezzo += valoreGaming;
		
		if(risposta.isEmpty()) 
			risposta += cornice + "\n|\tScheda Tecnica:\t\t\t|\n|\tCPU = " + cpu +
						"\t\t\t|\n|\tRAM = " + ram + " da " + gbRam + "GB" +
						"\t\t|\n|\tPrezzo Finale = " + prezzo + " €\t\t|\n" + cornice;
		
		System.out.println(risposta);
		tastiera.close();

	}

}
