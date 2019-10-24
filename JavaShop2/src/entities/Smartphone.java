package entities;

public class Smartphone extends Laptop {
	
	private String rete, jack;
	private double megapixel;
	
	static String[] valJack = {"si", "no"};
	static double megamin = 0.2;
	static double megamax = 105;
	static String[] reti = {"E","H+","G","3G","4G","4G+","5G"};
	

	public Smartphone(int id, String marca, String modello, double prezzobase, 
							String cpu, String tiporam, int ram, String tipomma, int mma,
							int orebatteria, double pollici, double peso,
							String rete, double megapixel, String jack) {
		
		super(id, marca, modello, prezzobase, cpu, tiporam, ram, tipomma, mma, orebatteria, pollici, peso);
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
		return 	Laptop.isValido(riga)	&&
				isRete(riga[10])		&&
				isJack(riga[11])		&&
				isMegapixel(Double.parseDouble(riga[12]));
	}

	public static boolean isMegapixel(double mega) {
		return mega >= megamin && mega <= megamax;
	}

	public static boolean isRete(String string) {
		boolean controllo = false;
		for(String s : reti)
			if(s.equalsIgnoreCase(string))
				controllo = true;
		return controllo;
	}
	
	public static boolean isJack(String string) {
		boolean controllo = false;
		for(String s : valJack)
			if(s.equalsIgnoreCase(string))
				controllo = true;
		return controllo;
	}
	
	
	

}
