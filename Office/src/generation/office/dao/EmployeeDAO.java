package generation.office.dao;

import java.util.List;

import generation.common.dao.EntityDAO;
import generation.common.dao.FlatEntityDAO;
import generation.office.entities.*;

public class EmployeeDAO implements EntityDAO<Employee>
{
	private static int MAXSGANCIAMENTO = 20000;
	
	//OGGETTO PROXATO
	FlatEntityDAO<Employee> real;
	
	public EmployeeDAO(FlatEntityDAO<Employee> real)
	{
		this.real = real;		
	}

	@Override
	public Employee load(int id) throws Exception 
	{
		return id>0 ? real.load(id) : null;
	}

	@Override
	public List<Employee> list() throws Exception 
	{
		return real.list();
	}

	@Override
	public List<Employee> list(String condition) throws Exception 
	{
		return real.list(condition);
	}

	@Override
	public boolean delete(int id) throws Exception 
	{
		return id>0 && real.delete(id);
	}

	@Override
	public boolean save(Employee e) throws Exception 
	{
		return 	e.valid() 														&& 
				e.getSalary()<MAXSGANCIAMENTO 									&& 
				real.list("role='"+e.getRole()+"'").size()<1000 	&&
				real.save(e)													;
	}
	

}