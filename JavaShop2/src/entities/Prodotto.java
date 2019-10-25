package entities;

import java.util.List;

import aggregatore.Negozio;

public class Prodotto {
	private static int maxPrez;
	private static int minPrez;
	private int id;
	private String modello, marca;
	private double prezzobase;
	static List<String> limiti = Negozio.limiti;
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
		config(limiti);
		return 	isPrezzobaseValido(riga[4]);
				
	}

	private static boolean isPrezzobaseValido(String val) {
		return Double.parseDouble(val) >= minPrez && Double.parseDouble(val) <= maxPrez;
	}
	
	public double prezzo() {
		return prezzobase;
	}
	
	public static void config (List<String> l) {
		for(String s : l)
			switch (s.substring(0,s.indexOf(":"))) {
				case "prezzominimoval":
					minPrez  = Integer.parseInt(s.split(":")[1]);
				break;
				case "prezzomassimoval":
					maxPrez  = Integer.parseInt(s.split(":")[1]);
			}
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
