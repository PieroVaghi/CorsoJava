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

}
