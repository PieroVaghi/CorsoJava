package entities;

public class Smartphone extends Laptop {
	
	private String rete, jack;
	private double megapixel;
	

	

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
		return 	Laptop.isValido(riga)	&&
				IUtilities.isRete(riga[14])		&&
				IUtilities.isJack(riga[16])		&&
				IUtilities.isMegapixel(Double.parseDouble(riga[15]));
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
