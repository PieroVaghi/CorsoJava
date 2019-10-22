package entities;

public class Studente extends Persona {
	
	String sezione;
	public double mediaing, mediainf, mediaita, mediamate;
	
	public Studente(int id, String nome, String cognome, String datanascita, String genere, String cf, String sezione) {
		super(id, nome, cognome, datanascita, genere, cf);
		this.sezione = sezione;
	}

	public String getSezione() {
		return sezione;
	}

	public double getMediaing() {
		return mediaing;
	}

	public double getMediainf() {
		return mediainf;
	}

	public double getMediaita() {
		return mediaita;
	}

	public double getMediamate() {
		return mediamate;
	}
	
	
	
}
