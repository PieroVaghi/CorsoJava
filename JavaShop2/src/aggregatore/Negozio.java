package aggregatore;

import java.io.File;
import java.util.Scanner;

import entities.Laptop;
import entities.Pc;
import entities.Prodotto;

public class Negozio {
	
	double budget;
	Prodotto[] prodotti;
	
	// COSTRUTTORE ----------------------------------------------------------------------------------------------
	public Negozio() throws Exception {
		Scanner dati = new Scanner(new File("src/res/datiPc.txt"));
		int npr = Integer.parseInt(dati.nextLine());
	
		
		prodotti = new Prodotto[npr];
		int pos = 0;
		Prodotto p = null;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			if(riga[0].equalsIgnoreCase("PC")) {
				if(Pc.isValido(riga)) 
					p = new Pc(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
										riga[5], riga[6], Integer.parseInt(riga[7]), 
										riga[8], Integer.parseInt(riga[9]));				
			}
			else
			if(riga[0].equalsIgnoreCase("LAPTOP")) {
				if(Laptop.isValido(riga)) 
					p = new Laptop(Integer.parseInt(riga[1]), riga[2], riga[3], Double.parseDouble(riga[4]),
									riga[5], riga[6], Integer.parseInt(riga[7]), 
									riga[8], Integer.parseInt(riga[9]),
									Integer.parseInt(riga[10]), Double.parseDouble(riga[11]), Double.parseDouble(riga[12]));
			}
			if(p!=null) {					//Verifico che p sia stato istanziato e in quel caso prendo il vettore alla posizione disponibile e ci carico p
				prodotti[pos] = p;
				pos ++;
			}
		}
		
		dati.close();
		budget = 20000;
	}
	
	// METODI ---------------------------------------------------------------------------------------------------
	
	public double getBudget() {
		return budget;
	}
	
	public int nprodotti() {
		return prodotti.length;
	}
	
	public int npc() {
		return nprodotti()-nlaptop();
	}
	
	public int nlaptop() {
		int cont = 0;
		for(Prodotto p : prodotti)
			if(p instanceof Laptop)
				cont ++;
		return cont;
	}
	
	public int nprodottipercpu(String cpu) {	//voglio sapere quanti sono i pc che hanno una cpu uguale a quella segnalata dall'esterno
		int cont = 0;
		for(Prodotto p : prodotti)
			if(((Pc)p).getCpu().equalsIgnoreCase(cpu))
				cont ++;
		return cont;
	}
	
	public double totaleprezzi() {
		double tot = 0;
		for(Prodotto p : prodotti)
			tot += ((Pc)p).prezzo();
		return tot;
	}
	
	public double media() {
		double media = 0;
		for(Prodotto p : prodotti)
			media += ((Pc)p).prezzo();
		return media/nprodotti();
	}
	
	public double minimo() {	//prezzo più basso
		double min = 1000;
		for(Prodotto p : prodotti)
			if(min < ((Pc)p).prezzo())
				min = ((Pc)p).prezzo();
		return min;
	}
	
	public double massimo() {	//prezzo più alto
		double max = 0;
		for(Prodotto p : prodotti)
			if(max > ((Pc)p).prezzo())
				max = ((Pc)p).prezzo();
		return max;
	} 
	
	public String schede() {	//voglio tutte le schede dei pc
		String risposta = "";
		for(Prodotto p : prodotti)
			risposta += ((Pc)p).toString() + "\n------------------------------------------\n";
		return risposta;
	}
	
	public String schedepiueconomici() {	//voglio le schede dei pc che costano quanto il minimo
		String risposta = "";
		double min = minimo();
		for(Prodotto p : prodotti)
			risposta += (((Pc)p).prezzo() == min) ? ((Pc)p).toString() : "" + "\n------------------------------------------\n";
		return risposta;
	}
	
	public String schedepiucostosi() {	//voglio le schede dei pc che costano quanto il massimo
		String risposta = "";
		double max = massimo();
		for(Prodotto p : prodotti)
			risposta += (((Pc)p).prezzo() == max) ? ((Pc)p).toString() : "" + "\n------------------------------------------\n";
		return risposta;
	} 
	
	public String schedegaming() { //schede di tutti i pc da gaming
		String risposta = "";
		for(Prodotto p : prodotti)
			risposta += (((Pc)p).isGaming()) ? ((Pc)p).toString() : "" + "\n------------------------------------------\n";
		return risposta;
	}
	
	public String schedeoffice() {	//schede di tutti i pc da ufficio
		String risposta = "";
		for(Prodotto p : prodotti)
			risposta += (((Pc)p).isOffice()) ? ((Pc)p).toString() : "" + "\n------------------------------------------\n";
		return risposta;
	}
	
	public String ricerca(int id) { 	//restituire la scheda del prodotto che ha quel determinato id inserito dall'esterno
		String risposta = "";
		for(Prodotto p : prodotti)
			if(p.getId()==id)
				risposta += ((Pc)p).toString();
		return risposta;
	} 
	
	public String ricerca(String cpumassima) {		//restituire le schede dei prodotti che hanno una cpu massima richiesta dall'esterno, ossia, io sto cercando un pc che abbia almeno un "i7", voglio vedere sia le schede degli i3, degli i5 e degli i7
		String risposta = "";
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
		for(Prodotto p : prodotti)
			if(((Pc)p).benchCPU() <= cpuVal)
				risposta += ((Pc)p).toString();
		return risposta;
	}
	
	public String ricerca(double prezzomassimo) {		//restituire le schede dei prodotti che hanno al massimo il prezzo richiesto dall'esterno
		String risposta = "";
		for(Prodotto p : prodotti)
			if(((Pc)p).prezzo() <= prezzomassimo)
				risposta += ((Pc)p).toString() + "\n------------------------------------------\n";;
		return risposta;
	}
	
	
}