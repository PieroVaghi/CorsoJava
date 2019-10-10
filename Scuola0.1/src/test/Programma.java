package test;

import java.io.File;
import java.util.Scanner;

public class Programma {

	public static void main(String[] args) throws Exception {

		String menuITA = "";
		String percorso = "src/res/menuITA.txt";
		Scanner datiMenu = new Scanner(new File(percorso));
		while(datiMenu.hasNextLine()) {
			menuITA += datiMenu.nextLine() + "\n";
		}
		datiMenu.close();
		System.out.println(menuITA);
		
		
		

	}

}
