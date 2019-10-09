package entities;

import java.time.Year;

public class Studente {
	public String nome, cognome, genere, datanascita, titolostudiopreg, indirizzo, sezione;
	public int annodiploma, nMaterie;
	public double mediaita, mediaing, mediainf, mediamat;
	
	//Metodi 

	public double media()
	{
		nMaterie = 4;
		double media = (mediaita + mediaing + mediainf + mediamat)/nMaterie;
		return media;
	}
	
	/**
	 * @return
	 * Ritorna true se la media è maggiore uguale a 6
	 * altrimenti darà false
	 */
	public boolean isPromosso()
	{
		return(media() >= 6);		
	}
	
	/**
	 * @return
	 * Ritorna la differenza tra  e 2019
	 * se il risultato è negativo ritorna comunque 0
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
	 * Se la media totale è maggiore o uguale a 7.5
	 * e se la mediaing è maggiore di 7 ma minore di 9
	 * si va in erasmus a Vancuver
	 * se la mediaing è maggiore o uguale a 9 allora si va
	 * in Australia
	 */
	public String erasmus()
	{
		if(media() >= 7.5 )
			if(mediaing > 7 && mediaing < 9)
				return "Si va in erasmus a Vancuver";
			if(mediaing >= 9)
				return "Si va in erasmus in Australia";
		return "Non andrai MAI in erasmus!";
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
