package entities;

public class CD extends Product
{
	private String artist, genre;
	private int length;
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + (artist != null ? "artist: " + artist + ", \n" : "") + (genre != null ? "genre: " + genre + ", \n" : "")
				+ "length: " + length;
	}
	@Override
	public boolean valid()
	{
		return 
				super.valid()			&&
				length>10				&&
				notVoid(genre)			&&
				notVoid(artist)			;
		
	}
	
	
	
}