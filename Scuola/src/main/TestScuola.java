package main;

import java.io.File;
import java.util.Scanner;

import aggregatore.Scuola;

public class TestScuola {

	public static void main(String[] args) throws Exception {
		
		//Creo l'oggetto della classe aggregatrice
		Scuola school = new Scuola();
		
		Scanner datimenu = new Scanner(new File("C:\\Users\\utente15\\git\\CorsoJava\\Scuola\\src\\res\\Menu2.txt"));
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
			switch(comando) {
				case 0:
					risposta = "Ciao Bello!";
				break;
				case 1:
					risposta = "La media globale di tutti gli studeti è: " + school.mediaVotiStudenti() + "\n";
				break;
				case 2:
					risposta = "Gli studenti promossi sono:\n" + school.studentiPromossi() + "\n";
				break;
				case 3:
					risposta = "Gli studenti bocciati sono:\n" + school.studentiBocciati() + "\n";
				break;
				case 4:
					risposta = "Gli studenti che andranno in erasmus sono:\n" + school.studentiInErasmus() + "\n";		
				break;
				case 5:
					risposta = "Elenco Studenti:\n\n" + school.stampaStudenti() + "\n";	
				break;
				case 6:
					risposta = "Il numero totale degli studenti è: " + school.numStudenti() + "\n";
				break;
				case 7:
					risposta = "Il numero totale dei docenti è: " + school.numDocenti() + "\n";
				break;
				case 8:
					risposta = "La somma totale degli stipendi mensili dei docenti è: " + school.sommaStipendiDocenti() + " €\n";
				break;
				case 9:
					risposta = "La media degli stipendi mensili dei docenti è: " + school.mediaStipendiDocenti() + "\n";
				break;
				case 10:
					risposta = "Elenco Docenti:\n\n" + school.stampaDocenti() + "\n";					
				break;
				case 11:
					risposta = "Il numero totale di persone presenti a scuola è: " + school.numTotale() + "\n";
				break;
				case 12:
					risposta = "Numero materie per docente:\n" + school.materiePerDocente() + "\n";	
				break;
				case 13:
					risposta = "Docenti di informatica:\n" + school.docentiInformatica() + "\n";
				break;
				case 14:
					risposta = "Quest'anno, la scuola si porta a casa ben:\n" + school.guadagno() + " €\n";
				break;
				case 15:
					risposta = school.isPovery() ? "Siamo poveri :(\n" : "Quest'anno ce la siamo sfangata!\n";
				break;
				case 16:
					risposta = "La percentuale di studenti sul totale della scuola è: " + school.percentualeStudenti() + " %\n";
				break;
				case 17:
					risposta = "Nella nostra scuola:\n" + school.infoErasmus() + "\n";
				break;
				case 18:
					risposta = "La percentuale di studenti promossi sul totale della scuola è: " + school.percentualeStudentiPromossi() + " %\n";
				break;
				case 19:
					risposta = "Personale non docente:\n" + school.ruoloPerPnD() + "\n";
				break;
				case 20:
					risposta = "Personale dirigente:\n" + school.dirigenza() + "\n";
				break;
				case 21:
					risposta = "Numero totale di personale non docente: " + school.numPnD() + "\n";
				break;
				case 22:
					risposta = "La media dei voti di inglese è: " + school.mediainglese() + "\n";
				break;
				case 23:
					risposta = "Il voto più alto di tutta la scuola è: " + school.votopiualto() + "\n";
				break;
				case 24:
					risposta = "Il voto più basso di tutta la scuola è: " + school.votopiubasso() + "\n";
				break;
				case 25:
					risposta = "Lo studente col voto più alto di tutta la scuola è: " + school.dichieilvotopiualto() + "\n";
				break;
				case 26:
					risposta = "Lo studente col voto più basso di tutta la scuola è: " + school.dichieilvotopiubasso() + "\n";
				break;
				case 27:
					risposta = "La media degli stipendi degli impiegati è pari a: " + school.mediastipendiimpiegati() + "\n";
				break;
				case 28:
					risposta = "La media degli stipendi del personale non docente è: " + school.mediaStipendiPnD() + "\n";
				break;
				case 29:
					risposta = "Lo stipendio più alto di tutta la scuola è:" + school.stipendiopiualto() + "\n";
				break;
				case 30:
					risposta = "Lo stipendio più basso di tutta la scuola è:" + school.stipendiopiubasso() + "\n";
				break;
				case 31:
					System.out.println("Inserisci il ruolo che vuoi ricercare:");
					String ruolo = tastiera.nextLine();
					risposta = "La media degli stipendi del personale " + ruolo + " è: " + school.mediastipendiperruolo(ruolo) + "\n";
				break;
				case 32:
					System.out.println("Inserisci il ruolo che vuoi ricercare:");
					ruolo = tastiera.nextLine();
					risposta = "Il personale " + ruolo + " è: " + school.ricerca(ruolo) + "\n";
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