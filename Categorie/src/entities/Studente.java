package entities;

public class Studente {
	public String nome, cognome, datanascita, 
	titolostudiopreg, indirizzo, sezione;
	public int annodiploma;
	public double mediaita, mediaing, mediainf, mediamat;
	
	//metodi HACK TO-DO:
	public double media()
	{
		double media = (mediaita + mediaing + mediainf + mediamat)/4;
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
	
	//ritorna la differenza tra 2019 e
	//l'annodiploma
	//se il risultato è negativo lascio comunque 0
	public int anniAlDiploma()
	{
		int annimancanti = annodiploma - 2019;
		if(annimancanti < 0)
			return 0;
		else
			return annimancanti;
	}
	
	//se la media totale è maggiore o uguale a 7.5
	//e se la mediaing è maggiore di 7 ma minore di 9
	//si va in erasmus a Vancuver
	//se la mediaing è maggiore o uguale a 9 allora si va
	//in Australia
	public String erasmus()
	{
		if(media() >= 7.5 )
			if(mediaing > 7 && mediaing < 9)
				return "Si va in erasmus a Vancuver";
			else if(mediaing >= 9)
				return "Si va in erasmus in Australia";
		return "Non andrai MAI in erasmus!";
	}
	
	//Stampa scheda studente
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
