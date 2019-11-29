package com.generation.common.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
	
	public List<XMLElement> contained(String tagName)
	{
		List<XMLElement> res = new ArrayList<XMLElement>();
		NodeList contained = element.getElementsByTagName(tagName);
		for(int i=0;i<contained.getLength();i++)
			res.add(new XMLElement((Element)contained.item(i)));
		return res;
	}
	
	public String getContent()
	{
		return element.getTextContent();
	}
	
	
	
}