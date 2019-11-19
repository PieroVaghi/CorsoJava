package generation.agenziailgriso.main;
import java.sql.Connection;
import java.util.Scanner;
import generation.agenziailgriso.entities.*;
import generation.agenziailgriso.insert.CasualInsert;
import generation.agenziailgriso.insert.CasualInsertImplement;
import generation.common.dao.EntityDAO;
import generation.agenziailgriso.businessintelligence.Statistics;
//import generation.agenziailgriso.businessintelligence.Statistics;
import generation.agenziailgriso.context.*;

public class Main 
{
	// DEPENDENCIES
	private static Connection _connection 	= (Connection) Context.getInstance().get("connection");
	private static Scanner keyboard 		= new Scanner(System.in); 	
	private static EntityDAO<Property> _propertydao	= (EntityDAO<Property>) Context.getInstance().get("propertydao");
	private static Statistics _statistics = (Statistics) Context.getInstance().get("statistics");
	
	
	public static void main(String[] args) 
	{
			
		String cmd = "";
		String res = "";
		do
		{
			System.out.println("Insert command");
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "apartment":
					res = _apartment();
				break;
				case "advancedapartment":{
					System.out.println("Insert number of room");
					int r = Integer.parseInt(keyboard.nextLine());
					System.out.println("Insert number of bathroom");
					int b = Integer.parseInt(keyboard.nextLine());
					System.out.println("Insert max value");
					int v = Integer.parseInt(keyboard.nextLine());					
					res = _advancedApartment(r,b,v);
				}
				break;
				case "advanceshop":{
					System.out.println("Insert max value");
					int v = Integer.parseInt(keyboard.nextLine());
					res = _advancedShop(v);
				}
				break;
				case "edificableground":{
					res = _edificableground();
				}
				break;
				case "avgzone":
					System.out.println("Insert zone");
					res = _statistics.avgCostByZone(keyboard.nextLine())+"";
				break;
				case "trafficshop":
					System.out.println("Insert shop value");
					res = _statistics.avgTrafficByShop(keyboard.nextLine())+"";
				break;
				case "generacasual":
					System.out.println("Insert Start id");
					int i = Integer.parseInt(keyboard.nextLine());
					System.out.println("Insert final id");
					int f = Integer.parseInt(keyboard.nextLine());
					res = _generaCasuali(i,f)+"";
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

	
	private static String _all() 
	{
		String res = "";
		try 
		{
			for(Property p:_propertydao.list())
				res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static String _apartment() 
	{
		String res = "";
		try 
		{
			for(Property p:_propertydao.list(" type='Apartment' "))
				if(p instanceof Apartment)
					res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	
	}
	
	private static String _advancedApartment(int r, int b, int v) {
		String res = "";
		try 
		{
			for(Property p:_propertydao.list(" rooms>="+r+" and bathrooms>="+b+" and value<="+v))
				if(p instanceof Apartment)
					res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	}
	
	private static String _advancedShop(int v) {
		String res = "";
		try 
		{
			for(Property p:_propertydao.list(" value<="+v))
				res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	}
	
	private static String _edificableground() {
		String res = "";
		try 
		{
			for(Property p:_propertydao.list(" permits like '%edificabile%'"))
				res+=p.toString() + "\n-------------------------\n";
		} 
		catch (Exception e) 
		{
			res = "Problem with your request:"+e.getMessage();
		}
		return res;
	}
	
	private static boolean _generaCasuali(int i, int f) {
		CasualInsert ci = new CasualInsertImplement();
			try {
				for(Property p : ci.random(i, f))
					_propertydao.save(p);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
		return true;
	}

	
}