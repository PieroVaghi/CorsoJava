package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lavatrice extends Prodotto {
	
	private int capacitachili, girialminuto;
	private List<String> programmi = new ArrayList<String>();
	
	static int mingiri;
	static int maxgiri;
	static int mincap;
	static int maxcap;
	static String[] programVal;

	
	public Lavatrice(int id, int iddip, String marca, String modello, double prezzobase, 
					int capacitachili, int girialminuto, String programmi) {
		super(id, iddip, marca, modello, prezzobase);
		this.capacitachili = capacitachili;
		this.girialminuto = girialminuto;
		setProgrammi(programmi);
	}
	
	public int getGirialminuto() {
		return girialminuto;
	}

	public int getCapacitachili() {
		return capacitachili;
	}
	
	public List<String> getProgrammi() {
		return programmi;
	}

	public void setProgrammi(String program) {
		List<String> programmi = Arrays.asList(program.split("-"));
		for(String s : programmi)
			for(String z: programVal)
				if(s.equalsIgnoreCase(z))
					this.programmi.add(s);
	}

	void setCapacitachili(int capacitachili) {
		if(IUtilities.isValoreCompresoInt(capacitachili+"", mincap, maxcap))
			this.capacitachili = capacitachili;		
	}
	
	public void setGirialminuto(int girialminuto) {
		this.girialminuto = girialminuto;
	}

//	public void setProgrammi(String[] programmi) {
//		int pos = 0;
//		for(String pdv : programmi)
//			for(String pv: programVal)
//				if(pdv.equals(pv))
//				{
//					pos++;
//					break;
//				}
//		this.programmi = new String[pos];
//		pos = 0;
//		for(String pdv : programmi)
//			for(String pv: programVal)
//				if(pdv.equals(pv))
//				{
//					this.programmi[pos] = pdv;
//					pos++;
//					break;
//				}
//	}
	
	public static boolean isValido(String[] riga) {
		config(Prodotto.limiti);
		try {
			return 	Prodotto.isValido(riga)	&&
					IUtilities.isValoreCompresoInt(riga[6], mincap, maxcap)		&&
					IUtilities.isValoreCompresoInt(riga[7], mingiri, maxgiri);
		} catch (ArrayIndexOutOfBoundsException f) {
			System.out.println("problemi con la riga: " + Arrays.toString(riga));
			return false;
		}
	}

	
	
//	public static boolean isProgrammiVal(String programmi) {
//		String[] programVet = programmi.split("-");
//		boolean controllo = false;
//		for(String s : programVet)
//			for(String z : programVal)
//				if(s.equalsIgnoreCase(z))
//					controllo = true;
//		return controllo;
//	}
	
	public static void config (List<String> l) {
		for(String s : l)
			try {
				switch (s.substring(0,s.indexOf(":"))) {
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
				}
			} catch(NumberFormatException n) {
				System.out.println(s.split(":")[1] + "non è un valore parsabile in Integer");
			}
	}
	
	public String stampaProgrammi() {
		String risposta = "";
		for(String s : programmi)
			risposta += s + ", ";
		return risposta.substring(0, risposta.length()-2);
	}
	
	
	
	@Override
	public double prezzo() {
		return super.prezzo();
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Capacitachili: " + capacitachili + ",\nGirialminuto: " + girialminuto + ",\n"
				+ (programmi != null ? "Programmi: " + stampaProgrammi() : "");
	}

	
	
	
	
}
