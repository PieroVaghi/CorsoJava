package com.generation.megacorp.model.dao;

import java.util.List;

import com.generation.common.model.dao.EntityDAO;
import com.generation.common.model.dao.FlatEntityDAO;
import com.generation.megacorp.model.entities.*;


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
public class EmployeeDAO implements EntityDAO<Employee>
{
	//Oggetto proxato
	FlatEntityDAO<Employee> real;

	// oggetto accessorio
	FlatEntityDAO<Certificate> flatCertificateDAO;

	
	
	public EmployeeDAO(FlatEntityDAO<Employee> real, FlatEntityDAO<Certificate> flatCertificateDAO) 
	{
		this.real = real;
		this.flatCertificateDAO = flatCertificateDAO;
	}

	@Override
	public Employee load(int id) throws Exception 
	{
		//Ho caricato il prodotto ma SENZA recensioni
		// Employee employee = real.load(id);
		//Devo aggiungere le recensioni
		//flatCertificateDAO.list("employeeid="+id) -> TUTTE LE RECENSIONI COLLEGATE
		// pmployee.setCertificate(flatCertificateDAO.list("employeeid="+id));
		return real.load(id).setCertificates(_loadCertificates(id));	
	}

	@Override
	public List<Employee> list() throws Exception 
	{
		return list(" 1=1 ");
	}

	private List<Certificate> _loadCertificates(int employeeid) throws Exception
	{
		return flatCertificateDAO.list("employeeid="+employeeid);
	}
	
	@Override
	public List<Employee> list(String condition) throws Exception 
	{
		List<Employee> res = real.list(condition);
		//per ogni prodotto collego le sue recensioni
		for(Employee p:res)
			p.setCertificates(_loadCertificates(p.getId()));
		return res;
	
	}

	@Override
	public boolean delete(int id) throws Exception 
	{
		return real.delete(id);
	}

	@Override
	public boolean save(Employee e) throws Exception 
	{
		//Salviamo la parziale
		boolean res = real.save(e);
		//e ora devo salvare n recensioni
		for(Certificate certificate:e.getCertificates())
			res &= flatCertificateDAO.save(certificate);
		
		return res;
		
	}

}