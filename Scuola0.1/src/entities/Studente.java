package entities;

public class Studente {

	public String nome;
	public String cognome;
	public String dataNascita;
	public String genere;
	public double mediaIta;
	public double mediaIng;
	public double mediaInf;
	public double mediaMat;
	
	/**
	 * @return
	 * Ritorna la media dei voti delle quattro materie
	 */
	public double media() {
		return somma()/4;
	}
	
	/**
	 * @return
	 * Ritorna la somma dei voti delle quattro materie
	 */
	public double somma() {
		return mediaIta + mediaIng + mediaInf + mediaMat;
	}
	
	/**
	 * @return
	 * True se promosso (media >= 6)
	 */
	public boolean isPromosso() {
		return media() >= 6;
	}
	
	/**
	 * @return
	 * Ritorna "Vancuver ti aspetta!" oppure "Australia arrivo!" o ancora "Non puoi andare in erasmus" in base alla tua media di inglese
	 */
	public String erasmus() {
		return 
				media() >= 7.5 
								? 
									mediaIng > 7 && mediaIng <9
										? "Vancuver ti aspetta!"
										: 
											mediaIng >= 9
												? "Australia arrivo!"
												: "Non puoi andare in erasmus"
								: "Non puoi andare in erasmus";
						
	}

	public String toString() {
		return 	"Nome: " 						+ nome 			+
				"\nCognome: "					+ cognome 		+	
				"\nData di Nascita: "			+ dataNascita 	+
				"\nGenere: "					+ genere		+
				"\nErasmus: "					+ erasmus()		+
				"\nPromosso: "					+ (isPromosso() ? "Si" : "No")+
				" con la media del "			+ media();
	}
}
