package enities;

public class Lingua {
	
	private int id, competenza, iddipendente;
	private String nome;
	private double bonus;
	
	

	/**
	 * @param id
	 * @param competenza
	 * @param iddipendente
	 * @param nome
	 * @param bonus
	 */
	public Lingua(int id, int competenza, int iddipendente, String nome, double bonus) {
		super();
		this.id = id;
		this.competenza = competenza;
		this.iddipendente = iddipendente;
		this.nome = nome;
		this.bonus = bonus;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getBonus() {
		return bonus;
	}

	public int getCompetenza() {
		return competenza;
	}

	public int getIddipendente() {
		return iddipendente;
	}

	public void setCompetenza(int competenza) {
		this.competenza = competenza;
	}

	public void setIddipendente(int iddipendente) {
		this.iddipendente = iddipendente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "id: " + id + ",\ncompetenza: " + competenza + ",\niddipendente: " + iddipendente + ",\n"
				+ (nome != null ? "nome: " + nome + ",\n" : "") + "bonus: " + bonus;
	}

	
	
	
	
	

}
