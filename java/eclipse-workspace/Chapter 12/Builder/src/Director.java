
public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Page construct() {
		builder.createHeader();
		builder.createContents();
		builder.createFooter();
		
		return builder.getResult();
	}
}
