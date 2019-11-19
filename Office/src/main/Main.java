package main;

import java.net.SocketTimeoutException;
import java.util.List;

import generation.office.context.Context;
import generation.office.entities.Employee;
import generation.office.statistics.Statistics;
import generation.office.insert.CasualInsert;
import generation.office.insert.CasualInsertImplement;
import generation.common.dao.EntityDAO;

public class Main 
{
	private static EntityDAO<Employee> _dao = (EntityDAO<Employee>) Context.getInstance().get("employeedao");
	private static java.util.Scanner keyboard = new java.util.Scanner(System.in);
	private static Statistics _statistics = (Statistics) Context.getInstance().get("statistics");
	
	public static void main(String[] args) 
	{
		String cmd="", res ="";
		do
		{
			System.out.println("Salve, super capo galattico. Cosa può fare per te il tuo ufficio IT oggi?");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "personale":
					try 
					{
						res = _printEmployee(_dao.list());
					} 
					catch (Exception e) 
					{
						res = "";
						e.printStackTrace();
					}					
				break;
				case "ricerca":
					System.out.println("Super capo galattico, cerchi un ruolo particolare? Lascia bianco per visualizzare i risultati su tutti i dipendenti");
					String role = keyboard.nextLine();
					System.out.println("O Super capo galattico, cerchi un genere particolare? Di nuovo, se lasci bianco visualiziamo tutti");
					String gender = keyboard.nextLine();
					
					String cond = " 1 = 1 ";
					if(!role.contentEquals(""))
						cond+=" and role='"+role+"'";
					if(!gender.contentEquals(""))
						cond+=" and gender='"+gender+"'";
					// System.out.println(cond);
					try 
					{
						res = _printEmployee(_dao.list(cond));
					} 
					catch (Exception e) 
					{
						res = "";
						e.printStackTrace();
					}					
					break;					
				case "riepilogo":
					res = "Super Direttore Galattico, gli esperti di B.I. del nostro reparto hanno elaborato questo schema \n"+ _statistics.avgSalaryByProfession().toString();
				break;
				case "generacasual":
					System.out.println("Insert Start id");
					int i = Integer.parseInt(keyboard.nextLine());
					System.out.println("Insert final id");
					int f = Integer.parseInt(keyboard.nextLine());
					res = (_generaCasuali(i,f))?"Completato!":"Caricamento non riuscito";
				break;
				default:
					res = "Hai provato a spegnere e riaccendere?\n";
			}
			System.out.println(res);
			
		}while(!cmd.equals("quit"));
		
		
		

	}

	private static String _printEmployee(List<Employee> list) 
	{
		String res = "";
		for(Employee s:list)
			res+=s+"\n--------------------\n";
		return res;
	}
	
	private static boolean _generaCasuali(int i, int f) {
		CasualInsert ci = new CasualInsertImplement();
			try {
				System.out.print("<");
				for(int j = i; j<=f; j++)
					System.out.print("-");
				System.out.print(">\n<");
				for(Employee p : ci.random(i, f)) {
					System.out.print("-");
					_dao.save(p);
				}
				System.out.println(">");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
		return true;
	}

}