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
		boolean isEtaSconto = false;
		boolean isResidente = false;
		boolean isProfSconto = false;
		
		System.out.println("Buongiorno!\nGrazie per aver scelto il nostro sistema di trasporto lacustre!");
		
		System.out.println("In che comune risiede?");
		String residenza = tastiera.nextLine();
		if(residenza.equalsIgnoreCase(resi1)||residenza.equalsIgnoreCase(resi2)||residenza.equalsIgnoreCase(resi3))
			isResidente = true;
		
		if(!isResidente) {
			System.out.println("Quanti hanni ha?");
			int eta = Integer.parseInt(tastiera.nextLine());
			System.out.println("Qual'è la sua attuale professione?");
			String professione = tastiera.nextLine();
			
			if(eta<5 || eta>70)
				isEtaSconto = true;
			if(residenza.equalsIgnoreCase(resi1)||residenza.equalsIgnoreCase(resi2)||residenza.equalsIgnoreCase(resi3))
				isResidente = true;
			if(professione.equalsIgnoreCase(prof1)||professione.equalsIgnoreCase(prof2))
				isProfSconto = true;
			
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
