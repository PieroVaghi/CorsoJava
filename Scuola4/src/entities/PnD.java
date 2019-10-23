package entities;

public class PnD extends Impiegato {
	
	public String ruolo;

	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 * @param genere
	 * @param cf
	 * @param tipo
	 * @param stipendio
	 * @param anniesp
	 * @param ruolo
	 */
	public PnD(int id, String nome, String cognome, String datanascita, String genere, String cf, String tipo,
			double stipendio, int anniesp, String ruolo) {
		super(id, nome, cognome, datanascita, genere, cf, tipo, stipendio, anniesp);
		this.ruolo = ruolo;
	}
	
	public String getRuolo() {
		return ruolo;
	}
	
	public static boolean isValido(String[] parti) {
		boolean validazionePapa = Impiegato.isValido(parti);
		return 	validazionePapa 				&& 
				isRuoloValido(parti[9])			;
				
				
	}
	
	private static boolean isRuoloValido(String ruolo) {
		if(ruolo.isEmpty())
			return false;
			switch (ruolo.toLowerCase()) {
				case "segreteria":
				case "tecnicolab":
				case "bidelleria":
				case "direzione":
					return true;
				default: 
					return false;
			}
	}
	
	@Override
	public double stipendio() {
		switch(ruolo.toLowerCase()) {
			case "segreteria":
				return super.stipendio() + super.getAnniesp()*20;
			case "tecnicolab":
				return super.stipendio() + super.getAnniesp()*50;
			case "bidelleria":
				return super.stipendio() + super.getAnniesp()*10;
			case "direzione":
				return super.stipendio() + super.getAnniesp()*80;
			default: return -1;
		}
	}
	
	@Override
	public String toString() {
		String risposta = super.toString() + "\n";
		return  risposta + ",\nRuolo: " + ruolo + "Stipendio Effettivo: " + stipendio() +" €";
	}
	
	@Override
	public String toCSV() {
		String csvPapa = super.toCSV();
		return csvPapa+","+ruolo+","+stipendio();
	}


}
