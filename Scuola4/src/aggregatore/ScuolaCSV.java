package aggregatore;
import java.io.File;
import java.util.Scanner;

import entities.*;

public class ScuolaCSV {

	Persona[] persone;
					//src/res/.../dati.txt
	public ScuolaCSV(String percorso) throws Exception{
		Scanner dati = new Scanner(new File(percorso));
		
		int npersone = Integer.parseInt(dati.nextLine());
		persone = new Persona[npersone];
		
		int pos = 0;
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			Persona p = null;									// Tipo formale, 
			switch(riga[0].toUpperCase()) {
				case "STUDENTE":
					if(Studente.isValido(riga)) {
						p = new Studente(Integer.parseInt(riga[1]), riga[2], riga[3], riga[4], riga[5], riga[6], riga[7]);
						if(riga.length>8 && riga.length<=12) {
							((Studente)p).mediaita = Double.parseDouble(riga[8]);		
							((Studente)p).mediainf = Double.parseDouble(riga[9]);
							((Studente)p).mediaing = Double.parseDouble(riga[10]);
							((Studente)p).mediamate = Double.parseDouble(riga[11]);
						}
					}				
				break;	
				case "DOCENTE":
					if(Docente.isValido(riga)) {
						p = new Docente(Integer.parseInt(riga[1]), riga[2], riga[3], riga[4], riga[5], riga[6], riga[0], Double.parseDouble(riga[7]), Integer.parseInt(riga[8]), riga[9]);
					}				
				break;
				case "PND":
					if(PnD.isValido(riga)) {
						p = new PnD(Integer.parseInt(riga[1]), riga[2], riga[3], riga[4], riga[5], riga[6], riga[0], Double.parseDouble(riga[7]), Integer.parseInt(riga[8]), riga[9]);
					}				
				break;
			}
			if(p!=null) {
				persone[pos] = p;
				pos ++;
			}
		}
		
		dati.close();
	}
}
