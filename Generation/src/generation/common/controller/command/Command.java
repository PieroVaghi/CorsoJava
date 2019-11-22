package generation.common.controller.command;

public abstract class Command {
	
	protected abstract String execute();
	
	protected abstract void init();
	
	public String run() {
		init();
		return execute();
	}

}
