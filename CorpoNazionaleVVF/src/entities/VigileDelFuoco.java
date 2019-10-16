package entities;

import java.time.Year;

public class VigileDelFuoco {
	
	public boolean volontario;
	public String nome, cognome, dataNascita;
	public String grado, patente, qualificazioni, comando, distaccamento;
	public int id;
	public int annoDec;

	public int anniDecreto() {
		return (Year.now().getValue() - annoDec);
	}
	
	public boolean isCapoSquadra() {
		if(grado.equalsIgnoreCase("caposquadra")||grado.equalsIgnoreCase("cs"))
			return true;
		else
			return false;
	}
	
	public boolean isAutista() {
		if(patente.equalsIgnoreCase("terzo grado")||patente.equalsIgnoreCase("quarto grado"))
			return true;
		else
			return false;
	}
	
	public String schedaPersonale() {
		String risposta = "SCHEDA PERSONALE:\n";
		risposta += volontario ? "Vigile del Fuoco Volontario\n" : "Vigile del Fuoco\n";
		risposta +=
				"Nome: " 									+ nome			+
				"\nCognome: "								+ cognome		+
				"\nNato il: "								+ dataNascita 	+
				"\nNumero Identificativo: "					+ id			+
				"\nDecretato nell'anno: "					+ annoDec		+
				"\nIn servizio presso il Comando di: "		+ comando 		+
				"\nPresso il distaccamento di: "			+ distaccamento +
				"\nGrado: "									+ grado			+
				"\nIn possesso della patente ministeriale: "+ patente		+
				"\nIn possesso delle seguenti qualifiche: "	+ qualificazioni;
		return risposta;
	}
 
}
