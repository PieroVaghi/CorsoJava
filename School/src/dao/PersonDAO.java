package dao;

import entities.Person;

/**
 * Contratto per i Person DAO
 * @author Piero
 *
 */
public interface PersonDAO {
	
	/**
	 * Carica dal db la persona con id specificato
	 * @param id
	 * @return la persona selezionata, null altrimenti
	 */
	Person load (int id);
	
	/**
	 * salva una persona sul db.
	 * Crea una riga nuova, se non c'era.
	 * Se c'era, aggiorna la vecchia.
	 * @param person
	 * @return true se va a buon fine
	 */
	boolean save (Person product);
	

}
