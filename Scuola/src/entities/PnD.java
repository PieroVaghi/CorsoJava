package entities;

import java.time.Year;


public class PnD {
	public String nome;
	public String cognome;
	public String datanascita;
	public String ruolo;
	public int anniesperienza;
	public double stipendiobase;
	
	public static boolean isValido(String[] parti) {
		return 	isNomeCognomeValido(parti[0]) 	&&
				isNomeCognomeValido(parti[1]) 	&&
				isDataNascitaValida(parti[2]) 	&&
				isRuoloValido(parti[3])			&&
				isAnniEspValid(parti[4])		&&
				isStipBaseValid(parti[5])		;
				
	}
	
	private static boolean isStipBaseValid(String stip) {
		if(stip.isEmpty())
			return false;
		double s = Double.parseDouble(stip);
		if(s<200||s>10000)
			return false;
		else
			return true;
	}


	private static boolean isAnniEspValid(String anni) {
		if(anni.isEmpty())
			return false;
		int a = Integer.parseInt(anni);
		if(a<0||a>60)
			return false;
		else
			return true;
	}
	
	


	private static boolean isRuoloValido(String ruolo) {
		if(ruolo.isEmpty())
			return false;
			switch (ruolo.toLowerCase()) {
				case "segreteria":
				case "tecnicolab":
				case "bidelleria":
				case "direzione":
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
