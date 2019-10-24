package entities;

public class Smartphone extends Laptop {
	
	private String rete, jack;
	private double megapixel;
	
	static String[] valJack = {"si", "no"};
	static double megamin = 0.2;
	static double megamax = 105;
	static String[] reti = {"E","H+","G","3G","4G","4G+","5G"};
	static String[] costo5 = {"4G","4G+","5G"};
	

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
				isRete(riga[13])		&&
				isJack(riga[15])		&&
				isMegapixel(Double.parseDouble(riga[14]));
	}

	public static boolean isMegapixel(double mega) {
		return mega >= megamin && mega <= megamax;
	}

	public static boolean isRete(String rete) {
		for(String s : reti)
			if(s.equalsIgnoreCase(rete))
				return true;
		return false;
	}
	
	public static boolean isJack(String jack) {
		for(String s : valJack)
			if(s.equalsIgnoreCase(jack))
				return true;
		return false;
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