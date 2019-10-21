package aggregatore;

import entities.Traccia;

public class CD {
	//titolo, Traccia[] tracce, etichetta, datapubblicazione, costo
	public String titolo, etichetta, datapublicazione;
	public double costo;
	public Traccia[] tracce;
	
	public CD (String percorso) {
		
	}
	
	public String titoli() {
		String risposta = "Titoli:\n";
//		for (int i = 0; i < tracce.length; i++) {
//			risposta += tracce[i].titolo + "\n";
//		}
		for(Traccia t : tracce)
			risposta += t.titolo + "\n";
		return risposta;
	}
	
	public int totaleNumeroArtisti(){
		int cont = 0;
		for (int i = 0; i < tracce.length; i++) {
			cont += tracce[i].nArtisti();
		}
		return cont;
	}
	
	public double totaleMinutiCd() {
		double min = 0;
		for (int i = 0; i < tracce.length; i++) {
			min += tracce[i].minuti;
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
			for (int j = 0; j < tracce[i].artisti.length; j++) {
				if(tracce[i].artisti[j].equalsIgnoreCase(artista))
					tot ++;
			}
		}
		return tot;
	}
	
	public String nomeTracce(String artista) {
		String risposta = "";
		for (int i = 0; i < tracce.length; i++) {
			for (int j = 0; j < tracce[i].artisti.length; j++) {
				if(tracce[i].artisti[j].equalsIgnoreCase(artista))
					risposta += tracce[i].titolo + "\n";
			}
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
			for (int j = 0; j < tracce[i].artisti.length; j++) {
				if(tracce[i].artisti[j].equalsIgnoreCase(artista)) {
					tracceArt[cont] = tracce[i];
					cont ++;
				}
			}
		}
		return tracceArt;
	}
	
//	public listaTracce() {};
	
	
	

//	listaTracce(String artista)
//	minutaggioMinimo()
//	minutaggioMassimo()
//	listaTraccePiuBrevi()
//	listaTraccePiuLunghe()
//	ricerca(String artista, String titoloTracciaAncheParziale) //questo metodo ritorna una lista di Tracce
	
	
	


}
