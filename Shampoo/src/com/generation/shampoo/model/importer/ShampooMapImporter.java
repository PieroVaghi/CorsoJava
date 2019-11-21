package com.generation.shampoo.model.importer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.generation.shampoo.model.entities.Shampoo;

import generation.common.entities.Factory;
import generation.common.entities.FactoryException;
import generation.common.importer.ImportResult;

public class ShampooMapImporter implements generation.common.importer.Importer<Shampoo>
{
	String filename;
	Factory factory;
	
	public ShampooMapImporter(String filename, Factory factory) throws FileNotFoundException, NullPointerException
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
	public ImportResult<Shampoo> absorb() 
	{
		ImportResult<Shampoo> res = new ImportResult<Shampoo>();
		
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
					Shampoo single = (Shampoo) factory.make(_rowToMap(row));
					if(single.valid())
						res.getValid().add(single);
					else
						res.getInvalid().add(single);
				}
				catch(FactoryException e)
				{
					res.getErrors().add("ERROR CREATING Shampoo FOR "+rownum+":"+row+":"+e.getMessage());
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

	private Map<String, String> _rowToMap(String row)
	{
		if(row==null)
			return null;

		Map<String,String> res = new HashMap<String,String>();
		
		String[] couples = row.split(",");
		
		for(String couple:couples)
		{
			String parts[] = couple.split(":");
			if(parts.length!=2)
				return null;
			res.put(parts[0], parts[1]);
		}
		
		return res;
	}
	

}