package esempi;

import java.util.Map;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Sciagure
{

	public static void main(String[] args) 
	{
		Map<String, List<String>> sciagure = new HashMap<String, List<String>>();
		
		java.util.Scanner tastiera = new java.util.Scanner(System.in);
		
		
		sciagure.put("09/11/2007", new ArrayList<String>());
		
		sciagure.get("09/11/2007").add("Non lo dico neanche, ma è stato brutto o bello");
		sciagure.get("09/11/2007").add("Però la cena era non era neanche buona o seria");

		sciagure.put("09/11/2016", new ArrayList<String>());
		sciagure.get("09/11/2016").add("Era meglio restare a letto o al bagno");
		String cmd = "";
		
		while(!cmd.equals("quit"))
		{
			System.out.println("---------------------------------\nInserisci comando:");
			cmd = tastiera.nextLine();
			switch(cmd)
			{
				case "nuovasciagura":
				{
					System.out.println("Inserisci data:");
					String data = tastiera.nextLine();
					
					if(!sciagure.containsKey(data))
						sciagure.put(data, new ArrayList<String>());

					System.out.println("Dimmi fratello, cosa ti ha angustiato?");
					String sciagura = tastiera.nextLine();
					sciagure.get(data).add(sciagura);
					System.out.println("Abbiamo pensato che ti piacerebbe rivedere dei ricordi di questo giorno felice");
					for(String s:sciagure.get(data))
						System.out.println(s);
				}
				break;	
				case "apocalisse":
					for(String data:sciagure.keySet())
						for(String sciagura:sciagure.get(data))
							System.out.println(data+":"+sciagura);
				break;
				case "cercadanno":
				{
					System.out.println("Che parola luttuosa vuoi trovare in questa valle di lacrime o sfortunato viandante?");
					String keyword = " " + tastiera.nextLine() + " ";
					String ris = "";
					for(String data:sciagure.keySet()) {
						boolean flag = true;
						for(String sciagura:sciagure.get(data))
							if((" "+sciagura.toUpperCase()+" ").contains(keyword.toUpperCase()) && flag) {
								ris += data+"\n";
								flag = false;
							}
					}
					ris = (ris.isEmpty()) ? "Per ora sei fortunato, non hai ancora subito questo danno..\nMa non si può mai sapere in futuro!" : "I tuoi sfortunati studenti ora stamperanno tutte le date che presentano quella parola, stampandole UNA volta sola\n" + ris;
					System.out.println(ris);
				}
				break;
				case "eliminaricordo":
				{
					System.out.println("Non ce la faccio a ricordare, ti prego cancellami, inserire data e numero del ricordo da cancellare");
					boolean flag = false;
					String data = "";
					while(!flag) {
						System.out.println("Inserisci data");
						data = tastiera.nextLine();
						if(sciagure.keySet().contains(data))
							flag = true;
					}
					System.out.println("Inserisci numero del ricordo");
					int index = Integer.parseInt(tastiera.nextLine());
					sciagure.get(data).remove(index-1);
				}
				break;
				case "eliminadata":
				{
					System.out.println("Eliminare la chiave dalla mappa... usare remove, cercatevelo");
					boolean flag = false;
					String data = "";
					while(!flag) {
						System.out.println("Inserisci data");
						data = tastiera.nextLine();
						if(sciagure.keySet().contains(data))
							flag = true;
					}
					sciagure.remove(data);
				}
				break;
				case "giornopeggiore":
					int max = 0;
					String kMax = "";
					for(String d:sciagure.keySet()) {
						int cont = 0;
						for(String sciagura:sciagure.get(d))	
							cont ++;
						if(max<cont) {
							max = cont;
							kMax = d;
						}
					}
					System.out.println("Il giorno con più sciagure è stato il: " + kMax);
				break;
				default:
					System.out.println("Il tuo comando non è stato riconosciuto..\nVuoi aggiungere questa esperienza al tuo personale elenco di sciagure? Si/No");
					String choose = tastiera.nextLine();
					if(choose.equalsIgnoreCase("si")) {
						String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
						sciagure.put(date, new ArrayList<String>());
						sciagure.get(date).add("Hai inserito un comando sbagliato testando questo programma..");
					}
						
			}
		
		}
							
	}

}