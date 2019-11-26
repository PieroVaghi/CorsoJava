package com.generation.libraryjpa.view;
import java.util.List;

import com.generation.libraryjpa.model.entities.*;
import com.generation.common.view.language.Language;

//Brutto... andrebbe relativizzato, ma pazienza
public class StandardAuthorView implements AuthorView 
{

	//Sua dipendenza: una lingua
	Language language;

	StandardAuthorView(Language language)
	{
		super();
		this.language = language;
	}
	
	@Override
	public String render(Author author)
	{
		String res ="";
		res+=language.translate("NAME")+author.getName()+"\n";
		res+=language.translate("SURNAME")+author.getSurname()+"\n";
		res+=language.translate("NATIONALITY")+author.getNationality()+"\n";
		res+=language.translate("DOB")+author.getDob()+" "+language.translate("DOD")+" "+author.getDod()+"\n";
		for(Book book: author.getBooks())
			res+=render(book);
		res+="============================================================\n";
		return res;		
	}

	@Override
	public  String render(Book book) 
	{
		return language.translate("BOOK") + book.getTitle()+" "+book.getPrice()+" \n";
	}
	
	@Override
	public String render(List<Author> list)
	{
		String res = "";
		for(Author author:list)
			res+=render(author);
		return res;
	}
	
	
}