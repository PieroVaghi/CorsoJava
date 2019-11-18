package main;

import java.sql.Connection;
import java.sql.SQLException;

import context.Context;
import dao.EntityDAO;
import entities.Unit;
import entities.Vehicle;
import entities.Soldier;

public class Main
{

	
	// DIPENDENZE DEL MAIN 
	private static java.util.Scanner keyboard = new java.util.Scanner(System.in);
	private static Connection connection = (Connection) Context.getInstance().get("connection");
	private static EntityDAO<Unit> unitdao = (EntityDAO<Unit>) Context.getInstance().get("unitdao");
	
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
				case "deploymentcost":
					res = _deploymentcost()+"";
				break;
				case "pensionable":
					res = _pensionable();
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
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
	}

	private static String _vehicle() 
	{
		String res = "";
		try 
		{
			for(Unit p:unitdao.list())
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
			for(Unit p:unitdao.list())
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
			for(Unit p:unitdao.list())
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
			for(Unit p:unitdao.list())
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
	
	private static String _pensionable()
	{
		String res = "";
		try 
		{
			for(Unit p:unitdao.list())
				if(p instanceof Soldier)
					res+= ((Soldier)p).retires() ? p.toString() + "\n-------------------------\n" : "";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}

	
}