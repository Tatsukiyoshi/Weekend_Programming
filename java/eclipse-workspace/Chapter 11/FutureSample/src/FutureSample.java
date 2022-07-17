import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(new Callable<String>() {
			public String call() {
				try {
					Thread.sleep(1000L);
				} catch(InterruptedException ex) {
					return "Execution is failed";
				}
				return "Finished.";
			}
		});
		
		System.out.println("ExecutorService is started.");
		
		try {
			String message = future.get();
			System.out.println("ExecutorService is finished : message = " + message);
		} catch (InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}
