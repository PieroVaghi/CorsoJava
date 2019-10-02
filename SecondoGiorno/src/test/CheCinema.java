package test;

public class CheCinema {

	public static void main(String[] args) {
		
			//VARIABILI SU UTENTE
		String genere = "m";
		String tifoso = "s";
		String giorno = "martedì";
			//VARIABILI CONDIZIONI
		boolean isLun = giorno.equalsIgnoreCase("lunedì");
		boolean isMar = giorno.equalsIgnoreCase("martedì");
		boolean isDom = giorno.equalsIgnoreCase("domenica");
		boolean isM = genere.equalsIgnoreCase("m");
		boolean isTifoso = tifoso.equalsIgnoreCase("s");
		
		double prezzo = 9.50;
		
		if((isLun && !isM)||(isMar && isTifoso))
			prezzo = 4.50;
		
//		if(giorno.equalsIgnoreCase("martedì") && isTifoso)
//			prezzo = 4.50;
		
		if(isDom)
			prezzo = 2.90;
		
		String risposta = "Il biglietto costa: " + prezzo + "€";
		
		System.out.println(risposta);
	}

}
