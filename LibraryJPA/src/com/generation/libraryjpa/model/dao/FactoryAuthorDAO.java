package com.generation.libraryjpa.model.dao;

import javax.persistence.EntityManager;

public class FactoryAuthorDAO 
{
	public static AuthorDAO make(EntityManager em, int pagesize)
	{
		return new AuthorDAOJPA(em, pagesize);
	}
}
