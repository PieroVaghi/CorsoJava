package generation.agenziailgriso.entities;

import generation.common.entities.Entity;

public abstract class Property extends Entity{
	
	private String address, notes, owner;
	private int value, sqm;
	public String getAddress() {
		return address;
	}
	public String getNotes() {
		return notes;
	}
	public String getOwner() {
		return owner;
	}
	public int getValue() {
		return value;
	}
	public int getSqm() {
		return sqm;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setSqm(int sqm) {
		this.sqm = sqm;
	}
	@Override
	public String toString() {
		return (address != null ? "address: " + address + ",\n" : "") + (notes != null ? "notes: " + notes + ",\n" : "")
				+ (owner != null ? "owner: " + owner + ",\n" : "") + "value: " + value + ",\nsqm: " + sqm;
	}
	
	@Override
	public boolean valid() {
		return 
				between(value,0,10000000)				&&
				between(sqm,0,10000000)				&&
				notVoid(address)									&&
				notVoid(notes)								&&
				notVoid(owner)									;
	}
	

}
