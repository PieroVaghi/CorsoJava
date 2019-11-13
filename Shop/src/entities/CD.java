package entities;

public class CD extends Product {

	private String artist, genere;
	private int length;
	public CD() {}
	/**
	 * @param artist
	 * @param genere
	 * @param length
	 */
	public CD(String artist, String genere, int length) {
		super();
		this.artist = artist;
		this.genere = genere;
		this.length = length;
	}
	public String getArtist() {
		return artist;
	}
	public String getGenere() {
		return genere;
	}
	public int getLength() {
		return length;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return super.toString() + (artist != null ? "artist: " + artist + ",\n" : "") + (genere != null ? "genere: " + genere + ",\n" : "")
				+ "length: " + length;
	}
	
}
