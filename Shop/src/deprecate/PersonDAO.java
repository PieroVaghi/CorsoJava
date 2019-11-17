package deprecate;
import java.util.List;

/**
 * Contratto per i Product DAO
 * vale a dire per TUTTI i componenti che leggeranno
 * e scriveranno prodotti
 * @author Piero
 *
 */
public interface PersonDAO 
{
	/**
	 * Carica dal db il person con id specificato
	 * @param id
	 * @return il prodotto selezionato, null altrimenti
	 */
	Person load(int id);
	
	/**
	 * salva un person sul db.
	 * Crea una riga nuova, se non c'era.
	 * Se c'era, aggiorna la vecchia.
	 * @param product
	 * @return
	 */
	boolean save(Person person);
	
	/**
	 * cancello la person con l'id relativo
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	
	/**
	 * restituisce una lista di person
	 * @return
	 */
	List<Person> list();
	
}