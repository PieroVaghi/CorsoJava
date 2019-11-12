package dao;

import java.util.List;

import entities.Product;

/**
 * Contratto per i Product DAO
 * vale a dire per tutti i componenti che leggeranno
 * @author Piero
 *
 */

public interface ProductDAO {
	
	/**
	 * Carica dal db il prodotto con id specificato
	 * @param id
	 * @return il prodotto selezionato, null altrimenti
	 */
	Product load (int id);
	
	/**
	 * salva un prodotto sul db.
	 * Crea una riga nuova, se non c'era.
	 * Se c'era, aggiorna la vecchia.
	 * @param product
	 * @return true se va a buon fine
	 */
	boolean save (Product product);
	
	/**
	 * Cancella l'oggetto corrispondente all'id inserito
	 * @param id
	 * @return
	 */
	boolean delete (int id);
	
	/**
	 * Restituisce una lista di oggetti
	 * @return
	 */
	List<Product> list();
}
