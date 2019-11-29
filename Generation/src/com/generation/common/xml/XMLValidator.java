package com.generation.common.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


public abstract class XMLValidator 
{

	public static boolean validate(String xmlfile, String xsdfile) throws Exception
	{
        Schema schema;
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schema = factory.newSchema(new File(xsdfile));
	    Validator validator = schema.newValidator();
	    validator.validate(new StreamSource(new File(xmlfile)));
	    return true;
	}
	
	
}