package entities;

public class Pc {

	public int id;
	public String marca;
	public String modello;
	public String cpu;
	public String tiporam;
	public String tipomma;
	public int ram;
	public int mma;
	
	/**
	 * @return
	 * � la somma di tutti i costi parziali, se la marca � Ananas il costo raddoppia
	 */
	public String costo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 * il costo dell�i3 � 30, i5 190, i7 300, i9 500
	 */
	public String costocpu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 * il costo della DDR3 � 5 per il numero di GB di ram
	 * il costo della DDR4 � 20 per il numero di GB di ram
	 * il costo della DDR5 � 60 per il numero di GB di ram
	 */
	public String costoram() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 * il costo dell�HDD � 0.1 per il numero di GB di mma
	 * il costo dell�SSD � 1 per il numero di GB di mma
	 */
	public String costomma() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 * la cpu � i5, i7 o i9, il tiporam � DDR4 o DDR5, la ram � almeno 8 GB, e la mma � almeno 128 GB
	 */
	public boolean isGaming() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @return
	 * la mma � di almeno 512 GB e non � da gaming
	 */
	public boolean isOffice() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @return
	 * voglio vedere tutte le caratteristiche definite dalle propriet�
	 * sapere il costo finale
	 * e se � da ufficio o per giocare o nessuno dei due
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
