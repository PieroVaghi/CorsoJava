package generation.wh40k.main;
import java.sql.Connection;
import java.util.Scanner;
import generation.wh40k.entities.*;
import generation.common.dao.EntityDAO;
import generation.wh40k.businessintelligence.Statistics;
import generation.wh40k.context.*;

public class Main 
{
	// DEPENDENCIES
	private static Connection _connection 	= (Connection) Context.getInstance().get("connection");
	private static Scanner keyboard 		= new Scanner(System.in); 	
	private static EntityDAO<Unit> _unitdao	= (EntityDAO<Unit>) Context.getInstance().get("unitdao");
	private static Statistics _statistics = (Statistics) Context.getInstance().get("statistics");
	
	public static void main(String[] args) 
	{
	
		// Dovrò poter:
		// stampare elenco dei veicoli
		// stampare elenco dei soldati
		// stampare tutte le unità, veicoli o soldati, presenti in un dato teatro
		// (vale a dire stampare per deployment)
		// calcolare il costo totale dell'esercito stanziato in un dato deployment
		// stampare il nome dei soldati che si devono pensionare
		// un soldato si pensiona dopo 12 mesi di servizio
		// tranne gli ork, i necron e i tyrannids che non si pensionano, muoiono in servizio
		// quindi il loro metodo pensionable è sempre false.
			
		String cmd = "";
		String res = "";
		do
		{
			System.out.println("Insert command");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "vehicles":
					res = _vehicle();
				break;
				case "soldiers":
					res = _soldiers();
				break;
				case "deploymentunit":
					res = _deploymentunit();
				break;
				case "bytheater":
					System.out.println("Insert theater");
					res = _statistics.costByTheater(keyboard.nextLine())+"";
				break;
				case "retriring":
					res = _retiring();
				break;
				default : 
					res = "BAD COMMAND";
				break;
			}
			System.out.println(res);
		}while(!cmd.contentEquals("quit"));
		
		keyboard.close();
		try 
		{
			_connection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
	}

	private static String _vehicle() 
	{
		String res = "";
		try 
		{
			for(Unit p:_unitdao.list())
				if(p instanceof Vehicle)
					res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static String _soldiers() 
	{
		String res = "";
		try 
		{
			for(Unit p:_unitdao.list())
				if(p instanceof Soldier)
					res+=p.toString()+ "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static String _deploymentunit()
	{
		System.out.println("Insert Deployment:");
		String dep = keyboard.nextLine();
		String res = "";
		try 
		{
			for(Unit p:_unitdao.list())
				if(p.getDeployment().equalsIgnoreCase(dep))
					res+=p.toString()+ "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static int _deploymentcost()
	{
		System.out.println("Insert Deployment:");
		String dep = keyboard.nextLine();
		int res = 0;
		try 
		{
			for(Unit p:_unitdao.list())
				if(p.getDeployment().equalsIgnoreCase(dep))
					res+=p.getCost();
		} 
		catch (Exception e) 
		{
			res = -1;
			System.out.println("Problem with your request:"+e.getMessage());
		}
		return res;
	
	}
	
	private static String _retiring() 
	{
		String res = "";
		try 
		{
			for(Unit u:_unitdao.list(" service>=12 and race not in ('ork', 'necro') "))
				if(u instanceof Soldier)
					res+=u.toString()+ "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "";
			e.printStackTrace();
		}
		return res;
	}

	
}