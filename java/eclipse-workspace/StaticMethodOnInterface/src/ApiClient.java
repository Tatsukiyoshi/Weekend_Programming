
public class ApiClient {

	public static void main(String[] args) {
		Foo foo = Foo.newInstance("Hello Foo!");
		
		System.out.println(foo.say());
	}
}
