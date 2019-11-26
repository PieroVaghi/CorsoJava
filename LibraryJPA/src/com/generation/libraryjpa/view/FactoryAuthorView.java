package com.generation.libraryjpa.view;
import com.generation.common.view.language.Language;

public abstract class FactoryAuthorView 
{
	public static AuthorView make(Language language)
	{
		return new StandardAuthorView(language);
	}
	
	
}