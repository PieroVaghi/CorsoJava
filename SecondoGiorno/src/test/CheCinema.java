package test;

public class CheCinema {

	public static void main(String[] args) {
		
			//VARIABILI SU UTENTE
		String genere = "m";
		String tifoso = "s";
		String giorno = "marted�";
			//VARIABILI CONDIZIONI
		boolean isLun = giorno.equalsIgnoreCase("luned�");
		boolean isMar = giorno.equalsIgnoreCase("marted�");
		boolean isDom = giorno.equalsIgnoreCase("domenica");
		boolean isM = genere.equalsIgnoreCase("m");
		boolean isTifoso = tifoso.equalsIgnoreCase("s");
		
		double prezzo = 9.50;
		
		if((isLun && !isM)||(isMar && isTifoso))
			prezzo = 4.50;
		
//		if(giorno.equalsIgnoreCase("marted�") && isTifoso)
//			prezzo = 4.50;
		
		if(isDom)
			prezzo = 2.90;
		
		String risposta = "Il biglietto costa: " + prezzo + "�";
		
		System.out.println(risposta);
	}

}
