package com.generation.common.controllerkeyboard;

import com.generation.common.view.language.Language;

//Questo è il mio I2, l'interfaccia a cui voglio arrivare
//partendo da Scanner
public interface Keyboard 
{
	String readLine(String msg);
	
	int readInt(String msg, int min, int max, String errMsg);
	
	double readDouble(String msg, double min, double max, String errMsg);
	
	String readLine(String msg, String[] validvalues, String errMsg);
	
	//Potrebbe essere null.
	Language getLanguage();
	
	void close();

	void setLanguage(Language language);
}