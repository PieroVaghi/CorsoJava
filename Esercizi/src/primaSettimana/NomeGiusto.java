package primaSettimana;

import java.util.Scanner;

public class NomeGiusto {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		
		String nome;
		String cognome;
		boolean isNomeErrato = false;
		
		do {
			System.out.println("Inserisci il tuo nome: ");
			nome = tastiera.nextLine();
			System.out.println("Inserisci il tuo cognome: ");
			cognome = tastiera.nextLine();
			int letNom = nome.length();
			int letCognom = cognome.length();
			if (letNom<2 || letCognom<2 || letNom >60 || letCognom >60) {
				isNomeErrato = true;
				System.out.println("ATTENZIONE: Sono stati inseriti dati errat!");
			} else isNomeErrato = false;
		} while (isNomeErrato);
		
		String risposta =	"I dati inseriti sono:\n" + 
							"Nome: "	+ nome + "\n" +
							"Cognome: "	+ cognome;
		System.out.println(risposta );
		tastiera.close();
	}

}
