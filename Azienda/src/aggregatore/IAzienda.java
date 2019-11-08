package aggregatore;

import java.util.List;

import enities.Dipendente;
import enities.Lingua;

public interface IAzienda {
	
	// Calcolarli in ORM
	public List<Dipendente> caricaDipendenti();
	public List<Lingua> caricaLingue(); 
	public double totstipendi();
	public double avgstipendi();
	public double minstipendi();
	public double maxstipendi();
	
	public double totstipendiNonORM();
	public double avgstipendiNonORM();
	public double minstipendiNonORM();
	public double maxstipendiNonORM();

	//QUANDO arriverete nel POMERIGGIO, creare la classe Lingua e creare in ogni
		//Dipendente una List<Lingua> con le lingue conosciute dal dipendente
		//caricare correttamente le informazioni sulla lingua: ogni Lingua 
		//dovrebbe avere queste proprietà: id, nome, bonus, competenza E idDipendente
		//in Dipendente creare un metodo caricaLingua(Lingua ling) identico a
		//aggiungiDipendente(Dipendente d) che si trova in Dipartimento
		
}
