package entities;

public class Prodotto {
	int id;
	String modello, marca;
	double prezzobase;
	
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

	
	public static boolean isValido(String[] riga) {
		return 	isPrezzobaseValido(riga[4]);
				
	}

	private static boolean isPrezzobaseValido(String val) {
		return Integer.parseInt(val) >= 0 && Integer.parseInt(val) <= 1000;
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
