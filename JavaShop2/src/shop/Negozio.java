package shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Dipendente;
import entities.IUtilities;
import entities.Laptop;
import entities.Lavatrice;
import entities.Pc;
import entities.Prodotto;
import entities.Smartphone;

public class Negozio implements INegozio, IAmministrazione, IUtilities {
	
	List<Prodotto> prodotti = new ArrayList<Prodotto>();
	List<Dipendente> dipendenti = new ArrayList<Dipendente>();
	public static List<String> limiti = new ArrayList<String>();
	private double budget;
	
	// COSTRUTTORE ----------------------------------------------------------------------------------------------
	
	public Negozio(String percorsoProd, String percorsoDip, double budget) {
		caricaDipendenti(percorsoDip);
		caricaProdotti(percorsoProd);
		caricaProdottiIddip();
		this.budget = budget;
	}

	private void caricaDipendenti(String percorsoDip) {
		Scanner dati = null;
		try {
			dati = new Scanner(new File(percorsoDip));
			while(dati.hasNextLine()) {
				String[] riga = dati.nextLine().split(",");	//codice caldo
				try {
					if(Dipendente.isValido(riga)) 
						dipendenti.add(new Dipendente(Integer.parseInt(riga[0]), riga[1], riga[2], riga[3], riga[4], Double.parseDouble(riga[5]), Integer.parseInt(riga[6])));
				} catch (ArrayIndexOutOfBoundsException f) {
					System.out.println(riga + "non ha la lunghezza attesa" + f.getMessage());
				} catch (NumberFormatException n) {
					System.out.println(n.getMessage() + " problemi con un numero per file alla riga " + riga);
				} catch (Exception e) {
					System.out.println(e.getMessage() + " qualcosa non va alla riga: " + riga);
				}
			}
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dati.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	private void caricaProdotti(String percorsoProd) {
		
		Scanner conf = null;
		try {
			conf = new Scanner(new File("src/res/configProdotti.txt"));
			while(conf.hasNextLine()) {
				limiti.add(conf.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conf.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		Scanner dati = null; 
		try {
			dati = new Scanner(new File(percorsoProd));	
			while(dati.hasNextLine()) {
				Prodotto p = null;
				String[] riga = dati.nextLine().split(",");
				try {
					switch(riga[0].toUpperCase()) {
						case "PC":
							if(Pc.isValido(riga)) 
								p = new Pc(Integer.parseInt(riga[1]), Integer.parseInt(riga[2]), riga[3], riga[4], Double.parseDouble(riga[5]),
													riga[6], riga[7], Integer.parseInt(riga[8]), 
													riga[9], Integer.parseInt(riga[10]));
						break;
						case "LAPTOP":
							if(Laptop.isValido(riga)) 
								p = new Laptop(Integer.parseInt(riga[1]), Integer.parseInt(riga[2]), riga[3], riga[4], Double.parseDouble(riga[5]),
												riga[6], riga[7], Integer.parseInt(riga[8]), 
												riga[9], Integer.parseInt(riga[10]),
												Integer.parseInt(riga[11]), Double.parseDouble(riga[12]), Double.parseDouble(riga[13]));
						break;
						case "SMARTPHONE":
							if(Smartphone.isValido(riga))
								p = new Smartphone(Integer.parseInt(riga[1]), Integer.parseInt(riga[2]),riga[3], riga[4], Double.parseDouble(riga[5]),
												riga[6], riga[7], Integer.parseInt(riga[8]), 
												riga[9], Integer.parseInt(riga[10]),
												Integer.parseInt(riga[11]), Double.parseDouble(riga[12]), Double.parseDouble(riga[13]),
												riga[14], Double.parseDouble(riga[15]), riga[16]);
						break;
						case "LAVATRICE":
							if(Lavatrice.isValido(riga)) 
								p = new Lavatrice(Integer.parseInt(riga[1]), Integer.parseInt(riga[2]),riga[3], riga[4], Double.parseDouble(riga[5]),
													Integer.parseInt(riga[6]), Integer.parseInt(riga[7]), riga[8]);
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					System.out.println(riga + "non ha la lunghezza attesa" + f.getMessage());
				} catch (NumberFormatException n) {
					System.out.println(n.getMessage() + " problemi con un numero per file alla riga " + riga);
				} catch (Exception e) {
					System.out.println(e.getMessage() + " qualcosa non va alla riga: " + riga);
				}
				if(p!=null) {					//Verifico che p sia stato istanziato e in quel caso prendo il vettore alla posizione disponibile e ci carico p
					prodotti.add(p);
				}
			}
		} catch(FileNotFoundException f) {
			System.out.println(f.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage() + " Eccezione generica leggendo i dati dei prodotti");
		} finally {
			try {
				dati.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
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
	
	public double totalePrezziPc() {
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
	
	public String ricerca(String cpu) {		//restituire le schede dei prodotti che hanno una cpu massima richiesta dall'esterno, ossia, io sto cercando un pc che abbia almeno un "i7", voglio vedere sia le schede degli i3, degli i5 e degli i7
		String risposta = "";
		int cpuVal = cpuVal(cpu);
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
		switch(tipo.toUpperCase()) {
			case "PC":
				return prodotti.add(new Pc(id, 0, marca, modello, prezzo, null, null, 0, null, 0));
			case "LAPTOP":
				return prodotti.add(new Laptop(id, 0, marca, modello, prezzo, null, null, 0, null, 0, 0, 0, 0));
			case "SMARTPHONE":
				return prodotti.add(new Smartphone(id, 0, marca, modello, prezzo, null, null, 0, null, 0, 0, 0, 0, null, 0, null));
			case "LAVATRICE":
				return prodotti.add(new Lavatrice(id, 0, marca, modello, prezzo, 0, 0, null));			
		}
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
		return budget + totaleprezzi() - stipendi();
	}

	@Override
 	public double stipendiominino() {
		double min = Double.MAX_VALUE;
		for(Dipendente d : dipendenti)
			min = (min > d.stipendio()) ? d.stipendio() : min;
		return min;
	}

	@Override
	public double stipoendiomassimo() {
		double max = 800;
		for(Dipendente d : dipendenti)
			max = (max < d.stipendio()) ? d.stipendio() : max;
		return max;
	}
	
	@Override
	public int ndipendenti() {
		return dipendenti.size();
	}

	@Override
	public int nCapireparti() {
		int cont = 0;
		for(Dipendente d : dipendenti)
			cont += (d.getRuolo().equalsIgnoreCase("caporeparto")) ? 1 : 0;
		return cont;
	}

	@Override
	public Dipendente ricercadip(int id) {
		for(Dipendente d : dipendenti)
			if(d.getId() == id)
				return d;
		return null;
	}

	@Override
	public List<Dipendente> ricercadip(String ruolo) {
		List<Dipendente> ris = new ArrayList<Dipendente>();
		for(Dipendente d : dipendenti)
			if(d.getRuolo().equalsIgnoreCase(ruolo))
				ris.add(d);
		return ris;
	}

	@Override
	public List<Dipendente> ricercadip(String ruolo, double stipendiomassimo) {
		List<Dipendente> ris = ricercadip(ruolo);
		for(int i = 0; i<ris.size(); i++)
			if(ris.get(i).stipendio() > stipendiomassimo) {
				ris.remove(i);
				i --;
			}
		return ris;
	}

	public void caricaProdottiIddip() {
		for(Dipendente d : dipendenti)
				for(Prodotto p : prodotti)
					if(p.getIddip() == d.getId())
						d.aggiungiProdottoGestito(p.getId());
	}
	
	public String stampaProdottiDip(int iddip) {
		String ris = "";
		Dipendente d = ricercadip(iddip);
//			if(d.getId() == iddip)
			if(d!=null)
				for(int i : d.getProdottiGestiti())
					ris += ricerca(i) + "\n-------------------------------\n";
			else
				ris += "Id non trovato";
		return (ris.isEmpty()) ? "Non gestisce nessun prodotto" : ris;
	}
	
	public String stampaGestoreProd(int id) {
		String ris = "";
		for(Dipendente d : dipendenti)
			for(int i : d.getProdottiGestiti())
				ris += (i == id) ? d + "\n-------------------------------\n" :"";
		return ris;
	}

	
	@Override	
	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

}