package generation.common.view.entities;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.io.File;

//sono troppo generico per dare i template
public class BasicView<E> implements EntityView
{
	Map<String,String> templates = new HashMap<String,String>();
	
	
	public BasicView(String templateFile)
	{
		Scanner scanner;
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


	@Override
	public Map<String,String> getTemplates() 
	{
		return templates;
	}
	
	
	

	
}