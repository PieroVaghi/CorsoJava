package com.generation.finalshop.model.importer;
import java.util.Map;

import com.generation.common.model.importer.*;
import com.generation.common.xml.XMLDocument;
import com.generation.common.xml.XMLElement;
import com.generation.finalshop.model.entities.*;

public class ProductXMLImporter implements Importer<Product> 
{
	//la mia facade di prima!
	XMLDocument document;
	
	public ProductXMLImporter(XMLDocument document)
	{
		this.document = document;
	}

	@Override
	public ImportResult<Product> absorb() 
	{
		ImportResult<Product> res = new ImportResult<Product>();
		try 
		{
			for(XMLElement element:document.list("product"))
			{
				//Prendo gli attributi
				Map<String,String> map = element.getAttributes();
				map.put("description", element.getContent());
				res.getValid().add(ProductFactory.getInstance().makeProduct(map));
			}	
			
			return res;
		} 
		catch (Exception e) 
		{
			res.getErrors().add("roba..");
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
}