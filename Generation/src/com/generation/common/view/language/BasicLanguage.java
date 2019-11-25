package com.generation.common.view.language;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicLanguage implements Language
{
	Map<String,String> translations = new HashMap<String,String>();
	
	BasicLanguage(String filename)
	{
		try
		{
			Scanner scanner = new Scanner(new File(filename));
			while(scanner.hasNextLine())
			{
				String parts[] = scanner.nextLine().split(":");
				translations.put(parts[0], parts[1]);				
			}
			
			scanner.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String translate(String key) 
	{
		return translations.containsKey(key) ? translations.get(key) : key;
	}
	
	
}