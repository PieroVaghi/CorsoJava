package com.generation.finalshop.model.shop;

import javax.persistence.EntityManager;
public class FactoryShopBL {

	public static ShopBL make(EntityManager em)
	{
		return new ShopJPA(em);
	}
}
