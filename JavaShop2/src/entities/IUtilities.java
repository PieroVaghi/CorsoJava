package entities;

public interface IUtilities {
	// proprietà di classe e metodi di validazione classe

	
	static boolean isValoreCompresoDouble(String val, double min, double max) {
		try {
			return Double.parseDouble(val) >= min && Double.parseDouble(val) <= max;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in double");
			return false;
		}
	}
	
	static boolean isValoreCompresoInt(String val, int min, int max) {
		try {
			return Integer.parseInt(val) >= min && Integer.parseInt(val) <= max;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in integer");
			return false;
		}
	}

	public static boolean isStringaInVett(String val, String[] vett) {	
		boolean ris = false;
		for(String s : vett)
			if(s.equalsIgnoreCase(val))
					ris = true;
		return ris;
	}

}
