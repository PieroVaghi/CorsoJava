package entities;

import java.time.Year;

public class Persona {
	
	String nome, cognome, datanascita, genere, cf;
	int id;
	
	// METODI GET E COSTRUTTORI ---------------------------------------------------------------------------------------------
	
	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 * @param genere
	 * @param cf
	 */
	public Persona(int id, String nome, String cognome, String datanascita, String genere, String cf) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.genere = genere;
		this.cf = cf;
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
	
	public static boolean isValido(String[] parti) {
		return  isNomeCognomeValido(parti[2]) 	&&
				isNomeCognomeValido(parti[3]) 	&&
				isDataValida(parti[4])			&&
				isGenereValido(parti[5]);			
	}
	
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
				return(anno%400 == 0) ? true : false;
			return true;
		} 
		else 
			return false;
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
	public static boolean isDataValida (String data) {
		// YYYY-MM-DD
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
		switch (genere.toUpperCase()) {
			case "M":
			case "F":
			case "N":
				return true;
			default:
				return false;
		}			
	}

	
	@Override //annotazione
	public String toString() {
		return "id: " + id + ",\n" + (nome != null ? "nome: " + nome + ",\n" : "")
				+ (cognome != null ? "cognome: " + cognome + ",\n" : "")
				+ (datanascita != null ? "datanascita: " + datanascita + ",\n" : "")
				+ (genere != null ? "genere: " + genere + ",\n" : "") + (cf != null ? "cf: " + cf : "");
	}
	
	public String toCSV() {
		return id+","+nome+","+cognome+","+datanascita+","+genere+","+cf;
	}
	


	
	

	
	

}
