package entities;

public class Pc extends Prodotto {
	

	private String cpu, tipomma, tiporam;
	private int mma, ram;
	
	static String CPUValide = "i3,i5,i7,i9";
	static String RAMValide = "ddr3,ddr4,ddr5";
	static String MMAValide = "ssd,hdd";
	static int RAMMin = 2;
	static int RAMMax = 64;
	static int MMAMin = 32;
	static int MMAMax = 16000;
	
	public Pc(int id, String marca, String modello, double prezzobase,
				String cpu, String tiporam, int ram, String tipomma, int mma) {
		super(id, marca, modello, prezzobase);
		this.cpu = cpu;
		this.tiporam = tiporam;
		this.ram = ram;
		this.tipomma = tipomma;		//this.tipomma = tipomma.toUpperCase(); costringo gi� il costruttore a salvarmi il dato maiuscolo
		this.mma = mma;
	}
	
	
	public String getCpu() {
		return cpu;
	}

	public String getTipomma() {
		return tipomma;
	}

	public String getTiporam() {
		return tiporam;
	}

	public int getMma() {
		return mma;
	}

	public int getRam() {
		return ram;
	}
	
	public void setCpu(String cpu) {
		if(isCpu(cpu))
			this.cpu = cpu;
		else
			this.cpu = "valore non valido: " + cpu;
	}


	public void setTipomma(String tipomma) {
		if(isMMA(tipomma,"50"))
			this.tipomma = tipomma;
		else
			this.tipomma = "valore non valido: " + tipomma;
	}


	public void setTiporam(String tiporam) {
		if(isRAM(tiporam,"50"))
			this.tiporam = tiporam;
		else
			this.tiporam = "valore non valido: " + tiporam;
	}


	public void setMma(int mma) {
		if(isMMA("ssd", mma+""))
			this.mma = mma;
		else
			this.mma = -1;
	}


	public void setRam(int ram) {
		if(isRAM("ddr3", ram+""))
			this.ram = ram;
		else
			this.ram = -1;
	}


	public static boolean isValido(String[] riga) {
		return 	Prodotto.isValido(riga)		&&
				isCpu(riga[5]) 				&&
				isRAM(riga[6], (riga[7])) 	&&
				isMMA(riga[8], (riga[9]))	;
	}

	public static boolean isCpu(String modello) {		//Non ancora perfetto.. ",i5" considerato come valore valido
		return CPUValide.indexOf(modello.toLowerCase()) >= 0 && !modello.contains(",");
	}
	
	public static boolean isMMA(String modello, String val) {
		int mma = Integer.parseInt(val);
		return 	MMAValide.indexOf(modello.toLowerCase()) >= 0 && modello.length() == 3 
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
	@Override
	public double prezzo() {
		return  super.prezzo() + costocpu() + costoram() + costomma();
	}
	
	/**
	 * @return
	 * il costo dell�i3 � 30, i5 190, i7 300, i9 500
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
				return 0;
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
				return 0;
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
				return 0;
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
	
	public int benchCPU () {
		switch(getCpu().toLowerCase()) {
		case "i3":
			return 1;
		case "i5":
			return 2;
		case "i7":
			return 3;
		case "i9":
			return 4;
		default:
			return -1;
			
		}
	}
	
	/**
	 * @return
	 * voglio vedere tutte le caratteristiche definite dalle propriet�
	 * sapere il costo finale
	 * e se � da ufficio o per giocare o nessuno dei due
	 */
	@Override
	public String toString() {
		return 	super.toString() 			+	
				"\nCPU: "					+ cpu			+
				"\nRAM: "					+ ram			+
				" GB di tipo: "				+ tiporam 		+
				"\nMMA: "					+ mma			+
				" GB di tipo: "				+ tipomma 		+
				"\nCosto finale: "			+ prezzo() 		+
				(isGaming() ? "\nE' un computer da Gaming SUPER HIGHT-TECH MEGA WOW!!!" : isOffice() ? "\nE' un buon computer da ufficio!" : "\nNon � un computer con cui si pu� giocare o lavorare.. Regalalo a tua zia!");
	}
	
	public String toCSV() {
		return super.toCSV()+cpu+","+tiporam+","+ram+","+tipomma+","+mma;
	}
	
	
	

}
