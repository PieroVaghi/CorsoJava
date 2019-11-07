package enities;

import java.util.ArrayList;
import java.util.List;

public class Dipartimento {
	
	private int id, massimaCapienza;
	private String nome, citta;
	private double budget;
	private List<Dipendente> dipendenti = new ArrayList<Dipendente>();
	
	/**
	 * @param id
	 * @param massimaCapienza
	 * @param nome
	 * @param citta
	 * @param budget
	 */
	public Dipartimento(int id, int massimaCapienza, String nome, String citta, double budget) {
		super();
		this.id = id;
		this.massimaCapienza = massimaCapienza;
		this.nome = nome;
		this.citta = citta;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public int getMassimaCapienza() {
		return massimaCapienza;
	}

	public String getNome() {
		return nome;
	}

	public String getCitta() {
		return citta;
	}

	public double getBudget() {
		return budget;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setMassimaCapienza(int massimaCapienza) {
		this.massimaCapienza = massimaCapienza;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	public boolean aggiungiDipendente(Dipendente d)
	{
		if(!dipendenti.contains(d) && id == d.getIdDipartimento()) {
			for(Dipendente dip : dipendenti)
				if(dip.getId() == d.getId())
					return false;
			return dipendenti.add(d);
		} return false;
	}

	@Override
	public String toString() {
		return "id: " + id + ",\nmassimaCapienza: " + massimaCapienza + ",\n"
				+ (nome != null ? "nome: " + nome + ",\n" : "") + (citta != null ? "citta: " + citta + ",\n" : "")
				+ "budget: " + budget;
	}
	
	

}
