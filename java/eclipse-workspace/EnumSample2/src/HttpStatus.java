
public enum HttpStatus {
	OK(200), NOT_FOUND(404), INTERNAL_SERVICE_ERROR(500);
	
	private final int value;
	
	private HttpStatus(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
