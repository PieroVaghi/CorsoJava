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

//Facade per:
//DocumentBuilderFactory, DocumentBuilder,Document, NodeList, Element
public class XMLDocumentImpl implements XMLDocument
{
	String xmlfile;

		
	public XMLDocumentImpl(String xmlfile) 
	{
		this.xmlfile = xmlfile;
	}



	@Override
	public List<XMLElement> list(String tagName) throws Exception
	{
		List<XMLElement> res = new ArrayList<XMLElement>();
		File file = new File(xmlfile);  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  		
		
		//Cosa è doc? Un document XML per la libreria standard
		
		//Nodelist = la versione bruttissima di List<XMLElement>
		NodeList list = doc.getElementsByTagName(tagName);
		
		//La devo trasformare nei miei bellissimi XML Element
		
		for(int i=0;i<list.getLength();i++)
			res.add(new XMLElement((Element) list.item(i)));
		
		return res;
		
	}
	
	
	
	
	
}