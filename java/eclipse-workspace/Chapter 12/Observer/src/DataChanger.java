
public class DataChanger extends Subject {
	private int status;

	@Override
	public void execute() {
		status++;
		System.out.println("ステータスが" + status + "に変わりました。");
		notifyObservers();
	}
}
