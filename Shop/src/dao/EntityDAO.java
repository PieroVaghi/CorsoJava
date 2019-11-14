package dao;

import java.util.List;

public interface EntityDAO <E extends entities.Entity>{
	/**
	 * Carica dal db il person con id specificato
	 * @param id
	 * @return il prodotto selezionato, null altrimenti
	 */
	E load(int id) throws Exception;
	
	/**
	 * salva un person sul db.
	 * Crea una riga nuova, se non c'era.
	 * Se c'era, aggiorna la vecchia.
	 * @param product
	 * @return
	 */
	boolean save(E e) throws Exception;
	
	/**
	 * cancello la person con l'id relativo
	 * @param id
	 * @return
	 */
	boolean delete(int id) throws Exception;
	
	/**
	 * restituisce una lista di person
	 * @return
	 */
	List<E> list() throws Exception;
	
}


