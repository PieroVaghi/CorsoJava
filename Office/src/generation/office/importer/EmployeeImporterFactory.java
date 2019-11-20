package generation.office.importer;
import java.io.FileNotFoundException;

import generation.office.entities.*;
import generation.common.entities.Factory;
import generation.common.importer.Importer;

//questa factory creerà IMPORTER di Employee
public class EmployeeImporterFactory 
{
	private EmployeeImporterFactory(){}
	
	private static EmployeeImporterFactory instance = new EmployeeImporterFactory();
	
	public static EmployeeImporterFactory getInstance() {return instance;}
	
	public Importer<Employee> make(String filename, Factory factory) throws FileNotFoundException
	{
		if(filename==null)
			return null;
		if(factory==null)
			return null;
		Importer<Employee> res = null;
		if(filename.endsWith(".csv"))
			res =  new EmployeeCSVImporter(filename,factory);
		if(filename.endsWith(".map"))
			res =  new EmployeeMapImporter(filename,factory);
		if(filename.endsWith(".txt"))
			res =  new EmployeeTXTImporter(filename,factory);
		return res;
	}
	
	

}