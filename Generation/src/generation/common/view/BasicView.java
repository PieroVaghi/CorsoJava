package generation.common.view;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.io.File;

//sono troppo generico per dare i template
public class BasicView<E> implements View
{
	// chiave -> codice della frase
	// valore -> frase tradotta
	Map<String,String> translations = new HashMap<String,String>();
	Map<String,String> templates = new HashMap<String,String>();
	
	
	public BasicView(String translationFile, String templateFile)
	{
		Scanner scanner;
		
		try
		{
			scanner = new Scanner(new File(translationFile));
			while(scanner.hasNextLine())
			{
				String[] parts = scanner.nextLine().split(":");
				if(parts.length==2)
					translations.put(parts[0], parts[1]);				
			}
			
			scanner.close();
			try
			{
				scanner = new Scanner(new File(templateFile));
				while(scanner.hasNextLine())
				{
					String[] parts = scanner.nextLine().split(":");
					if(parts.length==2)
						templates.put(parts[0], parts[1]);				
				}
				
				scanner.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				System.exit(-1);
			}		

			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}		
	}

	@Override
	public String translate(String key)
	{
		return 	translations.containsKey(key) 	?
				translations.get(key)			:
				key								;
	}

	@Override
	public Map<String,String> getTemplates() 
	{
		return templates;
	}
	
	
	

	
}