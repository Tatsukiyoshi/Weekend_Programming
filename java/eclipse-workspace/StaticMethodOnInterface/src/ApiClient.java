
public class ApiClient {

	public static void main(String[] args) {
		Foo foo = new DefaultFoo("Hello Foo!");
		
		System.out.println(foo.say());
	}
}
