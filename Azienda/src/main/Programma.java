package main;

import aggregatore.Azienda;
import aggregatore.IAzienda;
import enities.Dipartimento;
import enities.Dipendente;
import enities.Lingua;

public class Programma {

	public static void main(String[] args) {
																	//?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		IAzienda a = new Azienda("jdbc:mysql://127.0.0.1:3306/azienda?useSSL=false","root","root");
		a.caricaDipendenti();
		a.caricaLingue();
//		for(Dipendente d : a.caricaDipendenti())
//			System.out.println(d.getLingue()+"\n");
//		for(Lingua l : a.caricaLingue())
//			System.out.println(l+"\n");
		System.out.println("totStipendio: ");
		System.out.println(a.totstipendi() + "€");
		System.out.println("avgStipendio: ");
		System.out.println(a.avgstipendi() + "€");
		System.out.println("minStipendio: ");
		System.out.println(a.minstipendi() + "€");
		System.out.println("maxStipendio: ");
		System.out.println(a.maxstipendi() + "€");
		System.out.println("totStipendioNonORM: ");
		System.out.println(a.totstipendiNonORM() + "€");
		System.out.println("avgStipendioNonORM: ");
		System.out.println(a.avgstipendiNonORM() + "€");
		System.out.println("maxStipendioNonORM: ");
		System.out.println(a.maxstipendiNonORM() + "€");
		System.out.println("minStipendioNonORM: ");
		System.out.println(a.minstipendiNonORM() + "€");
		
		
		
	}

}
