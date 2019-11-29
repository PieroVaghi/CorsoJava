package com.generation.finalshop.controller.command;

import com.generation.common.model.entities.importer.*;
import com.generation.common.xml.XMLDocument;
import com.generation.common.xml.XMLDocumentFactory;
import com.generation.finalshop.model.entities.Product;
import com.generation.finalshop.model.importer.ProductXMLImporter;

public class XMLAbsorb extends DomainCommand {

	@Override
	protected String execute() {
		
		XMLDocument xdoc = XMLDocumentFactory.make(keyboard.readLine("ASKXMLPRODUCTPATH"));
		ImportResult<Product> imp = new ProductXMLImporter(xdoc,em).absorb();
		boolean res = true;
		for(Product p : imp.getValid()) {
			try {
				view.render((Product)bl.save(p));
				
			} catch (Exception e) {
				res = false;
				System.out.println("qualcosa non si è salvato");
				System.out.println(imp.getValid());
			}
		}
		return res+"";
		
	}

}
