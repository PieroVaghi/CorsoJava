package entities;

public class Lavatrice extends Prodotto {

	private static int mincap = 2;
	private static int maxcap = 15;
	protected int capacitachili;
	
	public Lavatrice(int id, String marca, String modello, double prezzobase) {
		super(id, marca, modello, prezzobase);
		// TODO Auto-generated constructor stub
	}
	
	public int getCapacitachili() {
		return capacitachili;
	}
	
	void setCapacitachili(int capacitachili) {
		if(isCapchili(capacitachili+""))
			this.capacitachili = capacitachili;		
	}
	
	public static boolean isCapchili(String capchili) {
		int c = Integer.parseInt(capchili);
		return c >= mincap && c <= maxcap;
	}
	
	
}
