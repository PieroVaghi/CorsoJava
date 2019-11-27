package com.generation.finalshop.model.bi;

import com.generation.common.model.bi.BIFacade;

public abstract class FactoryShopBI 
{
	public static ShopBI make(BIFacade oldcomponent)
	{
		return new ShopBIImpl(oldcomponent);
		
	}
}
