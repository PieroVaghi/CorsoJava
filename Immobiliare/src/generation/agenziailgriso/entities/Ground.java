package generation.agenziailgriso.entities;

public class Ground extends Property {
	
	private String permits, state;

	public String getPermits() {
		return permits;
	}

	public String getState() {
		return state;
	}

	public void setPermits(String permits) {
		this.permits = permits;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + (permits != null ? "permits: " + permits + ",\n" : "") + (state != null ? "state: " + state : "");
	}

	@Override
	public boolean valid() {
		return 
				super.valid()									&&
				notVoid(permits)				&&
				notVoid(state)				
				;
	}
	
	

}
