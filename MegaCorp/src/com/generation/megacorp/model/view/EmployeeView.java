package com.generation.megacorp.model.view;

import java.util.Map;

import com.generation.megacorp.model.entities.Certificate;
import com.generation.megacorp.model.entities.Employee;

import generation.common.view.entities.BasicView;
import generation.common.view.language.Language;

public class EmployeeView implements generation.common.view.entities.EntityView<Employee>
{
	//Siamo di nuovo nell'ambito del proxy...
	
	//Proxato:
	BasicView<Employee> real;
	//Accessorio
	Language language;
	
	public EmployeeView(BasicView<Employee> real, Language language)
	{
		this.real = real;
		this.language = language;
	}
	
	//... alcuni metodi devono essere OVERLOADATI!!!
	// il render della vista standard non va bene per una entity non piatta!
	
	// sto overridando un metodo di default
	// POSSO FARLO...
	@Override
	public String render(Employee employee)
	{
		//devo solo modificare render...
		String res = real.render(employee);
		res+= language.translate("CERTIFICATES");
		for(Certificate certificate:employee.getCertificates())
			res+=real.render(certificate)+"\n";
		return res;
	}
	
	
	@Override
	public Map getTemplates() 
	{
		//uso il mio componente reale per avere i templates MA...
		return real.getTemplates();
	}

}
