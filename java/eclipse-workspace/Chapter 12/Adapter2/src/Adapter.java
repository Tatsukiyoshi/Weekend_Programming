
public class Adapter extends Target {
	private OldSystem oldSystem;

	public Adapter() {
		this.oldSystem = new OldSystem();
	}
	@Override
	void process() {
		this.oldSystem.oldProcess();
	}
}
