package entities;

public class Laptop {
	
	public String modello, cpu, tipomma, tiporam;
	public int mma, ram, orebatteria, peso, pollici;
	
	public static boolean isValido(String[] riga) {
		return 	isCpu(riga[2]) 								&&
				isMMA(riga[3], Integer.parseInt(riga[4])) 	&&
				isRAM(riga[5], Integer.parseInt(riga[6]));
	}
	
	public static boolean isCpu(String modello) {
		switch (modello.toLowerCase()) {
			case "i3":
			case "i5":
			case "i7":
			case "i9":
				return true;
			default: 
				return false;			
		}
	}
	
	public static boolean isMMA(String modello, int val) {
		return 	(modello.equalsIgnoreCase("hdd") ||
				modello.equalsIgnoreCase("ssd")) 
				&& (val >= 32 && val <= 16000);
	}
	
	public static boolean isRAM(String modello, int val) {
		return 	(modello.equalsIgnoreCase("ddr3") ||
				modello.equalsIgnoreCase("ddr4") ||
				modello.equalsIgnoreCase("ddr5")) 
				&& (val >= 2 && val <= 128);
	}
	
	/**
	 * @return
	 * è la somma di tutti i costi parziali
	 */
	public double costo() {
		double costo = costocpu() + costoram() + costomma();
		return (peso >= 5000) ? costo * 1.05 : costo;
	}
	
	/**
	 * @return
	 * il costo dell’i3 è 30, i5 190, i7 300, i9 500
	 * return -1 se nin prevista
	 */
	public double costocpu() { 
		switch (cpu.toLowerCase()) {
			case "i3":
				return 30;
			case "i5":
				return 150;
			case "i7":
				return 300;
			case "i9":
				return 500;
			default:
				return -1;
		}	
//		return cpu.equalsIgnoreCase("i3") ? 30 : (cpu.equalsIgnoreCase("i5")) ? 190 : (cpu.equalsIgnoreCase("i7")) ? 300 : 500;
	}
	
	/**
	 * @return
	 * il costo della DDR3 è 5 per il numero di GB di ram
	 * il costo della DDR4 è 20 per il numero di GB di ram
	 * il costo della DDR5 è 60 per il numero di GB di ram
	 * return -1 se non prevista
	 */
	public double costoram() {
		switch (tiporam.toLowerCase()) {
			case "ddr3":
				return 5.0 * ram;
			case "ddr4":
				return 20.0 * ram;
			case "ddr5":
				return 60.0 * ram;
			default:
				return -1;
		}
	}
	
	/**
	 * @return
	 * il costo dell’HDD è 0.1 per il numero di GB di mma
	 * il costo dell’SSD è 1 per il numero di GB di mma
	 * return -1 se non previsto
	 */
	public double costomma() {
		switch (tipomma.toUpperCase()) {
			case "HDD":
				return 0.1 * mma;
			case "SSD":
				return 1.0 * mma;
			default:
				return -1;
		}
	}
	
	/**
	 * @return
	 * la cpu è i5, i7 o i9, il tiporam è DDR4 o DDR5, la ram è almeno 8 GB, e la mma è almeno 128 GB
	 */
	public boolean isGaming() {
		return ((cpu.equalsIgnoreCase("i5")||cpu.equalsIgnoreCase("i7")||cpu.equalsIgnoreCase("i9")) && (tiporam.equalsIgnoreCase("ddr4")||tiporam.equalsIgnoreCase("ddr5")) && ram >= 8 && mma >= 128);
	}
	
	/**
	 * @return
	 * la mma è di almeno 512 GB e non è da gaming
	 */
	public boolean isOffice() {
		return mma >= 512 && !isGaming();
	}
	
	/**
	 * @return
	 * voglio vedere tutte le caratteristiche definite dalle proprietà
	 * sapere il costo finale
	 * e se è da ufficio o per giocare o nessuno dei due
	 */
	public String toString() {
		return 	"Modello: "					+ modello 		+	
				"\nCPU: "					+ cpu			+
				"\nRAM: "					+ ram			+
				" GB di tipo: "				+ tiporam 		+
				"\nMMA: "					+ mma			+
				" GB di tipo: "				+ tipomma 		+
				"\nPeso: "					+ peso			+
				"\nSchermo: "				+ pollici		+
				" pollici"					+
				"\nDurata Batteria: "		+ orebatteria	+
				"\nCosto finale: "			+ costo() 		+
				(isGaming() ? "\nE' un laptop da Gaming SUPER HIGHT-TECH MEGA WOW!!!" : isOffice() ? "\nE' un buon computer da ufficio!" : "\nNon è un computer con cui si può giocare o lavorare.. Regalalo a tua zia!");
	}

}
