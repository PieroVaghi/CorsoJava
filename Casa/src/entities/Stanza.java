package entities;

public class Stanza {
	
	// Una classe modello conosce e definisce le proprie caratteristiche --> PROPRIETA' 
	
	// PROPRIETA' DELL'OGGETTO
	public double base;
	public double altezza;
	public String tipo;
	int nFinestre;
	int nPorte;
	
	public double area() {
		return base*altezza;
	}
	
	public String descrizione() {
		String risposta = "";
		if(tipo != null)
			risposta += "Stanza: " 		+ tipo 		+ 
						"\nBase: "		+ base		+ 
						"\nAltezza: "	+ altezza	+ 
						"\nArea: "		+ area();
		else 
			risposta += "Stanza: mancante ";
			
		return risposta;
	}
}
