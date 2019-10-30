package entities;

import java.util.List;

public interface IUtilities {
	// proprietà di classe e metodi di validazione classe
	
	static int maxPrez;
	static int minPrez;
	static int mingiri;
	static int maxgiri;
	static int mincap;
	static int maxcap;
	static String[] programVal;
	static String CPUValide;
	static String RAMValide;
	static String MMAValide;
	static int RAMMin;
	static int RAMMax;
	static int MMAMin ;
	static int MMAMax;
	static int minPeso = 10;
	static int pesoMax = 7000;
	static int maxPollici = 31;
	static int minPollici = 3;
	static int maxBat = 100;
	static int minBat = 0;
	static String[] valJack = {"si", "no"};
	static double megamin = 0.2;
	static double megamax = 105;
	static String[] reti = {"E","H+","G","3G","4G","4G+","5G"};
	static String[] costo5 = {"4G","4G+","5G"};
	
	static boolean isPrezzobaseValido(String val) {
		try {
			return Double.parseDouble(val) >= minPrez && Double.parseDouble(val) <= maxPrez;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in double");
			return false;
		}
	}

	public static boolean isCpu(String modello) {		//Non ancora perfetto.. ",i5" considerato come valore valido
		return CPUValide.indexOf(modello.toLowerCase()) >= 0 && !modello.contains(",");
	}
	
	public static boolean isMMA(String modello, String val) {
		try {
			int mma = Integer.parseInt(val);
			return 	MMAValide.indexOf(modello.toLowerCase()) >= 0 && modello.length() == 3 
					&& (mma >= MMAMin && mma <= MMAMax);
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in integer");
			return false;
		}
	}
	
	public static boolean isRAM(String modello, String val) {
		try {
			int ram = Integer.parseInt(val);
			return 	RAMValide.indexOf(modello.toUpperCase()) >= 0 
					&& ram >= RAMMin && ram <= RAMMax;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in integer");
			return false;
		}
	}
	
	public static boolean isBatteria(double val) {
		return 	(val >= minBat && val <= maxBat);
	}
	
	public static boolean isPollici(double val) {
		return 	(val >= minPollici && val <= maxPollici);
	}
	
	public static boolean isPeso(double val) {
		return 	(val >= minPeso && val <= pesoMax);
	}
	
	public static boolean isMegapixel(double mega) {
		return mega >= megamin && mega <= megamax;
	}

	public static boolean isRete(String rete) {
		for(String s : reti)
			if(s.equalsIgnoreCase(rete))
				return true;
		return false;
	}
	
	public static boolean isJack(String jack) {
		for(String s : valJack)
			if(s.equalsIgnoreCase(jack))
				return true;
		return false;
	}
	
	public static boolean isGiriminuto(String val) {
		try {
			int giri = Integer.parseInt(val);
			return giri >= mingiri && giri <= maxgiri;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in ineger");
			return false;
		}
	}

	public static boolean isCapchili(String val) {
		try {
			int c = Integer.parseInt(val);
			return c >= mincap && c <= maxcap;
		} catch(NumberFormatException n) {
			System.out.println(val + "non è un valore parsabile in integer");
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
				case "girimin":
					mingiri = Integer.parseInt(s.split(":")[1]);
				break;
				case "girimax":
					maxgiri = Integer.parseInt(s.split(":")[1]);
				break;
				case "kgmin":
					mincap = Integer.parseInt(s.split(":")[1]);
				break;
				case "kgmax":
					maxcap = Integer.parseInt(s.split(":")[1]);
				break;
				case "programVal":
					programVal = (s.split(":")[1]).split(",");
				break;
				case "cpuvalide":
					CPUValide = (s.split(":")[1]);
				break;
				case "ramvalide":
					RAMValide = (s.split(":")[1]);
				break;
				case "mmavalide":
					MMAValide = (s.split(":")[1]);
				break;
				case "remminimavalida":
					RAMMin = Integer.parseInt(s.split(":")[1]);
				break;
				case "rammaxvalida":
					RAMMax = Integer.parseInt(s.split(":")[1]);
				break;
				case "mmaminvalida":
					MMAMin = Integer.parseInt(s.split(":")[1]);
				break;
				case "mmamaxvalida":
					MMAMax = Integer.parseInt(s.split(":")[1]);
				break;
			}
	}
	
	
	
}
