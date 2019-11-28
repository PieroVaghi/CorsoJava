package com.generation.common.xml;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;

//Adapter di Element della libreria org.w3c.dom.Element
public class XMLElement 
{
	//Adaptee
	Element element;
	
	public XMLElement(Element element)
	{
		this.element = element;
	}
	
	public Map<String,String> getAttributes()
	{
		Map<String,String> res = new HashMap<String,String>();
		
		for(int i=0;i<element.getAttributes().getLength();i++)
			res.put
			(
					element.getAttributes().item(i).getNodeName(),
					element.getAttributes().item(i).getTextContent()
			);
		return res;
	}
	
	public String getContent()
	{
		return element.getTextContent();
	}
	
	
	
}