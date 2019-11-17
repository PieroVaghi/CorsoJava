package deprecate;

/**
 * Classe Product, entity che fa da padre
 * a tutti i prodotti. Contiene solo i dati di base.
 * @author Ferdinando
 * @lastupdated 12/11/2019
 */
public abstract class Product extends Entity
{
	private int price, quantity;
	private String name, description;

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return true if available.
	 */
	public boolean isAvailable()
	{
		return quantity>0;
	}
	
	@Override
	public String toString() {
		return super.toString() + "price: " + price + ",\nquantity: " + quantity + ",\n" + (name != null ? "name: " + name + ",\n" : "")
				+ (description != null ? "description: " + description : "")+ "\n";
	}
	@Override
	public boolean valid()
	{
		return 
				id>0						&&
				name!=null					&&
				description!=null			&&
				!name.contentEquals("")		&&
				price>=0					&&
				quantity>=0;
	}
	
	
}