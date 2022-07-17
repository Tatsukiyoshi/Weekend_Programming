import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		AsyncProcess proc = new AsyncProcess(new AsyncCallback() {
			public void notify(String message) {
				System.out.println("callback message: " + message);
				executor.shutdown();
			}
		});
		
		executor.execute(proc);
		System.out.println("AsyncProcess is started.");
	}
}
