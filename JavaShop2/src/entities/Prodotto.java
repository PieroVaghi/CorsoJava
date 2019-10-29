package entities;

import java.util.List;

import shop.Negozio;

public class Prodotto implements IUtilities {

	private int id, iddip;
	private String modello, marca;
	private double prezzobase;
	static List<String> limiti = Negozio.limiti;
	/**
	 * @param id
	 * @param modello
	 * @param marca
	 * @param prezzobase
	 */
	public Prodotto(int id, int iddip, String marca, String modello, double prezzobase) {
		this.id = id;
		this.iddip = iddip;
		this.marca = marca;
		this.modello = modello;
		this.prezzobase = prezzobase;
	}

	
	
	public int getIddip() {
		return iddip;
	}

	public void setIddip(int iddip) {
		this.iddip = iddip;
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
		if(IUtilities.isPrezzobaseValido(prezzo+""))
			this.prezzobase = prezzo;
		else
			this.prezzobase = -1;
	}
	
	public static boolean isValido(String[] riga) {
		return 	IUtilities.isPrezzobaseValido(riga[5]);
				
	}

	
	
	public double prezzo() {
		return prezzobase;
	}
	
	
	public String toCSV() {
		return id+","+iddip+","+marca+","+modello+","+prezzobase;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ",\n" + "iddip: " + id + ",\n" + (marca != null ? "marca: " + marca + ",\n" : "") 
				+ (modello != null ? "modello: " + modello + ",\n" : "") + "prezzobase: " + prezzobase;
	}

	
}
