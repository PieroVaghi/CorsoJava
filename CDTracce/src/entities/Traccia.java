package entities;


public class Traccia {
	// id, titolo, String[] artisti, minuti
	public int id;
	String titolo;
	double minuti;
	String[] artisti;
	
	public Traccia() {}
	
	public Traccia(int id, String titolo, String artisti, double minuti) {
		this.id = id;
		this.titolo = titolo;
		this.minuti = minuti;
		this.artisti = artisti.split(",");
	}
	
	public int nArtisti () {
		return artisti.length;
	}
	
	public String stampaArtisti() {
		String risposta = "";
		for(String s : artisti)
			risposta += s + " & ";
		return risposta.substring(0,risposta.length()-3);
	}
	
	public String[] getArtisti() {
		return artisti;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public double getMinuti() {
		return minuti;
	}

	@Override
	public String toString() {
		return "Traccia:\nId=" + id + "\nTitolo=" + titolo + "\nMinuti=" + minuti + "\nArtisti=\n"
				+ stampaArtisti();
	}

}
