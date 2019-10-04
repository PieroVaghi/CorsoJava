package test;

import java.util.Scanner;

public class Librificio {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		
		double prezzoPag = 0.05;
		double prezzoTot = 0;
		String risposta = "";
		boolean maggiorato = true;
		
		System.out.println("Benvenuto!\nQual'è il titolo del libro che avete selezionato?");
		String titolo = tastiera.nextLine();
		System.out.println("Qual'è l'autore del libro che avete selezionato?");
		String autore = tastiera.nextLine();
		System.out.println("Inserisci il numero di pagine riportato in fondo");
		int pagNum = Integer.parseInt(tastiera.nextLine());
		System.out.println("Infine inserisci il genere letterario a cui appartiene");
		String genere = tastiera.nextLine().toLowerCase();
		
		prezzoTot = prezzoPag * pagNum;
		
		risposta = 	"Scheda Tecnica:\n"	+
					"# Titolo:\t\t"			+ titolo + "\n" +
					"# Autore:\t\t"			+ autore + "\n" +
					"# NPag:\t\t\t"			+ pagNum + "\n" +
					"# Genere:\t\t"			+ genere + "\n" +
					"# Prezzo:\t\t"			+ prezzoTot + " €\n";
		
		switch (genere) {
			case "fantasy":
			case "fantascientifico":
			case "horror":
			case "romantici": 
				prezzoTot *= 1.05;
			break;
			case "biografie":
				prezzoTot *= 1.1;
			break;
			default:
				maggiorato = false;
			break;
		}
		
		if(maggiorato)
			risposta += "# Prezzo maggiorato:\t" + prezzoTot + " €";
		
		System.out.println(risposta);
		
		tastiera.close();
		
	}

}
