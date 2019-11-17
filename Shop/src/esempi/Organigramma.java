package esempi;
import entities.*;
import java.util.Map;

import deprecate.Employee;

import java.util.HashMap;

public class Organigramma 
{

	public static void main(String[] args) 
	{
		Map<String, Employee> organigramma = new HashMap<String,Employee>();
		
		java.util.Scanner tastiera = new java.util.Scanner(System.in);
		
		Employee ferdinando = new Employee();
		ferdinando.setName("Ferdinando");
		
		Employee joselyn = new Employee();
		joselyn.setName("Joselyn");
		
		Employee rita = new Employee();
		rita.setName("rita");
		
		
		organigramma.put("teacher", ferdinando);
		organigramma.put("hr", rita);
		organigramma.put("rs", joselyn);
		organigramma.put("writer", ferdinando);
		
		String cmd="";
		
		do
		{
			System.out.println("Inserisci comando");
			cmd = tastiera.nextLine();
			switch(cmd)
			{
				case "find":
					String key = tastiera.nextLine();
					if(organigramma.containsKey(key))
						System.out.println(organigramma.get(key));
					else
						System.out.println("Ruolo non trovato");
					break;
				case "list":
					for(String k:organigramma.keySet())
						System.out.println(k+":"+organigramma.get(k).getName());
					break;
			}
		}while(!cmd.contentEquals("quit"));
		tastiera.close();
		
		
		
		
	}

}