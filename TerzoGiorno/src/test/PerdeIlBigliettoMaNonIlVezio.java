package test;
import java.util.Scanner;

public class PerdeIlBigliettoMaNonIlVezio {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		String resi1 = "Varenna";
		String resi2 = "Vezio";
		String resi3 = "Perledo";
		String prof1 = "Studente";
		String prof2 = "Docente";
		double biglietto = 10.0;
				
		System.out.println("Buongiorno!\nGrazie per aver scelto il nostro sistema di trasporto lacustre!");
		
		System.out.println("In che comune risiede?");
		String residenza = tastiera.nextLine();
		boolean isResidente = residenza.equalsIgnoreCase(resi1)
							||residenza.equalsIgnoreCase(resi2)
							||residenza.equalsIgnoreCase(resi3);
		
		if(!isResidente) {
			
			System.out.println("Quanti hanni ha?");
			int eta = Integer.parseInt(tastiera.nextLine());
			boolean isEtaSconto = eta<5 || eta>70;
			
			System.out.println("Qual'è la sua attuale professione?");
			String professione = tastiera.nextLine();
			boolean isProfSconto = professione.equalsIgnoreCase(prof1)
								||professione.equalsIgnoreCase(prof2);	
			
			if(isEtaSconto)
				biglietto -= 5;
			if(isProfSconto)
				biglietto -= 2;
		} else
			biglietto = 0;
			
		
		String risposta = "Il suo biglietto ha un costo di: " + biglietto + " €!\nBuona Giornata!";
		System.out.println(risposta);
		
		tastiera.close();
	}

}
