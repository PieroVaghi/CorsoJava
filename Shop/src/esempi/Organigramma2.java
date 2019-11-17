package esempi;
import entities.*;
import java.util.Map;

import deprecate.Employee;

import java.util.HashMap;

public class Organigramma2 
{

	public static void main(String[] args) 
	{
		Map<String, Employee[]> organigramma = new HashMap<String,Employee[]>();
		
		java.util.Scanner tastiera = new java.util.Scanner(System.in);
		
		Employee ferdinando = new Employee();
		ferdinando.setName("Ferdinando");
		
		Employee joselyn = new Employee();
		joselyn.setName("Joselyn");
		
		Employee rita = new Employee();
		rita.setName("rita");
		
		Employee gloria = new Employee();
		gloria.setName("gloria");
		
		Employee maria = new Employee();
		maria.setName("Maria");
		
		organigramma.put("teacher", new Employee[] {ferdinando, gloria});
		organigramma.put("hr", new Employee[] {rita, maria});
		organigramma.put("rs", new Employee[] {joselyn});
		organigramma.put("writer", new Employee[] {ferdinando});
		
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
					{
						System.out.println("Impiegati per il ruolo "+key);
						for(Employee e:organigramma.get(key))
							System.out.println(e.getName());
					}else
						System.out.println("Ruolo non trovato");
					break;
				case "list":
					for(String k:organigramma.keySet())
						for(Employee e:organigramma.get(k))
							System.out.println(k+":"+e.getName());
					break;
			}
		}while(!cmd.contentEquals("quit"));
		tastiera.close();
		
		
		
		
	}

}