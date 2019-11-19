package generation.agenziailgriso.entities;

public class Apartment extends Property{

	private int floor, rooms, balconis, bathrooms;

	public int getFloor() {
		return floor;
	}

	public int getRooms() {
		return rooms;
	}

	public int getBalconis() {
		return balconis;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public void setBalconis(int balconis) {
		this.balconis = balconis;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "floor: " + floor + ",\nrooms: " + rooms + ",\nbalconis: " + balconis + ",\nbathrooms: " + bathrooms;
	}

	@Override
	public boolean valid() {
		return 
				super.valid()									&&
				between(floor,0,1000)				&&
				between(rooms,1,1000)				&&
				between(balconis,0,1000)				&&
				between(bathrooms,1,1000)				
				;
	}
	
	
}
