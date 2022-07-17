
public class AsyncProcess implements Runnable {
	private AsyncCallback callback;
	
	public AsyncProcess(AsyncCallback asyncCallback) {
		this.callback = asyncCallback;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000L);
			this.callback.notify("Finished.");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("AsyncProcess is finished.");
	}
}
