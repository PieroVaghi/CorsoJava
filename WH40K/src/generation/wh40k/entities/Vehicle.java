package generation.wh40k.entities;

public class Vehicle extends Unit
{
	private String category; // ground, air, amphibious
	private String fueltype; //tipo di benzina
	private String license; 
	private int years; //anni in servizio
	public String getCategory() {
		return category;
	}
	public String getFueltype() {
		return fueltype;
	}
	public String getLicense() {
		return license;
	}
	public int getYears() {
		return years;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public void setYears(int years) {
		this.years = years;
	}
	@Override
	public String toString() {
		return super.toString() +"\n" + (category != null ? "category: " + category + ",\n" : "")
				+ (fueltype != null ? "fueltype: " + fueltype + ",\n" : "")
				+ (license != null ? "license: " + license + ",\n" : "") + "years: " + years;
	}
	@Override
	public boolean valid() {
		return 	super.valid()		&&
				notVoid(category)	&&
				notVoid(fueltype)	&&
				notVoid(license)	&&
				between(years,0,100);
	}
	
	

}