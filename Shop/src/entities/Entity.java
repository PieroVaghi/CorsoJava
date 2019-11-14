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

	public static boolean notVoid(String value) {
		return value!=null && !value.trim().contentEquals("");			
	}
	
	public static boolean between (double value, double min, double max) {
		return value>=min && value<=max;
	}
	
	public static boolean validEmail(String email) {
		return false;
		
	}
	
	/**
	 * verifica se value appartiene all'insieme set
	 * @param value
	 * @param set
	 * @return true se contenuto
	 */
	public static boolean beLongs (String value, String[] set) {
		for(String v : set)
			if(v.contentEquals(value))
				return true;
			return false;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\n";
	}
	
	
	
	
}