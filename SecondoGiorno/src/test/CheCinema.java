package test;

public class CheCinema {

	public static void main(String[] args) {
		
			//VARIABILI SU UTENTE
		String genere = "f";
		String tifoso = "s";
		String giorno = "domenica";
			//VARIABILI CONDIZIONI
		boolean isLun = giorno.equalsIgnoreCase("lunedì");
		boolean isMar = giorno.equalsIgnoreCase("martedì");
		boolean isDom = giorno.equalsIgnoreCase("domenica");
		boolean isM = genere.equalsIgnoreCase("m");
		boolean isTifoso = tifoso.equalsIgnoreCase("s");
		
		double prezzo = 9.50;
		double sconto1 = 5;
		double sconto2 = 6.60;
		
		if((isLun && isM)||(isMar && isTifoso))
			prezzo = prezzo - sconto1;
		
		if(isDom)
			prezzo = prezzo - sconto2;
		
		String risposta = "Il biglietto costa: " + prezzo + " €";
		
		System.out.println(risposta);
	}

}
