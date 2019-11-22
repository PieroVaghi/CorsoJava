package generation.common.controller.keyboard;

import generation.common.view.language.Language;

//Questo � il mio I2, l'interfaccia a cui voglio arrivare
//partendo da Scanner
public interface Keyboard 
{
	String readLine(String msg);
	
	String readInt(String msg, int min, int max, String errMsg);
	
	String readLine(String msg, String[] validvalues, String errMsg);
	
	//Potrebbe essere null.
	Language getLanguage();
	
	void close();

	void setLanguage(Language language);
}