
public class Client implements Observer {

	@Override
	public void update(Subject subject) {
		System.out.println("通知を受信しました。");
	}
}
