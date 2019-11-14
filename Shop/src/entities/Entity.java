package entities;

public abstract class Entity 
{
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Valid DOVRA' essere implementato ALMENO dalle figlie concrete.
	 * Ogni sottoclasse di entity dovrà dirmi: io sono valido oppure no!
	 * @return
	 */
	public abstract boolean valid();

	@Override
	public String toString() {
		return "id: " + id + "\n";
	}
	
	
	
	
}