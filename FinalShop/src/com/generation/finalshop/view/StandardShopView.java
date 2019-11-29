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
		String res ="";
		res+=language.translate("JOBROLE")+job.getRole()+"\n";
		res+=language.translate("JOBCATEGORY")+job.getRole()+"\n";
		res+="============================================================\n";
		return res;
	}
	
	@Override
	public String render(Review review) {
		String res ="";
		res+=language.translate("REVIEWTITLE")+review.getTitle()+"\n";
		res+=language.translate("REVIEWCONTENT")+review.getContent()+"\n";
		res+=language.translate("REVIEWSTARS")+review.getStars()+"\n";
		res+=language.translate("REVIEWCOSTUMER")+ _getSingleCustomer(review.getCustomer())+"\n";
		res+=language.translate("REVIEWPRODUCT")+_getSingleCustomer(review.getProduct())+"\n";
		res+="============================================================\n";
		return res;
	}
	
	private String _getSingleCustomer(Product product) {
		return product.getName() + product.getCategory();
	}

	public String _getSingleCustomer(Customer customer) {
		return customer.getName() + customer.getSurname();
	}

		
	
}