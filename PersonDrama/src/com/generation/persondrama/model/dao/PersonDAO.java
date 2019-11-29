package com.generation.persondrama.model.dao;

import java.util.List;

import com.generation.common.model.dao.EntityDAO;
import com.generation.common.model.dao.FlatEntityDAO;
import com.generation.persondrama.model.entities.*;


/**
 * Il caricamento dei prodotti non può essere generalizzato agevolmente ad ora.
 * Mi serve un oggetto di dominio, non uno generico
 * mi serve un oggetto in grado di caricare entità non piatte
 * e che sappia il rapporto fra prodotto e recensione
 * quindi ho informazioni di dominio.
 * e ricordatevi del valhalla quando mi chiamerete perchè non vi ricordate
 * cosa fa questo componente e non avrete letto il Javadoc e io 
 * andrò a prendere un caffè lasciandovi nei guai.
 * Questo sarà un PROXY, vale a dire, implementerà la stessa interfaccia di FlatEntityDAO
 * ma aggiungerà funzioni
 * @author Ferdinando - Piero Copia
 */
public class PersonDAO implements EntityDAO<Person>
{
	//Oggetto proxato
	FlatEntityDAO<Person> real;

	// oggetto accessorio
	FlatEntityDAO<Drama> flatDramaDAO;

	
	
	public PersonDAO(FlatEntityDAO<Person> real, FlatEntityDAO<Drama> flatDramaDAO) 
	{
		this.real = real;
		this.flatDramaDAO = flatDramaDAO;
	}

	@Override
	public Person load(int id) throws Exception 
	{
		//Ho caricato il prodotto ma SENZA recensioni
		// Person person = real.load(id);
		//Devo aggiungere le recensioni
		//flatDramaDAO.list("personid="+id) -> TUTTE LE RECENSIONI COLLEGATE
		// pmployee.setDrama(flatDramaDAO.list("personid="+id));
		return real.load(id).setDramas(_loadDramas(id));	
	}

	@Override
	public List<Person> list() throws Exception 
	{
		return list(" 1=1 ");
	}

	private List<Drama> _loadDramas(int personid) throws Exception
	{
		return flatDramaDAO.list("personid="+personid);
	}
	
	@Override
	public List<Person> list(String condition) throws Exception 
	{
		List<Person> res = real.list(condition);
		//per ogni prodotto collego le sue recensioni
		for(Person p:res)
			p.setDramas(_loadDramas(p.getId()));
//		System.out.println(res);
		return res;
	
	}

	@Override
	public boolean delete(int id) throws Exception 
	{
		return real.delete(id);
	}

	@Override
	public boolean save(Person e) throws Exception 
	{
		//Salviamo la parziale
		boolean res = real.save(e);
		//e ora devo salvare n recensioni
		for(Drama drama:e.getDramas())
			res &= flatDramaDAO.save(drama);
		
		return res;
		
	}

}