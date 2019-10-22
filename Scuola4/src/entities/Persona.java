package entities;

public class Persona {
	
	String nome, cognome, datanascita, genere;
	int id;
	
	// METODI GET E COSTRUTTORI ---------------------------------------------------------------------------------------------
	
	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 * @param genere
	 */
	public Persona(int id, String nome, String cognome, String datanascita, String genere) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.genere = genere;
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
