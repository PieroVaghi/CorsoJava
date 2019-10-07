package primaSettimana;

import java.util.Scanner;

public class Tris {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		
		boolean isGame = true;
		int cont = 0;
		String gioco;
		
		String vert = "|";
		String orizzontale = "---+---+---";
		String intermezzo = "--------------------------------------------------------------";

		
		String c11 = " ";
		String c12 = " ";
		String c13 = " ";
		String c21 = " ";
		String c22 = " ";
		String c23 = " ";
		String c31 = " ";
		String c32 = " ";
		String c33 = " ";
		
		
		System.out.println("Comincia il gioco");
		
		while (isGame) {
			cont++;
			String coordinata = "";
			String segno;
			System.out.println(intermezzo);
			
			//ASSEGNAZIONE TURNO
			if (cont%2==1) {
				System.out.println("Tocca a X:");
				segno = "X";
			}
			else {
				System.out.println("Tocca a O:");
				segno = "O";
			}
			
			//MOSSA GIOCATORE
			System.out.println("Inserisci la coordinata della colonna: (1-3)");
			coordinata += tastiera.nextLine();
			System.out.println("Inserisci la coordinata della riga: (1-3)");
			coordinata += tastiera.nextLine();
		
			switch (coordinata) {
				case "11":
					if(c11.equals(" "))
						c11 = segno;
				break;
				case "12":
					if(c12.equals(" "))
						c12 = segno;
				break;
				case "13":
					if(c13.equals(" "))
						c13 = segno;
				break;
				case "21":
					if(c21.equals(" "))
						c21 = segno;
				break;
				case "22":
					if(c22.equals(" "))
						c22 = segno;
				break;
				case "23":
					if(c23.equals(" "))
						c23 = segno;
				break;
				case "31":
					if(c31.equals(" "))
						c31 = segno;
				break;
				case "32":
					if(c32.equals(" "))
						c32 = segno;
				break;
				case "33":
					if(c33.equals(" "))
						c33 = segno;
				break;
				default:
					System.out.println("coordinata inserita non valida! Ripetere");
					cont--;
				break;
			}
			
			//DISEGNO CAMPO
			gioco = " " + c11 + " " + vert + " " + c21 + " " + vert + " " + c31 + " " + "\n" +
					orizzontale + "\n" +
					" " + c12 + " " + vert + " " + c22 + " " + vert + " " + c32 + " " + "\n" +
					orizzontale + "\n" +
					" " + c13 + " " + vert + " " + c23 + " " + vert + " " + c33 + " " + "\n";
			System.out.println(gioco);
			
			//CONTROLLO VITTORIA
			int contTriple = 0;
			boolean vinta = false;
			while (contTriple < 8) {		
				switch (contTriple){
					case 0:
						if (c11.equals(c21) && c11.equals(c31) && !c11.equals(" "))
							vinta = true;
					break;
					case 1:
						if (c12.equals(c22) && c12.equals(c32) && !c12.equals(" "))
							vinta = true;
					break;
					case 2:
						if (c13.equals(c23) && c13.equals(c33) && !c13.equals(" "))
							vinta = true;
					break;
					case 3:
						if (c11.equals(c12) && c11.equals(c13) && !c11.equals(" "))
							vinta = true;
					break;
					case 4:
						if (c21.equals(c22) && c21.equals(c23) && !c21.equals(" "))
							vinta = true;
					break;
					case 5:
						if (c31.equals(c32) && c31.equals(c33) && !c31.equals(" "))
							vinta = true;
					break;
					case 6:
						if (c11.equals(c22) && c11.equals(c33) && !c11.equals(" "))
							vinta = true;
					break;
					case 7:
						if (c31.equals(c22) && c31.equals(c13) && !c31.equals(" "))
							vinta = true;
					break;
					default:
					break;	
				}			
				contTriple++;
			}
			
			//USCITA IN CASO DI VITTORIA
			if (vinta) {
				isGame=false;
				System.out.println("CONGRATULAZIONI "+ segno + "!!! HAI VINTO!!!");				
			} else if(cont==9) {
				isGame=false;
				System.out.println("Nulla di fatto.. La partita finisce in parità");	
			}
			
			
		}
		tastiera.close();

	}

}