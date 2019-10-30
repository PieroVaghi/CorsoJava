package entities;

import java.util.Arrays;
import java.util.List;

public class Laptop extends Pc{
	

	int orebatteria; 
	double peso, pollici;
	
	static int minPeso;
	static int maxPeso;
	static int maxPollici;
	static int minPollici;
	static int maxBat;
	static int minBat;
		
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
		if(IUtilities.isValoreCompresoDouble(orebatteria+"", minBat, maxBat))
			this.orebatteria = orebatteria;
		else
			this.orebatteria = -1;
	}



	public void setPeso(double peso) {
		if(IUtilities.isValoreCompresoDouble(peso+"", minPeso, maxPeso))
			this.peso = peso;
		else
			this.peso  = -1;
	}



	public void setPollici(double pollici) {
		if(IUtilities.isValoreCompresoDouble(pollici+"", minPollici, maxPollici))
			this.pollici = pollici;
		else
			this.pollici = -1;
	}



	public static boolean isValido(String[] riga) {
		try {
			return 	Pc.isValido(riga)													&&
					IUtilities.isValoreCompresoDouble(riga[11], minBat, maxBat)			&&
					IUtilities.isValoreCompresoDouble(riga[12], minPollici, maxPollici)	&&
					IUtilities.isValoreCompresoDouble(riga[13], minPeso, maxPeso)		;
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("problemi con la riga: " + Arrays.toString(riga));
			return false;
		}
	}
	
	
	public static void config (List<String> l) {
		for(String s : l)
			try {
				switch (s.substring(0,s.indexOf(":"))) {
					case "minPeso":
						minPeso = Integer.parseInt(s.split(":")[1]);
					break;
					case "maxPeso":
						maxPeso = Integer.parseInt(s.split(":")[1]);
					break;
					case "maxPollici":
						maxPollici = Integer.parseInt(s.split(":")[1]);
					break;
					case "minPollici":
						minPollici = Integer.parseInt(s.split(":")[1]);
					break;
					case "maxBat":
						maxBat = Integer.parseInt(s.split(":")[1]);
					break;
					case "minBat":
						minBat = Integer.parseInt(s.split(":")[1]);
					break;
				}
			} catch(NumberFormatException n) {
				System.out.println(s.split(":")[1] + "non è un valore parsabile in Integer");
			}
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
