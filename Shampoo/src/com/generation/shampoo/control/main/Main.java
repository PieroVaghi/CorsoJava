package com.generation.shampoo.control.main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.shampoo.controller.context.Context;
import com.generation.shampoo.model.entities.Shampoo;
import com.generation.shampoo.model.importer.ShampooImporterFactory;
import com.generation.shampoo.model.statistics.Statistics;

import generation.common.dao.*;
import generation.common.entities.Factory;
import generation.common.importer.ImportResult;
import generation.common.importer.Importer;
import generation.common.view.View;

public class Main 
{
	private static EntityDAO<Shampoo> _dao = (EntityDAO<Shampoo>) Context.getInstance().get("shampoodao");
	private static java.util.Scanner keyboard = new java.util.Scanner(System.in);
	private static Statistics _statistics = (Statistics) Context.getInstance().get("statistics");
	private static View<Shampoo> _viewshampoo = (View<Shampoo>) Context.getInstance().get("viewshampoo");
	
	public static void main(String[] args) 
	{
		System.out.println(_viewshampoo.translate("INTRO"));

		String cmd="", res ="";
		do
		{
			System.out.print(_viewshampoo.translate("ASKCOMMAND"));
			cmd = keyboard.nextLine();
			switch(cmd)
			{
				case "tuttiglishampoo":
					try 
					{
						res = _printShampoo(_dao.list());
					} 
					catch (Exception e) 
					{
						res = "errore";
						e.printStackTrace();
					}					
				break;
				case "inseriscishampoo":
					res = (_insertShampoo())?_viewshampoo.translate("COMPLETED"):_viewshampoo.translate("NOTCOMPLETED");
					break;
				case "cancellashampoo":
					res = (_deleteShampoo())?_viewshampoo.translate("COMPLETED"):_viewshampoo.translate("NOTCOMPLETED");
					break;
				case "ricerca":
					res = _printShampoo(_cercaMarca());
				break;					
				case "nuovoshampoo":
					System.out.println(_viewshampoo.translate("ASKFILE"));
					String filename = keyboard.nextLine();
					try
					{
						Importer<Shampoo> importer = 
								ShampooImporterFactory.getInstance().make(filename, (Factory) Context.getInstance().get("entityfactory"));
						
						ImportResult<Shampoo> imported = importer.absorb();

						System.out.println(_viewshampoo.translate("COMPLETED"));
						
						if(imported.getErrors().size()>0)
						{
							System.out.println(_viewshampoo.translate("ERRORIMPORT"));
							for(String error:imported.getErrors())
								System.out.println(error);
						}
						
						if(imported.getInvalid().size()>0)
						{
							System.out.println(_viewshampoo.translate("INVALID"));
							for(Shampoo bad:imported.getInvalid())
								System.out.println(bad);
						}
						
						int successfull = 0;
						
						for(Shampoo s:imported.getValid())
						{
							try 
							{
								if(_dao.load(s.getId())==null)
								{
									_dao.save(s);
									successfull++;
								}
								else
									System.out.println("Questo prodotto è già presente in negozio: "+s);
							} catch (Exception e) 
							{
								System.out.println("Stavo cercando di inserire "+s+" ma è successo qualcosa di brutto");
								e.printStackTrace();
							}
						}
						System.out.println("Abbiamo appena aggiunto "+successfull+" prodotti al nostro campionario!");
					}
					catch(NullPointerException e)
					{
						res = "Probabilmente ci hanno inviato l'allegato sbagliato! Qui abbiamo il .jpg della foto della zia di qualcuno dell'altro ufficio..";
					}
					catch(FileNotFoundException e)
					{
						res = "Hanno di nuovo mandato la mail senza allegato.. Non abbiamo il file su cui lavorare";
						e.printStackTrace();
					}			
					break;
				case "deltabio":
					res = _statistics.deltaBio()+"";
				break;
				case "avgbyproducer":
					res = _statistics.avgPriceByProducer()+"";
				break;
				default:
					res = "Phonna!\n";
			}
			System.out.println(res);
			
		}while(!cmd.equals("quit"));
		
		
		

	}

	private static List<Shampoo> _cercaMarca() {
		System.out.print("Insert Producer: ");
		String producer = keyboard.nextLine();
		try {
			return _dao.list("producer = '" + producer+"'");
		} catch (Exception e) {
			System.out.println("La marca: "+producer+ "non ha trovato riscontri");
			e.printStackTrace();
			return null;
		}
	}

	private static boolean _deleteShampoo() {
		System.out.print("Insert ID: ");
		try {
			return _dao.delete(Integer.parseInt(keyboard.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Hai inserito un id che non è un numero!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Qualcosa è andato storto..");
			e.printStackTrace();
		}
		return false;
	}

	private static boolean _insertShampoo() {
		Map<String,String> ins = new HashMap<String,String>();
		ins.put("type", "Shampoo");
		System.out.print("Insert ID: ");
		ins.put("id", (keyboard.nextLine()));
		System.out.print("Insert Producer: ");
		ins.put("producer", (keyboard.nextLine()));
		System.out.print("Insert Name: ");
		ins.put("name", (keyboard.nextLine()));
		System.out.print("Insert Price: ");
		ins.put("price", (keyboard.nextLine()));
		System.out.print("Bio? (y/n): ");
		ins.put("bio", (keyboard.nextLine()));
		System.out.print("Insert Size: ");
		ins.put("size", (keyboard.nextLine()));
		try {
			return _dao.save((Shampoo) ((Factory) Context.getInstance().get("entityfactory")).make(ins));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static String _printShampoo(List<Shampoo> list) 
	{
		String res = "";
		try 
		{
			for(Shampoo p:_dao.list())
				res+=p.toString()+"\n";
		} 
		catch (Exception e) 
		{
			res = _viewshampoo.translate("ERRORMSG")+e.getMessage();
		}
		return res;
	}
	
}