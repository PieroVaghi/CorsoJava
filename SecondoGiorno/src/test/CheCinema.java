package test;

public class CheCinema {

	public static void main(String[] args) {
		boolean isGenereM = true;
		boolean isTifoso = true;
		double prezzo = 9.50;
		String giorno = "domenica";
		
		
		if(giorno.equalsIgnoreCase("lunedì") && !isGenereM)
			prezzo = 4.50;
		if(giorno.equalsIgnoreCase("martedì") && isTifoso)
			prezzo = 4.50;
		if(giorno.equalsIgnoreCase("domenica"))
			prezzo = 2.90;
		
		String risposta = "Il biglietto costa: " + prezzo + "€";
		
		System.out.println(risposta);
	}

}
