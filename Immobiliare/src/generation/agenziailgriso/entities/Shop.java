package generation.agenziailgriso.entities;

public class Shop extends Property {
	
	private int windows, werehouse, traffic;

	public int getWindows() {
		return windows;
	}

	public int getWerehouse() {
		return werehouse;
	}

	public int getTraffic() {
		return traffic;
	}

	public void setWindows(int windows) {
		this.windows = windows;
	}

	public void setWerehouse(int werehouse) {
		this.werehouse = werehouse;
	}

	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "windows: " + windows + ",\nwerehouse: " + werehouse + ",\ntraffic: " + traffic;
	}

	@Override
	public boolean valid() {
		return 
				super.valid()									&&
				between(windows,0,1000)				&&
				between(werehouse,1,1000)				&&
				between(traffic,0,10000000)			
				;
	}
	
	

}
