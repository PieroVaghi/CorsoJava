package com.generation.common.xml;
import java.util.List;

import org.w3c.dom.Node;  

//Facade sui metodi per gestire XML
public interface XMLDocument 
{
	
	List<XMLElement> list(String tagName) throws Exception;
	
	
	
}