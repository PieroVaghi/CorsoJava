package generation.wh40k.entities;

import generation.common.entities.Entity;;

public abstract class Unit extends Entity 
{
	private int cost;
	private String deployment;
	private String notes;
	
	public int getCost() {
		return cost;
	}
	public String getDeployment() {
		return deployment;
	}
	public String getNotes() {
		return notes;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return super.toString() +"\n"+ "cost: " + cost + ",\n" + (deployment != null ? "deployment: " + deployment + ",\n" : "")
				+ (notes != null ? "notes: " + notes : "");
	}
	@Override
	public boolean valid() {
		return 	between(cost,0,100000)	&&
				notVoid(deployment)		&&
				notVoid(notes)			;
	}
	
	
}