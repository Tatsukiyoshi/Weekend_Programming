
public class SampleMain {

	public static void main(String[] args) {
		Builder builder = new TopPageBuilder();
		Director director = new Director(builder);
		
		Page page = director.construct();
	}
}
