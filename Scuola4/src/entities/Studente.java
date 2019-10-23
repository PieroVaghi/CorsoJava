package entities;

public class Studente extends Persona {
	
	String sezione;
	public double mediaing, mediainf, mediaita, mediamate;
	
	public static final String SEZIONIVALIDE = "1a,1b,1c,2a,2b,2c,3a,3b,3c,4a,4b,4c,5a,5b,5c";
	
	public Studente(int id, String nome, String cognome, String datanascita, String genere, String cf, String sezione) {
		super(id, nome, cognome, datanascita, genere, cf);
		this.sezione = sezione;
	}

	public String getSezione() {
		return sezione;
	}

	public double getMediaing() {
		return mediaing;
	}

	public double getMediainf() {
		return mediainf;
	}

	public double getMediaita() {
		return mediaita;
	}

	public double getMediamate() {
		return mediamate;
	}
	
	public static boolean isValido(String[] parti) {
		boolean validazionePapa = Persona.isValido(parti);
		return 	validazionePapa 			&& 
				isSezioneValida(parti[7])	&&
				isVotoValido(parti[8])		&&
				isVotoValido(parti[9])		&&
				isVotoValido(parti[10])		&&
				isVotoValido(parti[11]);
	}
	
	public static boolean isSezioneValida(String sezione) {
		return(SEZIONIVALIDE.indexOf(sezione)>0 && sezione.indexOf(",")<0);		
	}
	public static boolean isVotoValido (String voto) {
		double mediaInt = Double.parseDouble(voto);
		if(mediaInt>0 && mediaInt<11)
			return true;
		else
			return false;
	}
	
	/**
	 * @return
	 * Restituisce la media di tutte le materie
	 */
	public double media()
	{
		int nMaterie = 4;
		double media = (mediaita + mediaing + mediainf + mediamate)/nMaterie;
		return media;
	}
	
	@Override
	public String toString() {
		String risposta = super.toString() + "\n";
		risposta += "Sezione: " 	+ sezione 	+ ",\n" +
					"Inglese: " 	+ mediaing 	+ ",\n" +
					"Italiano: " 	+ mediaita 	+ ",\n" +
					"Informatica: "	+ mediainf 	+ ",\n" +
					"Matematica: " 	+ mediamate	;
		return risposta;
	}
	
	@Override
	public String toCSV() {
		String csvPapa = super.toCSV();
		return csvPapa+sezione+","+mediaing+","+mediaita+","+mediainf+","+mediamate;
	}
	
	
}
