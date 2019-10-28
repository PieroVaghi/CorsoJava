package aggregatore;

import java.util.List;

import entities.Dipendente;

public interface IAmministrazione {
	
	public double totaleprezzi();
	public double totalePrezziPc();
	public double media();
	public double minimo();
	public double massimo();
	public double mediaPrezziPc();
	public double guadagno();
	public double stipendi();
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
