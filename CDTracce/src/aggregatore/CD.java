package aggregatore;

import entities.Traccia;

public class CD {
	//titolo, Traccia[] tracce, etichetta, datapubblicazione, costo
	public String titolo, etichetta, datapublicazione;
	public double costo;
	public Traccia[] tracce;
	
	public CD() {}
	
	public CD (String riga) {
		//titolo,etichetta,datapubbyyyy-mm-gg,costo,4,1-"Elicrisio"-"Folkstone"-5;2-"JingleBels"-"Folkstone"-3;1-"Caramelle"-"TonyEffe,Wayne,Pyrex"-3.4;4-"You make me wanna"-"Blue,BackstreetBoys"-4.2
	}
	
	public CD (String titolo, String etichetta, String datapubb, double costo, int ntracce, String traks) {
		this.titolo = titolo;
		this.etichetta = etichetta;
		this.datapublicazione = datapubb;
		this.costo = costo;
		//id-titolo-artisti,separati,da,virgola-minuti;id-titolo-artisti,separati,da,virgola-minuti;id-titolo-artisti,separati,da,virgola-minuti;
		String[] tracceSplittate = traks.split(";");
		tracce = new Traccia[ntracce];
		for(int i = 0; i<tracceSplittate.length && i<tracce.length; i++) {
			//id-titolo-artisti,separati,da,virgola-minuti
			String[] traccia = tracceSplittate[i].split("-");
			Traccia t = new Traccia(	Integer.parseInt(traccia[0]),
										traccia[1], traccia[2], 
										Double.parseDouble(traccia[3]));
			tracce[i] = t;		
		}
		
	}
	
	public String titoli() {
		String risposta = "Titoli:\n";
//		for (int i = 0; i < tracce.length; i++) {
//			risposta += tracce[i].titolo + "\n";
//		}
		for(Traccia t : tracce)
			risposta += t.getTitolo() + "\n";
		return risposta;
	}
	
	public String stringaArtisti() {
		String artisti = "";
		for (int i = 0; i < tracce.length; i++) 
			for(int j = 0; j < tracce[i].getArtisti().length; j++)
//				if((artisti.indexOf(tracce[i].getArtisti()[j])) > 0 && !tracce[i].getArtisti()[j].equals(artisti.substring(artisti.indexOf(tracce[i].getArtisti()[j]), tracce[i].getArtisti()[j].length())))
				if(!artisti.contains(tracce[i].getArtisti()[j]))	
					artisti += tracce[i].getArtisti()[j] + ",";
		artisti = artisti.substring(0, artisti.length()-1);
		return artisti;
	}
	
	public int totaleNumeroArtisti(){
		return stringaArtisti().split(",").length;
	}
	
	public double totaleMinutiCd() {
		double min = 0;
		for (int i = 0; i < tracce.length; i++) {
			min += tracce[i].getMinuti();
		}
		return min;
	}
	
	public double mediaMinutiCd() {
		return totaleMinutiCd()/tracce.length;
	}
	
	public int totaleTracce() {
		return tracce.length;
	}
	
	public int totaleTracce(String artista) {
		int tot = 0;
		for (int i = 0; i < tracce.length; i++) {
			for (int j = 0; j < tracce[i].getArtisti().length; j++) {
				if(tracce[i].getArtisti()[j].equalsIgnoreCase(artista)) {
					tot ++;
					break;
				}
			}
		}
		return tot;
	}
	
//	for (int i = 0; i < tracce.length; i++) {
//		for (int j = 0; j < tracce[i].artisti.length; j++) {
//			if(tracce[i].artisti[j].equalsIgnoreCase(artista)) {
//				risposta += tracce[i].titolo + "\n";
//				break;
//			}
//		}
//	}
	
	public String nomeTracce(String artista) {
		String risposta = "";
		for (Traccia t : tracce) 
			for (String art : t.getArtisti()) 
				if(art.equalsIgnoreCase(artista)) {
					risposta += t.getTitolo() + "\n";
					break;
				}
		return risposta;
	}
	
	public Traccia[] vettoreTracce() {
		return tracce;
	}
	
	public Traccia[] vettoreTracce(String artista) {
		int num = totaleTracce(artista);
		int cont = 0;
		Traccia[] tracceArt = new Traccia[num];
		for (int i = 0; i < tracce.length; i++) {
			for (int j = 0; j < tracce[i].getArtisti().length; j++) {
				if(tracce[i].getArtisti()[j].equalsIgnoreCase(artista)) {
					tracceArt[cont] = tracce[i];
					cont ++;
					break;
				}
			}
		}
		return tracceArt;
	}

	public double durataTracceArtista(String artista) {
		double tot = 0;
		for (Traccia t : tracce) {
			for (String s : t.getArtisti()) {
				if(s.equalsIgnoreCase(artista)) {
					tot += t.getMinuti();
					break;
				}
			}
		}
		return tot;
	}
//	public listaTracce() {};

	public double durata() {
		double risposta = 0;
		for(Traccia t : tracce)
			risposta += t.getMinuti();
		return risposta;
	}

	public double mediaDurata() {	
		return durata()/tracce.length;
	}

	public double minimo() {
		double min = 100;
		for(Traccia t : tracce)
			min = (min > t.getMinuti()) ? t.getMinuti() : min;
		return min;
	}

	public String canzonePiuBreve() {
		String risposta = "";
		for(Traccia t : tracce)
			if(t.getMinuti()==minimo())
				risposta += t.getTitolo() + "\n";
		return risposta;
	}

	public String titoliDurataSufficiente(double duratamassima) {
		String risposta = "";
		for(Traccia t : tracce)
			if(t.getMinuti() <= duratamassima)
				risposta += t.getTitolo() + "\n";
		return risposta;
	}
	
	public String stampaTracce() {
		String risposta = "";
		for(Traccia t : tracce)
			risposta += t.toString() + "\n---------------------------\n";
		return risposta;
	}

	@Override
	public String toString() {
		return "Titolo=" + titolo +
				"\nEtichetta=" + etichetta +
				"\nCosto=" + costo +
				"\nDurata()=" + durata() + "\n---------------------------\n"+
				"\nTracce: " + stampaTracce();
	}
	
	
	
	
	
	
	
	
	
	

//	listaTracce(String artista)
//	minutaggioMinimo()
//	minutaggioMassimo()
//	listaTraccePiuBrevi()
//	listaTraccePiuLunghe()
//	ricerca(String artista, String titoloTracciaAncheParziale) //questo metodo ritorna una lista di Tracce
	
	
	


}
