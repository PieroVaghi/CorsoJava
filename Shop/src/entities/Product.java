package entities;

/**
 * Classe Product, entity che fa da padre a tutti i prodotti
 * @author Piero
 * @lastupdated 12/11/2019
 *
 */
public abstract class Product {

	private int id, price, quantity;
	private String name, description;
	
	
	public int getId() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ",\nprice: " + price + ",\nquantity: " + quantity + ",\n"
				+ (name != null ? "name: " + name + ",\n" : "")
				+ (description != null ? "description: " + description : "");
	}
	
	/**
	 * Restituisco true se il prodotto è disponibile
	 * per ora contollando solo la quantità
	 * @return true if aviable
	 */
//	public boolean isAvailable() {
//		
//	}
	
	
}
