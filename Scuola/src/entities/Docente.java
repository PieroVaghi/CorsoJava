package entities;

public class Docente {
	public String nome;
	public String cognome;
	public String datanascita;
	public String materieinsegnate;
	public int anniesperienza;
	public double stipendiobase;
	
	/**
	 * @return
	 * Un docente prende
	 * lo stipendiobase + (il numero di materieinsegnate * 100)
	 */
	public double stipendio() {
		double stipendio = stipendiobase + (nMaterie() * 100);
		return stipendio;
	}
	
	/**
	 * @return
	 * il numero di cattedre del docente
	 */
	public int nMaterie() {
		String[] materie = materieinsegnate.split("-");
		return materie.length;
	}
	
	/**
	 * @return
	 * Stampa l'anagrafica del docente
	 */
	public String toString() {
		String risposta = 	"Nome: " 						+ nome 				+
							"\nCognome: "					+ cognome 			+	
							"\nData di Nascita: "			+ datanascita 		+
							"\nMaterie Insegnate: "			+ materieinsegnate	+
							"\nAnni di esperienza: "		+ anniesperienza	+
							"\nStipendio: "					+ stipendio() + " €";		
		return risposta;
	}
}
