package com.generation.finalshop.model.importer;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.generation.common.model.entities.importer.*;
import com.generation.common.xml.XMLDocument;
import com.generation.common.xml.XMLElement;
import com.generation.finalshop.model.entities.*;

public class ProductXMLImporter implements Importer<Product> 
{
	//la mia facade di prima!
	XMLDocument document;
	//ERRATO PASSARGLI QUESTO! Passiamogli uno shop... o ragioniamo meglio
	EntityManager em;
	
	public ProductXMLImporter(XMLDocument document, EntityManager em)
	{
		this.document = document;
		this.em = em;
	}

	@Override
	public ImportResult<Product> absorb() 
	{
		ImportResult<Product> res = new ImportResult<Product>();
		try
		{
			List<XMLElement> productTags = document.list("product");
			for(XMLElement productTag:productTags)
				res.getValid().add(_tagToProduct(productTag));
			
			return res;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}		
	}

	private Product _tagToProduct(XMLElement productTag) 
	{
		//Da Element a Mappa, parte piatta
		Map<String,String> productMap = productTag.getAttributes();
		productMap.put("description", productTag.getContent());
		//Da Mappa a Prodotto, parte piatta
		Product product = (Product) FactoryShop.getInstance().make("Product",productMap);
		
		for(XMLElement reviewTag:productTag.contained("review"))
			product.addReview(_tagToReview(reviewTag));
		return product;
	}

	private Review _tagToReview(XMLElement reviewTag)
	{
		Review review = new Review();
		review.setContent(reviewTag.getContent());
		review.setTitle(reviewTag.getAttributes().get("title"));
		review.setStars(Integer.parseInt(reviewTag.getAttributes().get("stars")));
		review.setCustomer
		(
			(Customer) em.find
			(
				Customer.class, 
				Integer.parseInt(reviewTag.getAttributes().get("customerid")) 
			)
		);
		return review;
	}
	
	
	
}