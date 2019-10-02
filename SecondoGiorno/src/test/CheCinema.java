package test;

public class CheCinema {

	public static void main(String[] args) {

		boolean isGenereM = false;
		boolean isTifoso = true;
		String giorno = "martedi";
		
		double prezzo = 9.50;
		
		if((giorno.equalsIgnoreCase("lunedì") && !isGenereM)||(giorno.equalsIgnoreCase("martedì") && isTifoso))
			prezzo = 4.50;
		
//		if(giorno.equalsIgnoreCase("martedì") && isTifoso)
//			prezzo = 4.50;
		
		if(giorno.equalsIgnoreCase("domenica"))
			prezzo = 2.90;
		
		String risposta = "Il biglietto costa: " + prezzo + "€";
		
		System.out.println(risposta);
	}

}
