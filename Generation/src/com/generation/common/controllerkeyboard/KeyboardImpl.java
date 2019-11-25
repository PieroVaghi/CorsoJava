package com.generation.common.controllerkeyboard;

import java.util.Scanner;

import com.generation.common.view.language.Language;

//Questo è il mio ADAPTER, implementato secondo il pattern singleton
//La vecchia interfaccia in questo caso equivale al vecchio componente
//I1 = C1 = Scanner
public class KeyboardImpl implements Keyboard
{
	//le mie dipendenze: old è il mio adaptee, l'oggetto adattato
	Scanner old = new Scanner(System.in);
	//questo POTREI non averlo. Keyboard potrebbe essere o meno localizzato
	//avere un oggetto language cambia il comportamento del componente
	//se ho language mi aspetto di ricevere codici da tradurre
	private Language language;
	
	private KeyboardImpl() {}
		
	private static KeyboardImpl instance = new KeyboardImpl();
	
	public static KeyboardImpl getInstance() {return instance;}
	
	/**
	 * Questo metodo controlla che la lingua con cui vogliamo tradurre sia contenuta nel nostro programma.
	 * @return
	 */
	private boolean localized()
	{
		return getLanguage()!=null;
	}
	
	/**
	 * Questo metodo controlla che il messaggio che ci arriva sia possibile tradurlo(localized()), se lo è lo traduce, se non lo è lo lascia com'era
	 * e stampa il messaggio.
	 */
	@Override
	public String readLine(String msg)
	{
		msg = localized() ? getLanguage().translate(msg) : msg;
		System.out.println(getLanguage().translate(msg));
		return old.nextLine();
	}

	/**
	 * Questo metodo è in grado di visualizzare un messaggio e ripetere l'inserimento finchè non sarà compreso tra un min e un max.
	 */
	@Override
	public int readInt(String msg, int min, int max, String errMsg) 
	{
		//richiamo il metodo localized(), se è vero traduce il messaggio di errore che ci arriva dall'esterno in caso contrario lo lascia com'era.
		if(localized())
			errMsg=getLanguage().translate(errMsg);
		do
		{
			//richiamo il metodo readLine(String msg) che pensa lui a gestire(tradurre o no) il msg.
			String v=readLine(msg);
			try
			{
				//provo a convertire la stringa v(che mi arriva dall'esterno) in un intero
				int n=Integer.parseInt(v);
				//se il numero che ho ricavato è compreso tra il min e il max(anch'essi ci arrivano dall'esterno) allora ritorna il numero trasformato
				if(n>=min && n<=max)
					return n;
				// se non ci riesce stampa il messaggio di errore
				System.out.println(errMsg);
			}
			//è l'eccezione in cui potrei incorrere quando tento di trasformare una stringa in un numero
			catch(NumberFormatException e)
			{
				//stampo il messaggio di errore 
				System.out.println(errMsg);
			}
			//ho messo true perchè dovrò continuare a ciclare finchè il numero non è compreso tra i due numeri. Non diventa un ciclo infinito perchè nel 
			//caso il valore sia compreso col return uscirà automaticamente dal ciclo, mentre se non lo è o incorriamo nell'errore continuiamo a ciclare
			//fino a che non sia giusto il valore.
		}while(true);
		
	}
	
	/**
	 * Questo medoto è uguale a readInt() solo che al posto di un intero lo trasforma in un Double.
	 */
	public double readDouble(String msg, double min, double max, String errMsg)
	{
		if(localized())
			errMsg=getLanguage().translate(errMsg);
		do
		{
			String v=readLine(msg);
			try
			{
				double n=Double.parseDouble(v);
				if(n>=min && n<=max)
					return n;
				System.out.println(errMsg);
			}
			catch(NumberFormatException e)
			{
				System.out.println(errMsg);
			}
		}while(true);
	}
	
	/**
	 * Questo metodo ci serve per leggere una linea, come il metodo sopra. Solo che in questo casoci arriva un vettore di stringhe(validvalues) e dobbiamo scorrerlo per trovare
	 * se la stringa msg è contenuta in questo vettore. Se non è contenuta abbiamo il messaggio di errore, nel caso invece la trovassimo ci ritorna la stringa trovata
	 */
	@Override
	public String readLine(String msg, String[] validvalues, String errMsg) 
	{
		if(localized())
			errMsg=getLanguage().translate(errMsg);
		do
		{
			String v=readLine(msg);
			for(int i=0;i<validvalues.length;i++)
				if(validvalues[i].equals(v))
					return v;
			System.out.println(errMsg);
		}while(true);
	}

	@Override
	public void close() 
	{
		old.close();	
	}

	@Override
	public Language getLanguage() 
	{
		return language;
	}
	
	@Override
	public void setLanguage(Language language)
	{
		this.language = language;		
	}
	
	
	
	

}