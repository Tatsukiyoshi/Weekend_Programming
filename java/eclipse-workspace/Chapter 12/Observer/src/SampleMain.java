
public class SampleMain {

	public static void main(String[] args) {
		Observer observer = new Client();
		Subject dataChanger = new DataChanger();
		
		dataChanger.addObserver(observer);
		
		for(int count = 0; count < 10; count++) {
			dataChanger.execute();
			
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
