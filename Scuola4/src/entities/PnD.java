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

}
