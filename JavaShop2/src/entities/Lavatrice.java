package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lavatrice extends Prodotto {
	
	private int capacitachili, girialminuto;
	private List<String> programmi = new ArrayList<String>();
	
	

	
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
		if(IUtilities.isCapchili(capacitachili+""))
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
		return 	Prodotto.isValido(riga)	&&
				IUtilities.isCapchili(riga[6]) 	&&
				IUtilities.isGiriminuto(riga[7]) 	;
//				isProgrammiVal(riga[7])	;
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
