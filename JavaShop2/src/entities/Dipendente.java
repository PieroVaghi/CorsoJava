package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dipendente {
	// caratteristiche principali del dipendente
	// definire la proprietà ruolo che può avere come valori
	// caporeparto-vicecaporeparto-sottoposto
	// la proprietà reparto: Lavatrici o Pc
	// stabilire lo stipendiobase compreso tra 800 e 3000 euro
	// lo stipendio viene poi calcolato nel seguente modo:
	// il caporeparto prende 10 euro per anni di esperienza
	// il vicecaporeparto prende 100 euro se lavora nel reparto delle lavatrici
	// 250€ se lavora nel reparto PC
	// il sottoposto non aggiunge nulla allo stipendio base
	
	int id;
	String nome, cognome, ruolo, reparto;
	double stipendiobase;
	int anniesperienza;
	List<Integer> prodottiGestiti = new ArrayList<Integer>();
	
	private static String[] ruoliVal = {"caporeparto", "vicecaporeparto", "sottoposto"};
	private static String[] repartiVal = {"pc", "lavatrici"};
	private static int stipMin = 800;
	private static int stipMax = 3000;
	
	
	/**
	 * @param ruolo
	 * @param reparto
	 * @param stipendiobase
	 * @param anniesperienza
	 * @param prodottiGestiti
	 */
	public Dipendente(int id, String nome, String cognome, String ruolo, String reparto, double stipendiobase, int anniesperienza) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.reparto = reparto;
		this.stipendiobase = stipendiobase;
		this.anniesperienza = anniesperienza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public double getStipendiobase() {
		return stipendiobase;
	}

	public void setStipendiobase(double stipendiobase) {
		this.stipendiobase = stipendiobase;
	}

	public int getAnniesperienza() {
		return anniesperienza;
	}

	public void setAnniesperienza(int anniesperienza) {
		this.anniesperienza = anniesperienza;
	}

	public List<Integer> getProdottiGestiti() {
		return prodottiGestiti;
	}

	

	// VALIDAZIONE ----------------------------------------------------------------------------
	
	public static boolean isValido(String[] parti) {
		try {			
			return isNomeCognomeValido(parti[1]) 	&&
			isNomeCognomeValido(parti[2])			&&
			isRuoloVal(parti[3])					&&
			isRepVal(parti[4])						&&
			isStipValid(parti[5])					&&
			isAnniEspValid(parti[6]);
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("problemi con la riga: " + Arrays.toString(parti));
			return false;
		} 
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
	
	private static boolean isAnniEspValid(String anni) {
		boolean risposta = false;
		if(anni.isEmpty())
			return false;
		try {
			int a = Integer.parseInt(anni);
			risposta = !(a<0||a>50);
		} catch(NumberFormatException n) {
			System.out.println(anni + " non è un numero");
			return false;
		}
		finally {
			System.out.println("Finalmente ciao");
		}
		return risposta;
	}
	
	private static boolean isRuoloVal(String tipo) {
		for(String s : ruoliVal)
			if(s.equalsIgnoreCase(tipo))
				return true;
		return false;
	}
	
	private static boolean isRepVal(String tipo) {
		for(String s : repartiVal)
			if(s.equalsIgnoreCase(tipo))
				return true;
		return false;
	}
	
	private static boolean isStipValid(String stip) {
		boolean risposta = false;
		if(stip.isEmpty())
			return false;
		try {
			double s = Double.parseDouble(stip);
			risposta = !(s<stipMin||s>stipMax);
		} catch(NumberFormatException n) {
			System.out.println(stip + " non è un numero");
			return false;
		}
		return risposta;
	}
	
	// METODI -----------------------------------------------------------------------------------
	
	public double stipendio() {
		double risposta = getStipendiobase();
		switch (this.ruolo.toLowerCase()) {
			case "caporeparto":
				risposta += 10*getAnniesperienza();
			break;
			case "vicecaporeparto":
				switch (getReparto().toLowerCase()) {
					case "lavatrici":
						risposta += 100;
					break;
					case "pc":
						risposta += 250;
					break;
				}
			break;
		}
		return risposta;
	}

	
	
	public boolean aggiungiProdottoGestito(int idProdotto) {
		return this.prodottiGestiti.add(idProdotto);
	}
	
	public int rimuoviProdottoGestito(int idProdotto) {
		return this.prodottiGestiti.remove(idProdotto);
	}
	
	
	@Override
	public String toString() {
		return "Id: " + id + ",\n" + (nome != null ? "Nome: " + nome + ",\n" : "")
				+ (cognome != null ? "Cognome: " + cognome + ",\n" : "")
				+ (ruolo != null ? "Ruolo: " + ruolo + ",\n" : "")
				+ (reparto != null ? "Reparto: " + reparto + ",\n" : "") + "Stipendio base: " + stipendiobase
				+ ",\nAnni esperienza: " + anniesperienza;
	}
	
	
}
