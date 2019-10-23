package entities;

public class Laptop extends Pc{
	
	int orebatteria; 
	double peso, pollici;
	
		
	public Laptop(int id, String marca, String modello, double prezzobase,
				String cpu, String tiporam, int ram, String tipomma, int mma, 
				int orebatteria, double pollici, double peso) {
		super(id, marca, modello, prezzobase, cpu, tiporam, ram, tipomma, mma);
		this.orebatteria = orebatteria;
		this.peso = peso;
		this.pollici = pollici;
	}
	
	

	public double getOrebatteria() {
		return orebatteria;
	}



	public double getPeso() {
		return peso;
	}



	public double getPollici() {
		return pollici;
	}



	public static boolean isValido(String[] riga) {
		return 	Pc.isValido(riga)							&&
				isBatteria(Double.parseDouble(riga[10]))	&&
				isPollici(Double.parseDouble(riga[11]))		&&
				isPeso(Double.parseDouble(riga[12]));
	}
	
	public static boolean isBatteria(double val) {
		return 	(val >= 0 && val <= 24);
	}
	
	public static boolean isPollici(double val) {
		return 	(val >= 10 && val <= 31);
	}
	
	public static boolean isPeso(double val) {
		return 	(val >= 900 && val <= 7000);
	}
	
	
	/**
	 * @return
	 * è la somma di tutti i costi parziali
	 */
	@Override
	public double prezzo() {
		double costo = super.prezzo();
		costo *= (getPeso() >= 5000) ? 0.95 : 1;
		costo *= (getPollici() > 15.7) ? 1.05 : 1;
		return costo;
	}
	
	@Override
	public String toCSV() {
		return super.toCSV()+","+orebatteria+","+peso+","+pollici;
	}

	
	/**
	 * @return
	 * voglio vedere tutte le caratteristiche definite dalle proprietà
	 * sapere il costo finale
	 * e se è da ufficio o per giocare o nessuno dei due
	 */
	@Override
	public String toString() {
		return 	super.toString()			+
				"\nPeso: "					+ peso			+
				"\nSchermo: "				+ pollici		+
				" pollici"					+
				"\nDurata Batteria: "		+ orebatteria	;
	}

}
