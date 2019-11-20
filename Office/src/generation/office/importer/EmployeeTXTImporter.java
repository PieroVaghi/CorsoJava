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

public class EmployeeTXTImporter implements generation.common.importer.Importer<Employee>
{
	private static final int _FIELDNUMBERS = 7;
	String filename;
	Factory factory;
	
	public EmployeeTXTImporter(String filename, Factory factory) throws FileNotFoundException, NullPointerException
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
		int cont = 0;
		boolean valid = false;
		try
		{
			Scanner data = new Scanner(new File(filename));
			String csvrow = "";
			while(data.hasNextLine())
			{
				String row = data.nextLine();
				valid = false;
				if(row.equalsIgnoreCase("Employee")) {
					valid = (cont == _FIELDNUMBERS) ? true : false;
					if(!valid) {
						res.getErrors().add(csvrow);
						csvrow="";
					}
					cont = 0;
				} else {
					csvrow += row +",";
					cont++;
				}	
				if(valid) {
					try
					{
						rownum++;
						csvrow = "Employee," + csvrow.substring(0,csvrow.length()-1); 
						Employee single = (Employee) factory.make(_CSVtoMap(csvrow));
						if(single.valid())
							res.getValid().add(single);
						else
							res.getInvalid().add(single);
						csvrow="";
					}
					catch(FactoryException e)
					{
						res.getErrors().add("ERROR CREATING EMPLOYEE FOR "+rownum+":"+csvrow+":"+e.getMessage());
						csvrow="";

					}
				}
				
			}	
			if(cont != _FIELDNUMBERS)
				res.getErrors().add(csvrow);
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
//			for(String s:parts)
//			System.out.println(s+"\n");
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