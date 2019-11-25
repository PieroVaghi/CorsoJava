package com.generation.common.view.language;

public class DummyLanguage implements Language
{

	@Override
	public String translate(String key)
	{
		return key;
	}

}