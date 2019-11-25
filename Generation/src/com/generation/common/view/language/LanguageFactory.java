package com.generation.common.view.language;

import java.io.File;
import java.util.Scanner;

public abstract class LanguageFactory 
{
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
			return new DummyLanguage();
		}
	}
	
	
}