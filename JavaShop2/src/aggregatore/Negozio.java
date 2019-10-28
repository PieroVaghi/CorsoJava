package aggregatore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Laptop;
import entities.Lavatrice;
import entities.Pc;
import entities.Prodotto;
import entities.Smartphone;

public class Negozio implements INegozio, IAmministrazione {
	
	List<Prodotto> prodotti = new ArrayList<Prodotto>();
	public static List<String> limiti = new ArrayList<String>();
	private double budget;
	
	// COSTRUTTORE ----------------------------------------------------------------------------------------------
	public Negozio(String percorso, double budget) throws Exception {
		Scanner dati = new Scanner(new File(percorso));	
		Scanner conf = new Scanner(new File("src/res/config.txt"));	
		
		while(conf.hasNextLine()) {
			limiti.add(conf.nextLine());
		}
		conf.close();
		
//		prodotti = new Prodotto[npr];
//		int pos = 0;
		
		while(dati.hasNextLine()) {
			Prodotto p = null;
			String[] riga = dati.nextLine().split(",");
			switch(riga[0].toUpperCase()) {
				case "PC":
					if(Pc.isValido(riga)) 
						p = new Pc(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
											riga[5], riga[6], Integer.parseInt(riga[7]), 
											riga[8], Integer.parseInt(riga[9]));
				break;
				case "LAPTOP":
					if(Laptop.isValido(riga)) 
						p = new Laptop(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
										riga[5], riga[6], Integer.parseInt(riga[7]), 
										riga[8], Integer.parseInt(riga[9]),
										Integer.parseInt(riga[10]), Double.parseDouble(riga[11]), Double.parseDouble(riga[12]));
				break;
				case "SMARTPHONE":
					if(Smartphone.isValido(riga))
						p = new Smartphone(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
										riga[5], riga[6], Integer.parseInt(riga[7]), 
										riga[8], Integer.parseInt(riga[9]),
										Integer.parseInt(riga[10]), Double.parseDouble(riga[11]), Double.parseDouble(riga[12]),
										riga[13], Double.parseDouble(riga[14]), riga[15]);
				break;
				case "LAVATRICE":
					if(Lavatrice.isValido(riga)) 
						p = new Lavatrice(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
											Integer.parseInt(riga[5]), Integer.parseInt(riga[6]), riga[7]);
			}
			if(p!=null) {					//Verifico che p sia stato istanziato e in quel caso prendo il vettore alla posizione disponibile e ci carico p
				prodotti.add(p);
			}
		}
		
		this.budget = budget;
		dati.close();
	}
	
	// METODI ---------------------------------------------------------------------------------------------------
	
	
	public List<String> getLimiti() {
		return limiti;
	}
		
	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int nprodotti() {
		return prodotti.size();
	}
	
	public int nlavatrici() {
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Lavatrice)
				cont ++;
		return cont;
	}
	
	public int npc() {
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Pc)
				cont ++;
		return cont - nlaptop() - nsmartphone();
	}
		
	public int nlaptop() {
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Laptop)
				cont ++;
		return cont - nsmartphone();
	}
	
	public int nsmartphone() {
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Smartphone)
				cont ++;
		return cont;
	}
	
	public int nprodottipercpu(String cpu) {	//voglio sapere quanti sono i pc che hanno una cpu uguale a quella segnalata dall'esterno
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Pc)
				if(((Pc)p).getCpu().equalsIgnoreCase(cpu))
					cont ++;
		return cont;
	}
	
	public double totaleprezzi() {
		double tot = 0;
		for(Prodotto p : prodotti)
			tot += p.prezzo();
		return tot;
	}
	
	public double totaleprezzipc() {
		double tot = 0;
		for(Prodotto p : prodotti)
			tot += (p instanceof Pc) ? p.prezzo() : 0;
		return tot;
	}
	
	public double media() {
		return totaleprezzi()/nprodotti();
	}
	
	public double minimo() {	//prezzo più basso
		double min = massimo();
		for(Prodotto p : prodotti)
			if(min > p.prezzo())
				min = p.prezzo();
		return min;
	}
	
	public double massimo() {	//prezzo più alto
		double max = 0;
		for(Prodotto p : prodotti)
			if(max < p.prezzo())
				max = p.prezzo();
		return max;
	} 
	
	public String schede() {	//voglio tutte le schede dei pc
		String risposta = "";
		for(Prodotto p : prodotti)
				risposta += (p!=null) ? p + "\n------------------------------------------\n" : "";
		return risposta;
	}
	
	public String schedepiueconomici() {	//voglio le schede dei pc che costano quanto il minimo
		String risposta = "";
		for(Prodotto p : prodotti)
			risposta += (p.prezzo() == minimo()) ? p + "\n------------------------------------------\n": "" ;
		return risposta;
	}
	
	public String schedepiucostosi() {	//voglio le schede dei pc che costano quanto il massimo
		String risposta = "";
		for(Prodotto p : prodotti)
			risposta += (p.prezzo() == massimo()) ? p + "\n------------------------------------------\n": "" ;
		return risposta;
	} 
	
	public String schedegaming() { //schede di tutti i pc da gaming
		String risposta = "";
		for(Prodotto p : prodotti)
			if(p instanceof Pc)
				risposta += (((Pc)p).isGaming()) ? p + "\n------------------------------------------\n": "" ;
		return risposta;
	}
	
	public String schedeoffice() {	//schede di tutti i pc da ufficio
		String risposta = "";
		for(Prodotto p : prodotti)
			if(p instanceof Pc)
				risposta += (((Pc)p).isOffice()) ? p + "\n------------------------------------------\n": "";
		return risposta;
	}
	
	public String ricerca(int id) { 	//restituire la scheda del prodotto che ha quel determinato id inserito dall'esterno
		String risposta = "";
		for(Prodotto p : prodotti)
			if(p.getId()==id)
				risposta += p;
		return risposta;
	} 
	
	public String ricerca(String cpumassima) {		//restituire le schede dei prodotti che hanno una cpu massima richiesta dall'esterno, ossia, io sto cercando un pc che abbia almeno un "i7", voglio vedere sia le schede degli i3, degli i5 e degli i7
		String risposta = "";
		int cpuVal = cpuVal(cpumassima);
		for(Prodotto p : prodotti)
			if(p instanceof Pc)
				if(((Pc)p).benchCPU() <= cpuVal)
					risposta += p + "\n------------------------------------------\n" ;
		return (!risposta.isEmpty()) ? risposta : "Nessun Pc risponde ai requisiti";
	}

	private int cpuVal(String cpumassima) {
		int cpuVal = 0;
		switch(cpumassima.toLowerCase()) {
			case "i3":
				cpuVal = 1;
			break;
			case "i5":
				cpuVal = 2;
			break;
			case "i7":
				cpuVal = 3;
			break;
			case "i9":
				cpuVal = 4;
			break;
		}
		return cpuVal;
	}
	
	public String ricerca(double prezzomassimo) {		//restituire le schede dei prodotti che hanno al massimo il prezzo richiesto dall'esterno
		String risposta = "";
		for(Prodotto p : prodotti)
			if(p.prezzo() <= prezzomassimo)
				risposta += p + "\n------------------------------------------\n";;
		return risposta;
	}
	
	public List<Prodotto> ricerca (String cpu, int ram, double prezzo){
		List<Prodotto> res = new ArrayList<Prodotto>();
		for(Prodotto p : prodotti)
			if(p instanceof Pc && ((Pc)p).getCpu().equalsIgnoreCase(cpu) && ((Pc)p).getRam() == ram && p.prezzo() == prezzo) 
				res.add(p);
		return res;		
	}
	
	public Prodotto acquista(int id) {
		for(Prodotto p : prodotti)
			if(p.getId() == id) 
				return p;
		return null; 
	}
	
	public boolean vendi (Prodotto p) {
		return prodotti.remove(p);
	}
	
	public boolean aggiungiProdotto (String tipo, int id, String marca, String modello, double prezzo) {
		Prodotto p = null;
		switch(tipo.toUpperCase()) {
			case "PC":
				p = new Pc(id, marca, modello, prezzo, null, null, 0, null, 0);
			break;
			case "LAPTOP":
				p = new Laptop(id, marca, modello, prezzo, null, null, 0, null, 0, 0, 0, 0);
			break;
			case "SMARTPHONE":
				p = new Smartphone(id, marca, modello, prezzo, null, null, 0, null, 0, 0, 0, 0, null, 0, null);
			break;
			case "LAVATRICE":
				p = new Lavatrice(id, marca, modello, prezzo, 0, 0, null);
			break;				
		}
		if( p!=null)
			return prodotti.add(p);
		return false;
	}

	@Override
	public double mediaPrezziPc() {
		double totp = 0;
		for(Prodotto p : prodotti)
			totp += (p instanceof Pc && !(p instanceof Laptop)) ? p.prezzo() : 0;
		return totp/npc();
	}
	
	public double guadagno() {
		return budget + totaleprezzi();
	}
}