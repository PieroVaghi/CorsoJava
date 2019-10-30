package entities;

import java.util.Arrays;
import java.util.List;

public class Smartphone extends Laptop {
	
	private String rete, jack;
	private double megapixel;
	
	static String[] valJack;
	static double megamin;
	static double megamax;
	static String[] reti;
	static String[] costo5;
	

	public Smartphone(int id, int iddip, String marca, String modello, double prezzobase, 
							String cpu, String tiporam, int ram, String tipomma, int mma,
							int orebatteria, double pollici, double peso,
							String rete, double megapixel, String jack) {
		
		super(id, iddip, marca, modello, prezzobase, cpu, tiporam, ram, tipomma, mma, orebatteria, pollici, peso);
		this.rete = rete;
		this.megapixel = megapixel;
		this.jack = jack;
	}

	public String getRete() {
		return rete;
	}
	
	
	public String getJack() {
		return jack;
	}
	
	
	public double getMegapixel() {
		return megapixel;
	}
	

	public void setRete(String rete) {
		this.rete = rete;
	}


	public void setJack(String jack) {
		this.jack = jack;
	}


	public void setMegapixel(double megapixel) {
		this.megapixel = megapixel;
	}

	public static boolean isValido(String[] riga) {
		config(Prodotto.limiti);
		try {
			return 	Laptop.isValido(riga)	&&
					IUtilities.isStringaInVett(riga[14], reti)	&&
					IUtilities.isStringaInVett(riga[16], valJack)		&&
					IUtilities.isValoreCompresoDouble(riga[15], megamin, megamax);
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("problemi con la riga: " + Arrays.toString(riga));
			return false;
		}
	}

	public static void config (List<String> l) {
		for(String s : l)
			try {
				switch (s.substring(0,s.indexOf(":"))) {
					case "valJack":
						valJack = (s.split(":")[1]).split(",");
					break;
					case "megamin":
						megamin = Double.parseDouble(s.split(":")[1]);
					break;
					case "megamax":
						megamax = Double.parseDouble(s.split(":")[1]);
					break;
					case "reti":
						reti = (s.split(":")[1]).split(",");
					break;
					case "costo5":
						costo5 = (s.split(":")[1]).split(",");
					break;
				}
			} catch(NumberFormatException n) {
				System.out.println(s.split(":")[1] + "non è un valore parsabile in Double");
			}
	}

	@Override
	public double prezzo() {
		double costo = super.prezzo();
		for(String s : costo5)
			costo *= (getRete().equalsIgnoreCase(s)) ? 1.05 : 1;		
		costo *= (getJack().equalsIgnoreCase("no")) ? 1.20 : 1;
		return costo;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\n" + (rete != null ? "Rete: " + rete + ",\n" : "") + "Megapixel: " + megapixel + ",\n"
				+ (jack != null ? "Jack: " + jack : "");
	}
	
	
	
	
	

}
