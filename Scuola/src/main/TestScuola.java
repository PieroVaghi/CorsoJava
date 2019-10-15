package main;

import java.io.File;
import java.util.Scanner;

import entities.Docente;
import entities.Studente;

public class TestScuola {

	public static void main(String[] args) throws Exception {
		
		Scanner dati = new Scanner(new File("src/res/datiStudenti.txt"));
		int nstudenti = Integer.parseInt(dati.nextLine());
		
		Studente[] studenti = new Studente[nstudenti];
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
		
		Docente[] docenti = new Docente[ndocenti];
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
		
		Scanner datimenu = new Scanner(new File("src/res/menu2.txt"));
		String menu = "";
		while(datimenu.hasNextLine()) {
			menu += datimenu.nextLine() + "\n";
		}
		datimenu.close();
		
		
		Scanner tastiera = new Scanner(System.in);
		int comando = 0;
		
		do {
			System.out.println(menu);
			comando = Integer.parseInt(tastiera.nextLine());
			String risposta = "";
			int cont = 0;
			switch(comando) {
				case 0:
					risposta = "Ciao Bello!";
				break;
				case 1:
					double somma = 0;
					cont = 0;
					risposta = "La media globale di tutti gli studeti è: ";
					for(int i = 0; i < studenti.length; i++) {
						if(studenti[i] != null) {
							somma += studenti[i].media();
							cont++;
						}
					}		
					risposta += somma/cont;
				break;
				case 2:
					risposta = "Gli studenti promossi sono:\n";
					for(int i = 0; i < studenti.length; i++)
						if(studenti[i] != null) {
							if(studenti[i].isPromosso())
								risposta += studenti[i].nome + " " + 
											studenti[i].cognome + "\n";
						}
					if(risposta.endsWith("sono:\n"))
						risposta += "Nessuno è stato promosso quest'anno!";
				break;
				case 3:
					risposta = "Gli studenti bocciati sono:\n";
					for(int i = 0; i < studenti.length; i++)
						if(!studenti[i].isPromosso())
							risposta += studenti[i].nome + " " + 
										studenti[i].cognome + "\n";
					if(risposta.endsWith("sono:\n"))
						risposta += "Nessuno è stato bocciato quest'anno!";
				break;
				case 4:
					risposta = "Gli studenti che andranno in erasmus sono:\n";
					for(int i = 0; i < studenti.length; i++)
						if(!studenti[i].erasmus().equals("Non andrai MAI in erasmus!"))
							risposta += studenti[i].nome + " " + 
										studenti[i].cognome + "\n";
					if(risposta.endsWith("sono:\n"))
						risposta += "Nessuno andrà MAI in erasmus!";
				break;
				case 5:
					risposta = "Elenco Studenti:\n";
					for(int i = 0; i < studenti.length; i++)
						risposta += studenti[i].stampaStudente() + "\n" + 
						"-------------------------------------------------" + "\n";
				break;
				case 6:
					risposta = "Il numero totale degli studenti è: " + studenti.length;
				break;
				case 7:
					risposta = "Il numero totale dei docenti è: " + docenti.length;
				break;
				case 8:
					double sommaD = 0;
					risposta = "La somma totale degli stipendi dei docenti è: ";
					for(int i = 0; i < docenti.length; i++)
						sommaD += docenti[i].stipendio();
					risposta += sommaD + " €";
				break;
				case 9:
					double mediaS = 0;
					cont = 0;
					risposta = "La media degli stipendi dei docenti è: ";
					for(int i = 0; i < docenti.length; i++)
						if(docenti[i] != null) {
							mediaS += docenti[i].stipendio();
							cont++;
						}
					risposta += mediaS/cont;
				break;
				case 10:
					risposta = "Elenco Docenti:\n";
					for(int i = 0; i < docenti.length; i++)
						if(docenti[i] != null)
							risposta += docenti[i].toString() + "\n" + 
									"-------------------------------------------------" + "\n";
				break;
				case 11:
					risposta = "Il numero totale di persone presenti a scuola è: " + (docenti.length + studenti.length);
				break;
				case 12:
					risposta = "Numero materie per docente:\n";
					for(int i = 0; i < docenti.length; i++)
						if(docenti[i] != null) {
							risposta += docenti[i].nome + " " +
										docenti[i].cognome + ": " + docenti[i].nMaterie() + "\n";
						}
				break;
				case 13:
					risposta = "Docenti di informatica:\n";
					for(int i = 0; i < docenti.length; i++)
						if(docenti[i] != null)
							if(docenti[i].materieinsegnate.contains("informatica"))
							risposta += docenti[i].nome + " " +
										docenti[i].cognome + "\n" ;
									
				break;
				default:
					risposta = "Hai inserito un comando non riconosciuto!";
				break;
			
				
			}
			System.out.println(risposta);
		} while (comando != 0);
		
		tastiera.close();
	}

}
