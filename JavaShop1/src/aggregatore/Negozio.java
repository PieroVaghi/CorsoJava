package aggregatore;

import entities.Laptop;
import entities.Pc;

public class Negozio {
	
	public double budget;
	public Pc[] pcs;
	public Laptop[] laptops;
	
	public double guadagno() {
		return totalecostipc() + totalecostilaptop();
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
