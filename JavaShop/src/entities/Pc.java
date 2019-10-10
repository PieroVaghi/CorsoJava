package entities;

public class Pc {

	public int id;
	public String marca;
	public String modello;
	public String cpu;
	public String tiporam;
	public String tipomma;
	public int ram;
	public int mma;
	
	/**
	 * @return
	 * � la somma di tutti i costi parziali, se la marca � Ananas il costo raddoppia
	 */
	public double costo() {
		double costo = (costocpu()>0 && costoram()>0 && costomma()>0) ?  costocpu() + costoram() + costomma() : -1;
		return costo;
	}
	
	/**
	 * @return
	 * il costo dell�i3 � 30, i5 190, i7 300, i9 500
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
	 * il costo della DDR3 � 5 per il numero di GB di ram
	 * il costo della DDR4 � 20 per il numero di GB di ram
	 * il costo della DDR5 � 60 per il numero di GB di ram
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
	 * il costo dell�HDD � 0.1 per il numero di GB di mma
	 * il costo dell�SSD � 1 per il numero di GB di mma
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
	 * la cpu � i5, i7 o i9, il tiporam � DDR4 o DDR5, la ram � almeno 8 GB, e la mma � almeno 128 GB
	 */
	public boolean isGaming() {
		return ((cpu.equalsIgnoreCase("i5")||cpu.equalsIgnoreCase("i7")||cpu.equalsIgnoreCase("i9")) && (tiporam.equalsIgnoreCase("ddr4")||tiporam.equalsIgnoreCase("ddr5")) && ram >= 8 && mma >= 128);
	}
	
	/**
	 * @return
	 * la mma � di almeno 512 GB e non � da gaming
	 */
	public boolean isOffice() {
		return mma >= 512 && !isGaming();
	}
	
	/**
	 * @return
	 * voglio vedere tutte le caratteristiche definite dalle propriet�
	 * sapere il costo finale
	 * e se � da ufficio o per giocare o nessuno dei due
	 */
	public String toString() {
		return 	"ID: " 						+ id 			+
				"\nModello: "				+ modello 		+	
				"\nMarca: "					+ marca 		+
				"\nCPU: "					+ cpu			+
				"\nRAM: "					+ ram			+
				" GB di tipo: "				+ tiporam 		+
				"\nMMA: "					+ mma			+
				" GB di tipo: "				+ tipomma 		+
				"\nCosto finale: "			+ costo() 		+
				(isGaming() ? "\nE' un computer da Gaming super Hig-Tech Mega WOW!!!" : isOffice() ? "\nE' un buon computer da ufficio!" : "\nNon � un computer con cui si pu� giocare o lavorare.. Regalalo a tua zia!");
	}
	
}
