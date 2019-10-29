package entities;

public class Laptop extends Pc{
	

	int orebatteria; 
	double peso, pollici;
	
	
		
	public Laptop(int id, int iddip, String marca, String modello, double prezzobase,
				String cpu, String tiporam, int ram, String tipomma, int mma, 
				int orebatteria, double pollici, double peso) {
		super(id,iddip, marca, modello, prezzobase, cpu, tiporam, ram, tipomma, mma);
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



	public void setOrebatteria(int orebatteria) {
		if(IUtilities.isBatteria(orebatteria))
			this.orebatteria = orebatteria;
		else
			this.orebatteria = -1;
	}



	public void setPeso(double peso) {
		if(IUtilities.isPeso(peso))
			this.peso = peso;
		else
			this.peso  = -1;
	}



	public void setPollici(double pollici) {
		if(IUtilities.isPollici(pollici))
			this.pollici = pollici;
		else
			this.pollici = -1;
	}



	public static boolean isValido(String[] riga) {
		return 	Pc.isValido(riga)							&&
				IUtilities.isBatteria(Double.parseDouble(riga[11]))	&&
				IUtilities.isPollici(Double.parseDouble(riga[12]))		&&
				IUtilities.isPeso(Double.parseDouble(riga[13]));
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
