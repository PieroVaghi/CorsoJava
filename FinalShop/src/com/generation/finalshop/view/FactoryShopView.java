package com.generation.finalshop.view;
import com.generation.common.view.language.Language;

public abstract class FactoryShopView 
{
	public static ShopView make(Language language)
	{
		return new StandardShopView(language);
	}
	
	
}