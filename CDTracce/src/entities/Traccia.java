package entities;

import java.util.Arrays;

public class Traccia {
	// id, titolo, String[] artisti, minuti
	public int id;
	public String titolo;
	public double minuti;
	public String[] artisti;
	
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
	
	public String[] getArtisti() {
		return artisti;
	}

	@Override
	public String toString() {
		return "Traccia [id=" + id + ", titolo=" + titolo + ", minuti=" + minuti + ", artisti="
				+ Arrays.toString(artisti) + "]";
	}

}
