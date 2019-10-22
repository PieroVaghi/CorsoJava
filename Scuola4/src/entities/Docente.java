package entities;

public class Docente extends Impiegato {
	
	public String[] materie;

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
	 * @param materie
	 */
	public Docente(int id, String nome, String cognome, String datanascita, String genere, String cf, String tipo,
			double stipendio, int anniesp, String materie) {
		super(id, nome, cognome, datanascita, genere, cf, tipo, stipendio, anniesp);
		// italiano-matematica-storia
		this.materie = materie.split("-");
	}

	public String[] getMaterie() {
		return materie;
	}
	
	public static boolean isValido(String[] parti) {
		boolean validazionePapa = Impiegato.isValido(parti);
		return 	validazionePapa 				&& 
				isMaterieValide(parti[9])		;
				
				
	}
	
	private static boolean isMaterieValide(String materie) {
		if(materie.isEmpty())
			return false;
		String[] vMaterie = materie.split("-");
		for(int i=0; i<vMaterie.length; i++)
			switch (vMaterie[i]) {
				case "italiano":
				case "inglese":
				case "informatica":
				case "matematica":
				case "geografia":
				case "storia":
				case "francese":
				case "architettura degli elaboratori 1":
					break;
				default: 
					return false;
			}
		return true;
	}
	
	public double stipendio() {
		double risposta = super.stipendio();
		risposta += (materie.length * 100);
		return risposta;
	}
	
	public String stampaMaterie() {
		String risposta = "";
		for(String s : materie)
			risposta += s + ", ";
		return risposta.substring(0,risposta.length()-2);
	}
	
	public String csvMaterie() {
		String risposta = "";
		for(String s : materie)
			risposta += s + ",";
		return risposta.substring(0,risposta.length()-1);
	}
	
	@Override
	public String toString() {
		String risposta = super.toString() + "\n";
		return  risposta + "Stipendio Effettivo: " + stipendio() + ",\nMaterie: " + stampaMaterie();
	}
	
	public String toCSV() {
		String csvPapa = super.toCSV();
		return csvPapa+","+stipendio()+","+csvMaterie();
	}
	
	

}
