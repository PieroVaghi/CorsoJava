package com.generation.finalshop.view;
import java.util.List;

import com.generation.common.model.entities.IEntity;
import com.generation.common.view.language.Language;
import com.generation.finalshop.model.entities.Customer;
import com.generation.finalshop.model.entities.Job;
import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.entities.Review;

//Brutto... andrebbe relativizzato, ma pazienza
public class StandardShopView implements ShopView 
{

	//Sua dipendenza: una lingua
	Language language;

	StandardShopView(Language language)
	{
		super();
		this.language = language;
	}
	
	@Override
	public String render(Product product)
	{
		String res ="";
		res+=language.translate("PRODUCTNAME")+product.getName()+"\n";
		res+=language.translate("DESCRIPTION")+product.getDescription()+"\n";
		res+=language.translate("CATEGORY")+product.getCategory()+"\n";
		res+=language.translate("QUANTITY")+product.getQuantity()+" "+language.translate("PRICE")+" "+product.getPrice()+"\n";
		for(Review review: product.getReviews())
			res+=render(review);
		res+="============================================================\n";
		return res;		
	}
	
	@Override
	public String render(Customer customer)
	{
		String res ="";
		res+=language.translate("CUSTOMERNAME")+customer.getName()+"\n";
		res+=language.translate("SURNAME")+customer.getSurname()+"\n";
		res+=language.translate("EMAIL")+customer.getEmail()+"\n";
		res+=language.translate("PASSWORD")+customer.getPassword()+"\n";
		for(Review review: customer.getReviews())
			res+=render(review);
		res+=language.translate("CUSTOMERJOB")+customer.getJob();
		res+="============================================================\n";
		return res;		
	}

	@Override
	public String render(Job job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String render(List<IEntity> list) {
		String res = "";
		for(IEntity ie:list) {
			if (ie instanceof Product) 	
				res+=render((Product)ie);
			if (ie instanceof Customer) 	
				res+=render((Customer)ie);
			if (ie instanceof Job) 	
				res+=render((Job)ie);
			if (ie instanceof Review) 	
				res+=render((Review)ie);
		}
		return res;
	}
	
	
}