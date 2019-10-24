package entities;

import java.util.Arrays;

public class Lavatrice extends Prodotto {

	private int capacitachili, girialminuto;
	private String[] programmi;
	private static int mingiri = 0;
	private static int maxgiri = 10000;
	private static String[] programVal = {"stirofacile","scuri","colorati","delicati","eco","rapido"};
	private static int mincap = 2;
	private static int maxcap = 15;
	
	public Lavatrice(int id, String marca, String modello, double prezzobase, 
					int capacitachili, int girialminuto, String programmi) {
		super(id, marca, modello, prezzobase);
		this.capacitachili = capacitachili;
		this.girialminuto = girialminuto;
		this.programmi = programmi.split("-");
	}
	
	public int getGirialminuto() {
		return girialminuto;
	}

	public String[] getProgrammi() {
		return programmi;
	}

	public int getCapacitachili() {
		return capacitachili;
	}
	
	void setCapacitachili(int capacitachili) {
		if(isCapchili(capacitachili+""))
			this.capacitachili = capacitachili;		
	}
	
	public void setGirialminuto(int girialminuto) {
		this.girialminuto = girialminuto;
	}

	public void setProgrammi(String[] programmi) {
		this.programmi = programmi;
	}
	
	public static boolean isValido(String[] riga) {
		return 	Prodotto.isValido(riga)	&&
				isCapchili(riga[5]) 	&&
				isGiriminuto(riga[6]) 	&&
				isProgrammiVal(riga[7])	;
	}

	public static boolean isGiriminuto(String giro) {
		int giri = Integer.parseInt(giro);
		return giri <= mingiri && giri >= maxgiri;
	}

	public static boolean isCapchili(String capchili) {
		int c = Integer.parseInt(capchili);
		return c >= mincap && c <= maxcap;
	}
	
	public static boolean isProgrammiVal(String programmi) {
		String[] programVet = programmi.split("-");
		boolean controllo = false;
		for(String s : programVet)
			for(String z : programVal)
				if(s.equalsIgnoreCase(z))
					controllo = true;
		return controllo;
	}
	
	@Override
	public double prezzo() {
		return super.prezzo();
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Capacitachili: " + capacitachili + ",\nGirialminuto: " + girialminuto + ",\n"
				+ (programmi != null ? "Programmi: " + Arrays.toString(programmi) : "");
	}
	
	
	
	
}
