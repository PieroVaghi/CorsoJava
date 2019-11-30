package com.generation.common.view.language;

import java.io.File;
import java.util.Scanner;

public abstract class LanguageFactory 
{
	private static Language dummy = new DummyLanguage();
	
	public static Language make(String filename)
	{
		//sarebbe carino verificare prima che il file esista e in caso contrario dare un 
		//componente di default
		try
		{
			Scanner scanner = new Scanner(new File(filename));
			scanner.close();
			return new BasicLanguage(filename);			
		}
		catch(Exception e)
		{
			return dummy;
		}
	}
	
	public static Language makeXML(String filename,String language)
	{
		//sarebbe carino verificare prima che il file esista e in caso contrario dare un 
		//componente di default
		try
		{
			Scanner scanner = new Scanner(new File(filename));
			scanner.close();
			return new XMLLanguage(filename,language);			
		}
		catch(Exception e)
		{
//			System.out.println("sei in dummy");
			return dummy;
		}
	}
	
}