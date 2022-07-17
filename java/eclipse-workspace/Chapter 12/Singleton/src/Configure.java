
public class Configure {
	private static Configure instance = new Configure();
	
	private Configure() {
		
	}
	
	public static Configure getInstance() {
		return instance;
	}
}
