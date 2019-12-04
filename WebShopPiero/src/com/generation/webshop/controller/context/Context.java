package com.generation.webshop.controller.context;

import com.generation.webshop.controller.servlet.command.BadRequest;
import com.generation.webshop.controller.servlet.command.Behaviour;
import com.generation.webshop.controller.servlet.command.DeleteProduct;
import com.generation.webshop.controller.servlet.command.DeleteReview;
import com.generation.webshop.controller.servlet.command.FormLogin;
import com.generation.webshop.controller.servlet.command.FormNewCustomer;
import com.generation.webshop.controller.servlet.command.FormNewProduct;
import com.generation.webshop.controller.servlet.command.Login;
import com.generation.webshop.controller.servlet.command.Logout;
import com.generation.webshop.controller.servlet.command.NewCustomer;
import com.generation.webshop.controller.servlet.command.NewProduct;
import com.generation.webshop.controller.servlet.command.ProductDetail;
import com.generation.webshop.controller.servlet.command.ProductList;
import com.generation.webshop.controller.servlet.command.SaveReview;
import com.generation.webshop.controller.servlet.command.WebCommand;
import com.generation.webshop.model.shop.ShopJPA;

public class Context extends com.generation.common.controller.context.Context
{
	private static Context instance = new Context();
	
	public static Context getInstance() {return instance;}
	
	private Context()
	{
		put("shop", new ShopJPA("WebShopPiero"));
		
		put
		(
				"behaviour", 
				new Behaviour
				(
						new String[] {"", "productdetail","savereview","formlogin","login","formnewproduct",
								"newproduct", "logout","deletereview","deleteproduct","badrequest","formnewcustomer"
								,"newcustomer"}, 
						new WebCommand[] {new ProductList(), new ProductDetail(), new SaveReview(), new FormLogin(),
								new Login(), new FormNewProduct(), new NewProduct(), new Logout(), new DeleteReview(),
								new DeleteProduct(), new BadRequest(), new FormNewCustomer(), new NewCustomer()}
				)
		);
	
	}
	
	
	
	
}