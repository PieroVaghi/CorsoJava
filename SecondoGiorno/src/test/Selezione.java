package test;

public class Selezione 
{

	public static void main(String[] args) 
	{
		String patente = "Si";
		int eta = 25;
		String risposta = "Tu.. Non puoi.. Guidare!!!";
		
		if(eta >= 18 && patente.equalsIgnoreCase("si"))
		{
			risposta = "Guida! Sciocco!";
		}
		System.out.println(risposta);
		
	}

}
