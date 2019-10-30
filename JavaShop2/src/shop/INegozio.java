package shop;

import java.util.List;

import entities.IUtilities;
import entities.Prodotto;

public interface INegozio extends IAmministrazione,IUtilities
{
	
	//Interfeccia java 7:
	/*
	 * 	è un tipo astratto che ha il compito di obbligare le classi,
	 *  che la utilizzeranno, a implementare la firma di questi metodi
	 */
	
	
	public int nprodottipercpu(String cpu); //voglio sapere quanti sono i pc che hanno una cpu uguale a quella segnalata dall'esterno
	public int nprodotti();
	public int nlaptop();
	public int npc();
	public int nlavatrici();
	public int nsmartphone();
	public String schede(); //voglio tutte le schede dei pc
	public String schedepiueconomici(); //voglio le schede dei pc che costano quanto il minimo
	public String schedepiucostosi(); //voglio le schede dei pc che costano quanto il massimo
	public String schedegaming(); //schede di tutti i pc da gaming
	public String schedeoffice(); //schede di tutti i pc da ufficio
	public List<Prodotto> ricerca(String cpu, int ram, double prezzo);

}
