package test;

public class Selezione 
{

	public static void main(String[] args) 
	{
		String patente = "Si";
		int eta = 25;
		String risposta = "Tu.. Non puoi.. Guidare!!!";
		boolean isMaggiorenne = eta>=18;
		
		if(isMaggiorenne && patente.equalsIgnoreCase("si"))
		{
			risposta = "Guida! Sciocco!";
		}
		
		if(isMaggiorenne) {
			risposta = risposta + "\nPuoi votare.\nPuoi vedere i film di Star Wars.\nPuoi farti fare un applauso..";
		}
		
		if(!isMaggiorenne)
		{
			risposta = risposta + "\nForse puoi arrampicarti sugli alberi, e la maggior parte delle volte non è colpa tua..";
		}
			
		System.out.println(risposta);
		
	}

}
