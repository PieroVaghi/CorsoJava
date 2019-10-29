package shop;

import java.util.List;

import entities.Dipendente;

public interface IAmministrazione {
	
	public List<Dipendente> getDipendenti();
	
	public double totaleprezzi();
	public double totalePrezziPc();
	public double media();
	public double minimo();
	public double massimo();
	public double mediaPrezziPc();
	public double guadagno();
	
	default public double stipendi() {
		double tot = 0;
		for(Dipendente d : getDipendenti())
			tot += d.stipendio();
		return tot;
	}
	
	
	
	public double stipendiominino();
	public double stipoendiomassimo();
	public int ndipendenti();
	public int nCapireparti();
	public Dipendente ricercadip(int id);
	public List<Dipendente> ricercadip (String ruolo);
	public List<Dipendente> ricercadip (String ruolo, double stipendiomassimo);
	public String stampaProdottiDip(int iddip);
	public String stampaGestoreProd(int id);
	
}
