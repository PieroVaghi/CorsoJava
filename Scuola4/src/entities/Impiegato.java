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
	
	
	
}
