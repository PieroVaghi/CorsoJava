package entities;

import java.time.Year;

public class Studente {
	public String nome, cognome, genere, datanascita, titolostudiopreg, indirizzo, sezione;
	public int annodiploma, nMaterie;
	public double mediaita, mediaing, mediainf, mediamat;
	
	//COSTRUTTORI
	public Studente(){}
	
	public Studente(String nome) {
		this.nome = nome;
	}
	
	public Studente(String nome, String cognome) {
			this.nome = nome;
			this.cognome = cognome;
	}
	
	
	//METODI STATICI
	
	public static boolean isNomeCognomeValido (String n) {
		boolean ris = true;
		if(!n.isEmpty()) {
			String[] numeri = "0123456789,.;:-_|!£$%&/()=?^*+€°§".split("");
			for(int i = 0; i < numeri.length; i++)
				if(n.indexOf(numeri[i]) >=0)
					return false;
		}
		else 
			ris = false;
		return ris;			
	}
	
	public static boolean isBisestile (int anno) {
		if(anno%4 == 0) {
			if(anno%100 == 0) 
				if(anno%400 == 0)
					return true;
				else
					return false;
			return true;
		} else return false;
	}
	
	public static boolean isAnnoGiusto (int anno) {
		if(anno < Year.now().getValue() && anno > 1880)
			return true;
		else 
			return false;
	}
	
	public static boolean isMeseGiusto (int mese) {
		if(mese < 1 || mese > 12)
			return false;
		else 
			return true;
	}
	
	public static boolean isGiornoGiusto (int giorno, int mese, int anno) {
		switch (mese) {
			case 4:
			case 6:
			case 9:
			case 11:
				if(giorno>0 && giorno<31)
					return true;
			break;
			case 2:
				if(isBisestile(anno) && (giorno>0 && giorno<30))
					return true;
				if(!isBisestile(anno) && (giorno>0 && giorno<29))
					return true;
			break;
			default:
				if(giorno>0 && giorno<32)
					return true;
			break;
		}
		return false;
	}
	
	public static boolean isDataNascitaValida (String data) {
		data = data.toLowerCase();
		String[] lettere = "abcdefghijklmnopqrstuvwxyz,.;:_<>ùàòè+ç°§*é@#ù][{}ì'|!£$%&/()=?^".split("");
		for(int i = 0; i < lettere.length; i++)
			if(data.indexOf(lettere[i]) >=0)
				return false;
		String[] dataSplit = data.split("-");
		int anno = Integer.parseInt(dataSplit[0]);
		int mese = Integer.parseInt(dataSplit[1]);
		int giorno = Integer.parseInt(dataSplit[2]);
		return 	isAnnoGiusto(anno) &&
				isMeseGiusto(mese) &&
				isGiornoGiusto(giorno,mese,anno);
	}
	
	public static boolean isGenereValido (String genere) {
		if(genere.isEmpty())
			return false;
		switch (genere.toUpperCase()) {
			case "M":
				return true;
			case "F":
				return true;
			case "N":
				return true;
			default:
				return false;
		}			
	}
	
	
	public static boolean isMediaValida (String media) {
		if(media.isEmpty())
			return false;
		double mediaInt = Double.parseDouble(media);
		if(mediaInt>0 && mediaInt<11)
			return true;
		else
			return false;
	}
	
	public static boolean isValido (String[] parti) {
		return 	isNomeCognomeValido(parti[0]) 	&&
				isNomeCognomeValido(parti[1]) 	&&
				isDataNascitaValida(parti[2]) 	&&
				isGenereValido(parti[3])		&&
				isMediaValida(parti[4])			&&
				isMediaValida(parti[5])			&&
				isMediaValida(parti[6])			&&
				isMediaValida(parti[7]);
				
	}
			
	
	
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
