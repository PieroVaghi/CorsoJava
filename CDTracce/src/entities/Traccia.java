package entities;

import java.util.Arrays;

public class Traccia {
	// id, titolo, String[] artisti, minuti
	public int id;
	public String titolo;
	public double minuti;
	public String[] artisti;
	
	public Traccia(int id, String titolo, String[] artisti, double minuti) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.minuti = minuti;
		this.artisti = artisti;
	}
	
	public int nArtisti () {
		return artisti.length;
	}

	@Override
	public String toString() {
		return "Traccia [id=" + id + ", titolo=" + titolo + ", minuti=" + minuti + ", artisti="
				+ Arrays.toString(artisti) + "]";
	}

}
