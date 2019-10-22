package entities;

public class Persona {
	
	String nome, cognome, datanascita, genere, cf;
	int id;
	
	// METODI GET E COSTRUTTORI ---------------------------------------------------------------------------------------------
	
	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 * @param genere
	 * @param cf
	 */
	public Persona(int id, String nome, String cognome, String datanascita, String genere, String cf) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.genere = genere;
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}


	public String getDatanascita() {
		return datanascita;
	}


	public String getGenere() {
		return genere;
	}

	public int getId() {
		return id;
	}
	
	


	
	

	
	

}
