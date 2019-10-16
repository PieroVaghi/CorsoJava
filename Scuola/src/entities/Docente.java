package entities;

import java.time.Year;

public class Docente {
	public String nome;
	public String cognome;
	public String datanascita;
	public String materieinsegnate;
	public int anniesperienza;
	public double stipendiobase;
	
	public static boolean isValido(String[] parti) {
			return 	isNomeCognomeValido(parti[0]) 	&&
					isNomeCognomeValido(parti[1]) 	&&
					isDataNascitaValida(parti[2]) 	&&
					isMaterieValide(parti[3])		&&
					isAnniEspValid(parti[4])		&&
					isStipBaseValid(parti[5])		;
					
	}
	

	private static boolean isStipBaseValid(String stip) {
		if(stip.isEmpty())
			return false;
		double s = Double.parseDouble(stip);
		return !(s<200||s>10000);
	}


	private static boolean isAnniEspValid(String anni) {
		if(anni.isEmpty())
			return false;
		int a = Integer.parseInt(anni);
		return !(a<0||a>60);
	}
	
	


	private static boolean isMaterieValide(String materie) {
		if(materie.isEmpty())
			return false;
		String[] vMaterie = materie.split("-");
		for(int i=0; i<vMaterie.length; i++)
			switch (vMaterie[i]) {
				case "italiano":
				case "inglese":
				case "informatica":
				case "matematica":
					break;
				default: 
					return false;
			}
		return true;
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
				if(anno%400 == 0)
					return true;
				else
					return false;
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
	 * Un docente prende annualmente lo stipendio * 14
	 */
	public double stipendioAnnuo() {
		return stipendio()*14;
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
