package com.generation.shampoo.model.importer;
import java.io.FileNotFoundException;

import com.generation.shampoo.model.entities.Shampoo;

import generation.common.entities.Factory;
import generation.common.importer.Importer;

//questa factory creerà IMPORTER di Shampoo
public class ShampooImporterFactory 
{
	private ShampooImporterFactory(){}
	
	private static ShampooImporterFactory instance = new ShampooImporterFactory();
	
	public static ShampooImporterFactory getInstance() {return instance;}
	
	public Importer<Shampoo> make(String filename, Factory factory) throws FileNotFoundException
	{
		if(filename==null)
			return null;
		if(factory==null)
			return null;
		Importer<Shampoo> res = null;
		if(filename.endsWith(".csv"))
			res =  new ShampooCSVImporter(filename,factory);
		if(filename.endsWith(".map"))
			res =  new ShampooMapImporter(filename,factory);
		return res;
	}
	
	

}