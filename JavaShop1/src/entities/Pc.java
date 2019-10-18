package entities;

public class Pc {
	

	public String modello, cpu, tipomma, tiporam;
	public int mma, ram;
	
	public static String CPUValide = "i3,i5,i7,i9";
	public static String RAMValide = "ddr3,ddr4,ddr5";
	public static String MMAValide = "ssd,hdd";
	public static int RAMMin = 2;
	public static int RAMMax = 64;
	public static int MMAMin = 32;
	public static int MMAMax = 16000;
	
	public Pc() {
		
	}
	
	public Pc(String modello, String cpu, String tipomma, int mma, String tiporam, int ram) {
		this.modello = modello;
		this.cpu = cpu;
		this.tipomma = tipomma;
		this.mma = mma;
		this.tiporam = tiporam;
		this.ram = ram;
	}
	
	public static boolean isValido(String[] riga) {
		return 	isCpu(riga[2]) 				&&
				isMMA(riga[3], (riga[4])) 	&&
				isRAM(riga[5], (riga[6]));
	}
	
	public static boolean isCpu(String modello) {		//Non ancora perfetto.. ",i5" considerato come valore valido
		return CPUValide.indexOf(modello.toLowerCase()) >= 0;
	}
	
	public static boolean isMMA(String modello, String val) {
		int mma = Integer.parseInt(val);
		return 	MMAValide.indexOf(modello.toLowerCase()) >= 0  
				&& (mma >= MMAMin && mma <= MMAMax);
	}
	
	public static boolean isRAM(String modello, String val) {
		int ram = Integer.parseInt(val);
		return 	RAMValide.indexOf(modello.toLowerCase()) >= 0 
				&& ram >= RAMMin && ram <= RAMMax;
	}
	
	/**
	 * @return
	 * � la somma di tutti i costi parziali
	 */
	public double costo() {
		return (costocpu()>0 && costoram()>0 && costomma()>0) ?  costocpu() + costoram() + costomma() : -1;
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
		return 	"Modello: "					+ modello 		+	
				"\nCPU: "					+ cpu			+
				"\nRAM: "					+ ram			+
				" GB di tipo: "				+ tiporam 		+
				"\nMMA: "					+ mma			+
				" GB di tipo: "				+ tipomma 		+
				"\nCosto finale: "			+ costo() 		+
				(isGaming() ? "\nE' un computer da Gaming SUPER HIGHT-TECH MEGA WOW!!!" : isOffice() ? "\nE' un buon computer da ufficio!" : "\nNon � un computer con cui si pu� giocare o lavorare.. Regalalo a tua zia!");
	}
	
	

}
