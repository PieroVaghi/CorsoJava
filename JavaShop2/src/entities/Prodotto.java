package entities;

import java.util.Arrays;
import java.util.List;

import shop.Negozio;

public class Prodotto implements IUtilities {

	private int id, iddip;
	private String modello, marca;
	private double prezzobase;
	static List<String> limiti = Negozio.limiti;
	
	static double maxPrez;
	static double minPrez;
	
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
		if(IUtilities.isValoreCompresoDouble(prezzo+"", minPrez, maxPrez))
			this.prezzobase = prezzo;
		else
			this.prezzobase = -1;
	}
	
	public static boolean isValido(String[] riga) {
		try {
			return 	IUtilities.isValoreCompresoDouble(riga[5], minPrez, maxPrez);
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("problemi con la riga: " + Arrays.toString(riga));
			return false;
		}		
	}
	
	public static void config (List<String> l) {
		for(String s : l)
			switch (s.substring(0,s.indexOf(":"))) {
				case "prezzominimoval":
					minPrez = Integer.parseInt(s.split(":")[1]);
				break;
				case "prezzomassimoval":
					maxPrez = Integer.parseInt(s.split(":")[1]);
				break;
			}
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
