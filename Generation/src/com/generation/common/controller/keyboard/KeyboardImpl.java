package com.generation.common.controller.keyboard;

import java.util.Scanner;

import generation.common.view.language.Language;

//Questo è il mio ADAPTER, implementato secondo il pattern singleton
//La vecchia interfaccia in questo caso equivale al vecchio componente
//I1 = C1 = Scanner
public class KeyboardImpl implements Keyboard
{
	//le mie dipendenze: old è il mio adaptee, l'oggetto adattato
	Scanner old = new Scanner(System.in);
	//questo POTREI non averlo. Keyboard potrebbe essere o meno localizzato
	private Language language;
	
	private KeyboardImpl() {}
		
	private static KeyboardImpl instance = new KeyboardImpl();

	private boolean localized()
	{
		return getLanguage()!=null;
	}
	
	@Override
	public String readLine(String msg)
	{
		msg = localized() ? getLanguage().translate(msg) : msg;
		System.out.println(getLanguage().translate(msg));
		return old.nextLine();
	}

	@Override
	public String readInt(String msg, int min, int max, String errMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readLine(String msg, String[] validvalues, String errMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Language getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setLanguage(Language language)
	{
		this.language = language;		
	}

	
	
	
	
	

}