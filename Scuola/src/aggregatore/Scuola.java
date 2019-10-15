package aggregatore;

import java.io.File;
import java.util.Scanner;

import entities.Docente;
import entities.Studente;

public class Scuola {
	public String indirizzo, nome, tipologia;
	public int capienzastudenti;
	public double budget;
	public Studente[] studenti;
	public Docente[] docenti;
	public String[] aule;
	
	// COSTRUTTORE ---------------------------------------------------------
	public Scuola() throws Exception {
		
		Scanner dati = new Scanner(new File("src/res/datiStudenti.txt"));
		int nstudenti = Integer.parseInt(dati.nextLine());
		
		studenti = new Studente[nstudenti];
		int posizione = 0;
		int contStu = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			contStu++;
			Studente s = new Studente();
			s.nome = riga[0];
			s.cognome = riga[1];
			s.datanascita = riga[2];
			s.genere = riga[3];
			s.mediaita = Double.parseDouble(riga[4]);
			s.mediaing = Double.parseDouble(riga[5]);
			s.mediainf = Double.parseDouble(riga[6]);
			s.mediamat = Double.parseDouble(riga[7]);
			studenti[posizione] = s;
			posizione++;
			if(posizione == studenti.length)
				break;
		}
		
		if(contStu!=studenti.length) {
			System.out.println("Attenzione! Riscontriamo discrepanze nei dati!");
		}
		
		dati.close();
		
		dati = new Scanner(new File("src/res/datiDocenti.txt"));
		int ndocenti = Integer.parseInt(dati.nextLine());
		
		docenti = new Docente[ndocenti];
		posizione = 0;
		int contDoc = 0;
		
		while(dati.hasNextLine()) {
			String[] riga = dati.nextLine().split(",");
			Docente d = new Docente();
			contDoc++;
			d.nome = riga[0];
			d.cognome = riga[1];
			d.datanascita = riga[2];
			d.materieinsegnate = riga[3];
			d.anniesperienza = Integer.parseInt(riga[4]);
			d.stipendiobase = Double.parseDouble(riga[5]);
			docenti[posizione] = d;
			posizione++;
			if(posizione == docenti.length)
				break;
		}
		
		if(contDoc!=docenti.length) {
			System.out.println("Attenzione! Riscontriamo discrepanze nei dati!");
		}
		
		dati.close();
	}
	
	// METODI --------------------------------------------------------------
	
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
	 * Ritorna il numero di totale di persone presenti nella scuola
	 */
	public int numTotale() {
		return numStudenti() + numDocenti();
	}
	
	/**
	 * @return
	 * Ritorna la somma di tutti gli sptipendi dei docenti
	 */
	public double sommaStipendi() {
		double sommaD = 0;
		for(int i = 0; i < docenti.length; i++)
			if(docenti[i]!= null)
				sommaD += docenti[i].stipendio();
		return sommaD;
	}

	/**
	 * @return
	 * Ritorna la media degli stipendi di tutti i professori della scuola
	 */
	public double mediaStipendi() {
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
	 * Ritorna il nome eil cognome dei docenti e del numero di materie per ognuno di loro
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
	
}