package com.generation.libraryjpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.generation.libraryjpa.model.entities.Author;

public class AuthorDAOJPA implements AuthorDAO
{
	//CONTENGO UN ENTITYMANAGER
		//è una mia dipendenza
		EntityManager em;
		int pagesize;
		
		AuthorDAOJPA(EntityManager em, int pagesize)
		{
			this.em = em;
			this.pagesize = pagesize;
		}
		

		@Override
		public List<Author> list(String name, String nationality, int page) 
		{
			String jpql = "select s from Author as s where s.id>"+ (page-1)*pagesize;
			if(name!=null && !name.contentEquals(""))
				jpql+=" and s.name='"+name+"' ";
			if(nationality!=null && !nationality.contentEquals(""))
				jpql+=" and s.nationality='"+nationality+"' ";
			TypedQuery<Author> query = em.createQuery(jpql, Author.class);    
			query.setMaxResults(pagesize);

			return query.getResultList();
		}

		@Override
		public Author save(Author author)
		{
			em.getTransaction().begin(); //inizio operazione di modifica
			em.persist(author);
			em.getTransaction().commit(); //esegui davvero
			//restituisco il soldato modificato, aggiornato con id ecc...
			return author;
		}

		@Override
		public Author load(int id) 
		{
			return (Author) em.find(Author.class, id);
		}

		@Override
		public boolean remove(Author author) 
		{
			try
			{
				em.getTransaction().begin(); //inizio operazione di modifica
				em.remove(author);
				em.getTransaction().commit(); //esegui davvero
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}


}