package entities;

public class Impiegato extends Persona {
	
	public String tipo; //val possibili: Docente, PND
	public double stipendio;
	int anniesp;

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
	 */
	public Impiegato(int id, String nome, String cognome, String datanascita, String genere, String cf, String tipo, double stipendio, int anniesp) {
		super(id, nome, cognome, datanascita, genere, cf);
		this.tipo = tipo;
		this.stipendio = stipendio;
		this.anniesp = anniesp;
	}

	public String getTipo() {
		return tipo;
	}

	public double getStipendio() {
		return stipendio;
	}

	public int getAnniesp() {
		return anniesp;
	}
	
	public double stipendio() {
		return stipendio;
	}
	
	public static boolean isValido(String[] parti) {
		boolean validazionePapa = Persona.isValido(parti);
		return 	validazionePapa 				&& 
				isTipoValid(parti[0])			&&
				isStipValid(parti[7])			&&
				isAnniEspValid(parti[8])		;
				
	}
	
	private static boolean isAnniEspValid(String anni) {
		if(anni.isEmpty())
			return false;
		int a = Integer.parseInt(anni);
		return !(a<0||a>50);
	}

	private static boolean isTipoValid(String tipo) {
		switch (tipo.toUpperCase()) {
			case "DOCENTE":
			case "STUDENTE":
			case "PND": 
				return true;
			default:
				return false;
		}
	}

	private static boolean isStipValid(String stip) {
		if(stip.isEmpty())
			return false;
		double s = Double.parseDouble(stip);
		return !(s<20||s>3000);
	}

	@Override
	public String toString() {
		String risposta = super.toString() + "\n";
		return (tipo != null ? "Tipo: " + tipo + ",\n" : "") + risposta + "Stipendio base: " + stipendio + ",\nAnni Esperienza: " + anniesp;
	}
	
	public String toCSV() {
		String csvPapa = super.toCSV();
		return tipo+csvPapa+","+stipendio+","+anniesp;
	}
	
	
}
