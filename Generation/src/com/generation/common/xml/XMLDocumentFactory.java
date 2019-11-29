package com.generation.common.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

// Factory per la mia Facade XMLDocument
public abstract class XMLDocumentFactory
{
	public static XMLDocument make (String filename)
	{
		try 
		{
			File file = new File(filename);  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();  		
			return new XMLDocumentImpl(doc);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	

}