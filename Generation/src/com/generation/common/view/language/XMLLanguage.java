package com.generation.common.view.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.common.xml.XMLDocument;
import com.generation.common.xml.XMLDocumentFactory;
import com.generation.common.xml.*;

public class XMLLanguage implements Language
{
	//La mia facade di ieri
	XMLDocument document;
	String language;
	
	Map<String,String> translations = new HashMap<String,String>();
	List<String> codes = new ArrayList<String>();
	
	public XMLLanguage(String filename, String language) throws Exception
	{
		this.document = XMLDocumentFactory.make(filename);
		this.language = language;
		//attenzione... facade scritta veramente male... dopo va ottimizzata.
		for(XMLElement element:document.list("code"))
			codes.add(element.getContent());
		//mi aspetto di trovare solo un nodo italian o solo un nodo english
		XMLElement languageNode = document.list(language).get(0);
		for(String code:codes)
			translations.put
			(
				code,
				languageNode.contained(code).get(0).getContent()
			);
	}

	@Override
	public String translate(String key)
	{
		return translations.containsKey(key) ? translations.get(key) : key;
	}
	
	
	

}