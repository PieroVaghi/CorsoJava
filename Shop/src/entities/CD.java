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
	public String toString() 
	{
		return "CD [artist=" + artist + ", genre=" + genre + ", length=" + length + ", getArtist()=" + getArtist()
				+ ", getGenre()=" + getGenre() + ", getLength()=" + getLength() + ", getId()=" + getId()
				+ ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", isAvailable()=" + isAvailable() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
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