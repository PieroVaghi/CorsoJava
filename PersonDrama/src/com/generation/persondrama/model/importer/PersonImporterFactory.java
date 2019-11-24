package com.generation.persondrama.model.importer;
import java.io.FileNotFoundException;

import com.generation.persondrama.model.entities.Person;

import generation.common.entities.Factory;
import generation.common.importer.Importer;

//questa factory creerà IMPORTER di Person
public class PersonImporterFactory 
{
	private PersonImporterFactory(){}
	
	private static PersonImporterFactory instance = new PersonImporterFactory();
	
	public static PersonImporterFactory getInstance() {return instance;}
	
	public Importer<Person> make(String filename, Factory factory) throws FileNotFoundException
	{
		if(filename==null)
			return null;
		if(factory==null)
			return null;
		Importer<Person> res = null;
		if(filename.endsWith(".csv"))
			res =  new PersonCSVImporter(filename,factory);
//		if(filename.endsWith(".map"))
//			res =  new PersonMapImporter(filename,factory);
//		if(filename.endsWith(".txt"))
//			res =  new PersonTXTImporter(filename,factory);
		return res;
	}
	
	

}