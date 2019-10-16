package entities;

public class PnD {
	public String nome;
	public String cognome;
	public String datanascita;
	public String ruolo;
	public int anniesperienza;
	public double stipendiobase;
	
	/**
	 * @return
	 * Il personale non docente guadagna in base al ruolo:\n
	 * Segreteria: stipendiobase + 20*anniesperienza\n
	 * TecnicoLab: stipendiobase + 50*anniesperienza\n
	 * Bidelleria: stipendiobase + 10*anniesperienza\n
	 * Direzione: stipendiobase + 80*anniesperienza\n
	 */
	public double stipendio() {
		switch(ruolo.toLowerCase()) {
			case "segreteria":
				return stipendiobase + anniesperienza*20;
			case "tecnicolab":
				return stipendiobase + anniesperienza*50;
			case "bidelleria":
				return stipendiobase + anniesperienza*10;
			case "direzione":
				return stipendiobase + anniesperienza*80;
			default: return -1;
		}
	}
	
	/**
	 * @return
	 * Un PnD prende annualmente lo stipendio * 14
	 */
	public double stipendioAnnuo() {
		return stipendio()*14;
	}
	
	/**
	 * @return
	 * il ruolo del PnD come stringa
	 */
	public String ruolo() {
		return ruolo;
	}
	
	/**
	 * @return
	 * Stampa l'anagrafica del personale non docente
	 */
	public String toString() {
		String risposta = 	"Nome: " 						+ nome 				+
							"\nCognome: "					+ cognome 			+	
							"\nData di Nascita: "			+ datanascita 		+
							"\nRuolo: "						+ ruolo				+
							"\nAnni di esperienza: "		+ anniesperienza	+
							"\nStipendio: "					+ stipendio() + " €";		
		return risposta;
	}
}
