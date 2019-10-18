package aggregatore;

import java.io.File;
import java.util.Scanner;

import entities.Laptop;
import entities.Pc;

public class Negozio {
	
	public double budget;
	public Pc[] pcs;
	public Laptop[] laptops;
	
	// COSTRUTTORE ----------------------------------------------------------------------------------------------
	public Negozio() throws Exception {
		Scanner dati = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\JavaShop1\\src\\res\\datiPc.txt"));
		String[] dim = dati.nextLine().split(",");
		int npc = Integer.parseInt(dim[0]);
		int nlp = Integer.parseInt(dim[1]);
		
		pcs = new Pc[npc];
		laptops = new Laptop[nlp];
		int posizionePc = 0;
		int posizioneLa = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			if(riga[0].equalsIgnoreCase("PC")) {
				if(Pc.isValido(riga)) {
					Pc p = new Pc(	riga[1], riga[2], riga[3],
									Integer.parseInt(riga[4]),
									riga[5],
									Integer.parseInt(riga[6]));
					pcs[posizionePc] = p;
				}
				posizionePc++;

			} else 
				if(riga[0].equalsIgnoreCase("LAPTOP")) {

						if(Laptop.isValido(riga)) {
							Laptop l = new Laptop(	riga[1], riga[2], riga[3],
													Integer.parseInt(riga[4]),
													riga[5],
													Integer.parseInt(riga[6]),
													Double.parseDouble(riga[7]),
													Double.parseDouble(riga[8]),
													Double.parseDouble(riga[9]));
							laptops[posizioneLa] = l;
						}
						posizioneLa++;

			}
		}
		
		dati.close();
		budget = 20000;
	}
	
	// METODI ---------------------------------------------------------------------------------------------------
	
	public double guadagno() {
		return budget + totalecostipc() + totalecostilaptop();
	}
	
	public double totalecostilaptop() {
		double costo = 0;
		for(int i = 0; i<laptops.length; i++) {
			costo += laptops[i].costo();
		}
		return costo;
	}

	public double totalecostipc() {
		double costo = 0;
		for(int i = 0; i<pcs.length; i++) {
			costo += pcs[i].costo();
		}
		return costo;
	}
	
	public double costomaxp() {
		double costoMax = Double.MIN_VALUE;
		for(int i = 0; i<pcs.length; i++) {
			if(costoMax < pcs[i].costo())
				costoMax = pcs[i].costo();	
		}
		return costoMax;
	}
	
	public double costominp() {
		double costoMin = Double.MAX_VALUE;
		for(int i = 0; i<pcs.length; i++) {
			if(costoMin > pcs[i].costo())
				costoMin = pcs[i].costo();	
		}
		return costoMin;
	}
	
	public String elencopcpercpu(String cpu) {
		String risposta = "";
		for(int i = 0; i<pcs.length; i++) {
			if(pcs[i].cpu.equalsIgnoreCase(cpu))
				risposta += pcs[i].toString() + 
							"\n----------------------------------------\n";	
		}
		return risposta;
	}
}
