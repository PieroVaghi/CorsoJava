package entities;

import java.time.Year;

public class Studente {
	public String nome, cognome, genere, datanascita, titolostudiopreg, indirizzo, sezione;
	public int annodiploma, nMaterie;
	public double mediaita, mediaing, mediainf, mediamat;
	
	//METODI 

	/**
	 * @return
	 * Restituisce la media di tutte le materie
	 */
	public double media()
	{
		nMaterie = 4;
		double media = (mediaita + mediaing + mediainf + mediamat)/nMaterie;
		return media;
	}
	
	/**
	 * @return
	 * Ritorna true se la media � maggiore uguale a 6
	 * altrimenti dar� false
	 */
	public boolean isPromosso()
	{
		return(media() >= 6);		
	}
	
	/**
	 * @return
	 * Ritorna la differenza tra  e 2019
	 * se il risultato � negativo ritorna comunque 0
	 */
	public int anniAlDiploma()
	{
		int annimancanti = annodiploma - Year.now().getValue();
		if(annimancanti < 0)
			return 0;
		else
			return annimancanti;
	}
	
	/**
	 * @return
	 * Se la media totale � maggiore o uguale a 7.5
	 * e se la mediaing � maggiore di 7 ma minore di 9
	 * si va in erasmus a Vancuver
	 * se la mediaing � maggiore o uguale a 9 allora si va
	 * in Australia
	 */
	public String erasmusDestination()
	{
		if(media() >= 7.5 )
			if(mediaing > 7 && mediaing < 9)
				return "Vancuver";
			if(mediaing >= 9)
				return "Australia";
		return "No";
	}
	
	/**
	 *  @return
	 *  Ritorna la stringa di presentazione del'erasmus 
	 */
	public String erasmus()
	{
		switch(erasmusDestination()) {
			case "Vancuver":
				return "Si va in erasmus a Vancuver";
			case "Australia":
				return "Si va in erasmus in Australia";
			default:
				return "Non andrai MAI in erasmus!";
		}
	}
	
	/**
	 *  @return
	 *  ritorna il costo di un erasmus in base alla destinazione
	 */
	public double erasmusCosto() {
		switch(erasmusDestination()) {
		case "Vancuver":
			return 300;
		case "Australia":
			return 500;
		default:
			return 0;
	}
	}
	
	/**
	 *  @return
	 *  Stampa scheda studente Garavaglia Culo
	 */
	public String stampaStudente() {
		String risposta = 	"Nome: " 						+ nome 				+
							"\nCognome: "					+ cognome 			+	
							"\nData di Nascita: "			+ datanascita 		+
							"\nTitolo studio pregresso: "	+ titolostudiopreg	+
							"\nIndirizzo: "					+ indirizzo			+
							"\nSezione: "					+ sezione			+
							"\nAnno di diploma: "			+ annodiploma		+
							"\nMedia voti Inglese: "		+ mediaing			+
							"\nMedia voti Italiano: "		+ mediaita			+
							"\nMedia voti Informatica: "	+ mediainf			+
							"\nMedia voti Matematica: "		+ mediamat;
		return risposta;
	}
	



}
