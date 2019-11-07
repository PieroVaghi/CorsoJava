package enities;

public class Dipendente {
	
	private int id, mensilita, idDipartimento, idResponsabile;
	private String nome, cognome, genere, dataNascita, ruolo, citta, dataassunzione;
	private double stipendio;
	
	
	/**
	 * @param id
	 * @param mensilita
	 * @param nome
	 * @param cognome
	 * @param genere
	 * @param dataNascita
	 * @param ruolo
	 * @param citta
	 * @param idDipartimento
	 * @param dataassunzione
	 * @param idResponsabile
	 * @param stipendio
	 */
	public Dipendente(int id, int mensilita, String nome, String cognome, String genere, String dataNascita,
			String ruolo, String citta, int idDipartimento, String dataassunzione, int idResponsabile,
			double stipendio) {
		super();
		this.id = id;
		this.mensilita = mensilita;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.dataNascita = dataNascita;
		this.ruolo = ruolo;
		this.citta = citta;
		this.idDipartimento = idDipartimento;
		this.dataassunzione = dataassunzione;
		this.idResponsabile = idResponsabile;
		this.stipendio = stipendio;
	}
	
	
	public int getId() {
		return id;
	}
	public int getMensilita() {
		return mensilita;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getGenere() {
		return genere;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public String getRuolo() {
		return ruolo;
	}
	public String getCitta() {
		return citta;
	}
	public int getIdDipartimento() {
		return idDipartimento;
	}
	public String getDataassunzione() {
		return dataassunzione;
	}
	public int getIdResponsabile() {
		return idResponsabile;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMensilita(int mensilita) {
		this.mensilita = mensilita;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setIdDipartimento(int idDipartimento) {
		this.idDipartimento = idDipartimento;
	}
	public void setDataassunzione(String dataassunzione) {
		this.dataassunzione = dataassunzione;
	}
	public void setIdResponsabile(int idResponsabile) {
		this.idResponsabile = idResponsabile;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	
	
	@Override
	public String toString() {
		return "id: " + id + ",\nmensilita: " + mensilita + ",\nidDipartimento: " + idDipartimento
				+ ",\nidResponsabile: " + idResponsabile + ",\n" + (nome != null ? "nome: " + nome + ",\n" : "")
				+ (cognome != null ? "cognome: " + cognome + ",\n" : "")
				+ (genere != null ? "genere: " + genere + ",\n" : "")
				+ (dataNascita != null ? "dataNascita: " + dataNascita + ",\n" : "")
				+ (ruolo != null ? "ruolo: " + ruolo + ",\n" : "") + (citta != null ? "citta: " + citta + ",\n" : "")
				+ (dataassunzione != null ? "dataassunzione: " + dataassunzione + ",\n" : "") + "stipendio: "
				+ stipendio;
	}
	
	
	
	
	

}
