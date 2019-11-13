package dao;
import java.util.List;

import entities.Product;

/**
 * Contratto per i Product DAO
 * vale a dire per TUTTI i componenti che leggeranno
 * e scriveranno prodotti
 * @author Piero
 *
 */
public interface ProductDAO 
{
	/**
	 * Carica dal db il prodotto con id specificato
	 * @param id
	 * @return il prodotto selezionato, null altrimenti
	 */
	Product load(int id);
	
	/**
	 * salva un prodotto sul db.
	 * Crea una riga nuova, se non c'era.
	 * Se c'era, aggiorna la vecchia.
	 * @param product
	 * @return
	 */
	boolean save(Product product);
	
	/**
	 * cancello il prodotto con l'id relativo
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	
	/**
	 * restituisce una lista di oggetti
	 * @return
	 */
	List<Product> list();
	
}