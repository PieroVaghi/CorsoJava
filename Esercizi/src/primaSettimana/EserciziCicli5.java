package primaSettimana;

import java.util.Scanner;

public class EserciziCicli5 {

	public static void main(String[] args) {
		/* 
		 * L'utente inserisce i dati di una classe di n studenti. Per ogni studente memorizziamo nome, voto di italiano, di matematica e di inglese.
		 * Stampare la media di ogni studente,
		 * il numero di studenti promossi (senza insufficienze), 
		 * il numero di studenti con l'insufficienza in matematica e la media di inglese dell'intera classe
		 */
		
		Scanner tastiera = new Scanner(System.in);
		String risposta = "";
		
		int cont = 0;
		double mediaIng = 0;
		int studentiPromossi = 0, insuffMat = 0;
		
		System.out.println("Inserisci il numero di studenti: ");
		int numStudenti = Integer.parseInt(tastiera.nextLine());
		
		while (cont != numStudenti) {
			cont ++;
			System.out.println("Inserisci nome studente: ");
			risposta += "Nome:\t" + tastiera.nextLine() + "\t";
			System.out.println("Inserisci voto di Matematica:");
			int votoMat = Integer.parseInt(tastiera.nextLine());
			System.out.println("Inserisci voto di Italiano:");
			int votoIta = Integer.parseInt(tastiera.nextLine());
			System.out.println("Inserisci voto di Inglese:");
			int votoIng = Integer.parseInt(tastiera.nextLine());
			double mediaStudente = (votoMat + votoIta + votoIng) / 3.0;
			risposta += "Media voti:\t" + mediaStudente + "\n";
			mediaIng += votoIng;
			if (votoIta > 5 && votoIng > 5 && votoMat > 5)
				studentiPromossi ++;
			if (votoMat < 6)
				insuffMat ++;
		}
		
		mediaIng /= numStudenti;
		risposta += "---------------------------------------\n" + 
					"Numero studenti promossi:\t" + studentiPromossi + "\n" +
					"Numero studenti con insufficienza in matematica: " + insuffMat + "\n" +
					"Media di inglese calcolata sull'intera classe:\t " + mediaIng;
		System.out.println(risposta);
		tastiera.close();

	}

}
