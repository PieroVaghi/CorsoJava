package aggregatore;

import java.io.File;
import java.util.Scanner;

import entities.Docente;
import entities.PnD;
import entities.Studente;

public class Scuola {
	public String indirizzo, nome, tipologia;
	public int capienzastudenti;
	public double budget;
	public Studente[] studenti;
	public Docente[] docenti;
	public PnD[] pnd;
	public String[] aule;
	
	// COSTRUTTORE ----------------------------------------------------------------------------------------------------------
	public Scuola() throws Exception {
		
		Scanner dati = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\Scuola\\src\\res\\datiStudenti.txt"));
		int nstudenti = Integer.parseInt(dati.nextLine());
		
		studenti = new Studente[nstudenti];
		int posizione = 0;
		int contStu = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			contStu++;
			if(Studente.isValido(riga)) {
				Studente s = new Studente(riga[0], riga[1]);
				s.datanascita = riga[2];
				s.genere = riga[3];
				s.mediaita = Double.parseDouble(riga[4]);
				s.mediaing = Double.parseDouble(riga[5]);
				s.mediainf = Double.parseDouble(riga[6]);
				s.mediamat = Double.parseDouble(riga[7]);
				studenti[posizione] = s;
			}
			posizione++;
			if(posizione == studenti.length)
				break;
		}
		
		if(contStu!=studenti.length) {
			System.out.println("Attenzione! Riscontriamo discrepanze negli studenti!");
		}
		
		dati.close();
		
		dati = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\Scuola\\src\\res\\datiDocenti.txt"));
		int ndocenti = Integer.parseInt(dati.nextLine());
		
		docenti = new Docente[ndocenti];
		posizione = 0;
		int contDoc = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			if(Docente.isValido(riga)) {	
				Docente d = new Docente();
				contDoc++;
				d.nome = riga[0];
				d.cognome = riga[1];
				d.datanascita = riga[2];
				d.materieinsegnate = riga[3];
				d.anniesperienza = Integer.parseInt(riga[4]);
				d.stipendiobase = Double.parseDouble(riga[5]);
				docenti[posizione] = d;
			} 
			posizione++;
			if(posizione == docenti.length)
				break;
		}
		
		if(contDoc!=docenti.length) {
			System.out.println("Attenzione! Riscontriamo discrepanze nei docenti!");
		}
		
		dati.close();
		
		dati = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\Scuola\\src\\res\\datiPnD.txt"));
		int npnd = Integer.parseInt(dati.nextLine());
		
		pnd = new PnD[npnd];
		posizione = 0;
		int contPnD = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			if(PnD.isValido(riga)) {
				PnD p = new PnD();
				contPnD++;
				p.nome = riga[0];
				p.cognome = riga[1];
				p.datanascita = riga[2];
				p.ruolo = riga[3];
				p.anniesperienza = Integer.parseInt(riga[4]);
				p.stipendiobase = Double.parseDouble(riga[5]);
				pnd[posizione] = p;
			}
			posizione++;
			if(posizione == pnd.length)
				break;
		}
		
		if(contPnD!=pnd.length) {
			System.out.println("Attenzione! Riscontriamo discrepanze nei PnD!");
		}
		
		dati.close();
		
		budget = 250000;		// Aumento Budget
	}
	
	// METODI ---------------------------------------------------------------------------------------------------------------
	
	/**
	 * @return
	 * Ritorna la media di tutti i voti di tutti gli studenti
	 */
	public double mediaVotiStudenti() {
		double risposta = 0;
		int cont = 0;
		for(int i = 0; i < studenti.length; i++) {
			if(studenti[i] != null) {
				risposta += studenti[i].media();
				cont++;
			}
		}		
		risposta /= cont;
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome di tutti gli studenti promossi.
	 * Nel caso non ce ne siano ritorna "Nessuno è stato promosso quest'anno!"
	 */
	public String studentiPromossi() {
		String risposta = "";
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i] != null) {
				if(studenti[i].isPromosso())
					risposta += studenti[i].nome + " " + 
								studenti[i].cognome + "\n";
			}
		if(risposta.isEmpty())
			risposta += "Nessuno è stato promosso quest'anno!";
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome di tutti gli studenti bocciati.
	 * Nel caso non ce ne siano ritorna "Nessuno è stato bocciato quest'anno!"
	 */
	public String studentiBocciati() {
		String risposta = "";
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i] != null) {
				if(!studenti[i].isPromosso())
					risposta += studenti[i].nome + " " + 
								studenti[i].cognome + "\n";
			}
		if(risposta.isEmpty())
			risposta += "Nessuno è stato bocciato quest'anno!";
		return risposta;
	}	
	
	/**
	 * @return
	 * Ritorna il nome e il cognome di tutti gli studenti che andranno in erasmus e la loro destinazione.
	 * Nel caso non ce ne siano ritorna "Nessuno andrà MAI in erasmus!"
	 */
	public String studentiInErasmus() {
		String risposta = "";
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i] != null)
				if(!studenti[i].erasmus().equals("Non andrai MAI in erasmus!"))
					risposta += studenti[i].nome + " " + 
								studenti[i].cognome + " " + studenti[i].erasmus() + "\n";
		if(risposta.isEmpty())
			risposta += "Nessuno andrà MAI in erasmus!";
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna l'elenco delle anagrafiche di tutti gli studenti della scuola
	 */
	public String stampaStudenti() {
		String risposta = "";
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i]!= null)
				risposta += studenti[i].stampaStudente() +
				"\n-------------------------------------------------\n";
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il numero di studenti presenti nella scuola
	 */
	public int numStudenti() {
		return studenti.length;
	}
	
	/**
	 * @return
	 * Ritorna il numero di docenti presenti nella scuola
	 */
	public int numDocenti() {
		return docenti.length;
	}
	/**
	 * @return
	 * Ritorna il numero di docenti presenti nella scuola
	 */
	public int numPnD() {
		return pnd.length;
	}
	
	/**
	 * @return
	 * Ritorna il numero di totale di persone presenti nella scuola
	 */
	public int numTotale() {
		return numStudenti() + numDocenti() + numPnD();
	}
	
	/**
	 * @return
	 * Ritorna la somma di tutti gli sptipendi mensili dei docenti
	 */
	public double sommaStipendiDocenti() {
		double sommaD = 0;
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i]!= null)
				sommaD += docenti[i].stipendio();
		return sommaD;
	}
	
	/**
	 * @return
	 * Ritorna la somma di tutti gli sptipendi mensili del personale non docente
	 */
	public double sommaStipendiPnD() {
		double sommaD = 0;
		for(int i = 0; i < pnd.length; i++)
			if(pnd[i]!= null)
				sommaD += pnd[i].stipendio();
		return sommaD;
	}

	/**
	 * @return
	 * Ritorna la media degli stipendi di tutti i professori della scuola
	 */
	public double mediaStipendiDocenti() {
		double risposta = 0;
		int cont = 0;
		for(int i = 0; i < docenti.length; i++) 
			if(docenti[i] != null) {
				risposta += docenti[i].stipendio();
				cont++;
			}
		risposta /= cont;
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna la media degli stipendi di tutto il personale non docente della scuola
	 */
	public double mediaStipendiPnD() {
		double risposta = 0;
		int cont = 0;
		for(int i = 0; i < pnd.length; i++) 
			if(pnd[i] != null) {
				risposta += pnd[i].stipendio();
				cont++;
			}
		risposta /= cont;
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna l'elenco delle anagrafiche di tutti i docenti della scuola
	 */
	public String stampaDocenti() {
		String risposta = "";
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i] != null)
				risposta += docenti[i].toString() + "\n" + 
						"-------------------------------------------------" + "\n";
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna l'elenco delle anagrafiche di tutto il personale non docente della scuola
	 */
	public String stampaPnD() {
		String risposta = "";
		for(int i = 0; i < pnd.length; i++)
			if(pnd[i] != null)
				risposta += pnd[i].toString() + "\n" + 
						"-------------------------------------------------" + "\n";
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome dei docenti e del numero di materie per ognuno di loro
	 */
	public String materiePerDocente() {
		String risposta = "";
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i] != null) {
				risposta += docenti[i].nome + " " +
							docenti[i].cognome + ": " + docenti[i].nMaterie() + "\n";
			}
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome del personale non docente e il ruolo per ognuno di loro
	 */
	public String ruoloPerPnD() {
		String risposta = "";
		for(int i = 0; i < pnd.length; i++)
			if(pnd[i] != null) {
				risposta += pnd[i].nome + " " +
							pnd[i].cognome + ": " + pnd[i].ruolo + "\n";
			}
		return risposta;
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome di tutti i docenti di informatica
	 */
	public String docentiInformatica() {
		String risposta = "";
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i] != null)
				if(docenti[i].materieinsegnate.contains("informatica"))
				risposta += docenti[i].nome + " " +
							docenti[i].cognome + "\n" ;
		return risposta;		
	}
	
	/**
	 * @return
	 * Ritorna il nome e il cognome di tutti i dirigenti
	 */
	public String dirigenza() {
		String risposta = "";
		for(int i = 0; i < pnd.length; i++)
			if(pnd[i] != null)
				if(pnd[i].ruolo.contains("direzione"))
				risposta += pnd[i].nome + " " +
							pnd[i].cognome + "\n" ;
		return risposta;		
	}
	
	/**
	 *  @return
	 *  Ritorna quanto rimane del budget della scuola ogni anno al netto delle spese
	 */
	public double guadagno() {
		double risposta = 0;
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i] != null)
				risposta += docenti[i].stipendioAnnuo();
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i] != null)
				risposta += studenti[i].erasmusCosto();
		for(int i = 0; i < pnd.length; i++)
			if(pnd[i] != null)
				risposta += pnd[i].stipendioAnnuo();
		
		return budget - risposta;		
	}
	
	/**
	 *  @return
	 *  True se il guadagno annuo è minore di 10000€
	 *  False se maggiore
	 */
	public boolean isPovery() {
		return guadagno() < 10000;
	}

	/**
	 *  @return
	 *  Ritorna la percentuale di studenti sulle persone totali della scuola
	 */
	public double percentualeStudenti() {
		return (numStudenti()*100.00)/numTotale();
	}
	
	/**
	 *  @return
	 *  Ritorna il numero di studenti promossi
	 */
	public int numPromossi() {
		int risposta = 0;
		for(int i = 0; i < studenti.length; i++)
			if(studenti[i] != null) {
				if(studenti[i].isPromosso())
					risposta ++;
			};
		return risposta;
	}
	
	/**
	 *  @return
	 *  Ritorna la percentuale di studenti promossi
	 */
	public double percentualeStudentiPromossi() {
		return (numPromossi()*100.00)/numStudenti();
	}
	
	/**
	 * @return
	 * Info su erasmus
	 */
	public String infoErasmus() {
		return "Erasmus in Australia da diitto ad una borsa di studio di 500€\nErasmus a Vancuver da diitto ad una borsa di studio di 300€";
	}
	
	
}