package entities;

public class Prodotto {
	private int id;
	private String modello, marca;
	private double prezzobase;
	
	/**
	 * @param id
	 * @param modello
	 * @param marca
	 * @param prezzobase
	 */
	public Prodotto(int id, String marca, String modello, double prezzobase) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.prezzobase = prezzobase;
	}

	public int getId() {
		return id;
	}

	public String getModello() {
		return modello;
	}

	public String getMarca() {
		return marca;
	}

	public double getPrezzobase() {
		return prezzobase;
	}

	public void setId (int id) {
		this.id = id;
	}
	
	public void setMarca (String marca) {
		this.marca = marca;
	}
	public void setModello (String modello) {
		this.modello = modello;
	}
	public void setPrezzobase (double prezzo) {
		if(isPrezzobaseValido(prezzo+""))
			this.prezzobase = prezzo;
		else
			this.prezzobase = -1;
	}
	
	public static boolean isValido(String[] riga) {
		return 	isPrezzobaseValido(riga[4]);
				
	}

	private static boolean isPrezzobaseValido(String val) {
		return Double.parseDouble(val) >= 0 && Double.parseDouble(val) <= 1000;
	}
	
	public double prezzo() {
		return prezzobase;
	}
	
	public String toCSV() {
		return id+","+marca+","+modello+","+prezzobase;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ",\n" + (marca != null ? "marca: " + marca + ",\n" : "") 
				+ (modello != null ? "modello: " + modello + ",\n" : "") + "prezzobase: " + prezzobase;
	}
	
}
