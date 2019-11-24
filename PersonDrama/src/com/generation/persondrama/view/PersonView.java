package com.generation.persondrama.view;

import java.util.Map;

import com.generation.persondrama.model.entities.Drama;
import com.generation.persondrama.model.entities.Person;

import generation.common.view.entities.BasicView;
import generation.common.view.language.Language;

public class PersonView implements generation.common.view.entities.EntityView<Person>
{
	//Siamo di nuovo nell'ambito del proxy...
	
	//Proxato:
	BasicView<Person> real;
	//Accessorio
	Language language;
	
	public PersonView(BasicView<Person> real, Language language)
	{
		this.real = real;
		this.language = language;
	}
	
	//... alcuni metodi devono essere OVERLOADATI!!!
	// il render della vista standard non va bene per una entity non piatta!
	
	// sto overridando un metodo di default
	// POSSO FARLO...
	@Override
	public String render(Person person)
	{
		//devo solo modificare render...
		String res = "\n"+real.render(person)+"\n";
		res+= language.translate("DRAMA")+":\n";
		for(Drama drama:person.getDramas())
			res+=real.render(drama)+"\n";
		return (person.getDramas().size() == 0) ? res + language.translate("NODRAMA") : res ;
	}
	
	
	@Override
	public Map getTemplates() 
	{
		//uso il mio componente reale per avere i templates MA...
		return real.getTemplates();
	}

}
