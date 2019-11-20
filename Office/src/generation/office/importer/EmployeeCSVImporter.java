package generation.office.importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import generation.office.entities.Employee;
import generation.common.entities.Factory;
import generation.common.entities.FactoryException;
import generation.common.importer.ImportResult;

public class EmployeeCSVImporter implements generation.common.importer.Importer<Employee>
{
	String filename;
	Factory factory;
	
	public EmployeeCSVImporter(String filename, Factory factory) throws FileNotFoundException, NullPointerException
	{
		this.filename = filename;
		this.factory = factory;
		
		if(factory==null)
			throw new NullPointerException("Missing factory! Can't create");
		
		//se ci sarà un errore nell'apertura del file
		//genererà FileNotFoundException
		//che verrà propagata
		Scanner tmp = new Scanner(new File(filename));
		tmp.close();
	}
	
	
	@Override
	public ImportResult<Employee> absorb() 
	{
		ImportResult<Employee> res = new ImportResult<Employee>();
		//se il file non c'era ha dato errore prima		
		int rownum = 0;
		try
		{
			Scanner data = new Scanner(new File(filename));
			while(data.hasNextLine())
			{
				String row = data.nextLine();
				rownum++;
				try
				{
					System.out.println(row);
					Employee single = (Employee) factory.make(_CSVtoMap(row));
					if(single.valid())
						res.getValid().add(single);
					else
						res.getInvalid().add(single);
				}
				catch(FactoryException e)
				{
					res.getErrors().add("ERROR CREATING EMPLOYEE FOR "+rownum+":"+row+":"+e.getMessage());
				}
				
			}					
			data.close();
		}
		catch(FileNotFoundException e)
		{
			//pro forma. Il file dovrebbe esserci.
			//se non c'è, termino male.
			e.printStackTrace();
			return null;
		}
		
		return res;
	}


	private Map<String, String> _CSVtoMap(String row) 
	{
		if(row==null)
			return null;
		
		Map<String,String> res = new HashMap<String,String>();
		
		try
		{
			String[] parts = row.split(",");
			
			res.put("type", parts[0]);
			res.put("id", parts[1]);
			res.put("name", parts[2]);
			res.put("surname", parts[3]);
			res.put("role", parts[4]);
			res.put("salary", parts[5]);
			res.put("gender", parts[6]);
			res.put("dob", parts[7]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return null;			
		}
		return res;
	}


}