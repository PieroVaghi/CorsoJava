package com.generation.common.xml;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;
import java.util.List;  

//Adapter di Document
public class XMLDocumentImpl implements XMLDocument
{
	//Adaptee
	Document doc;
		
	public XMLDocumentImpl(Document doc) throws Exception
	{
		this.doc = doc;
	}

	@Override
	public List<XMLElement> list(String tagName) throws Exception
	{
		List<XMLElement> res = new ArrayList<XMLElement>();
		NodeList list = doc.getElementsByTagName(tagName);
		for(int i=0;i<list.getLength();i++)
			res.add(new XMLElement((Element) list.item(i)));
		return res;
	}
	
	
	
	
	
}