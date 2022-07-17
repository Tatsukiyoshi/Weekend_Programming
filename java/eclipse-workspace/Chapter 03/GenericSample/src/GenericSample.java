import java.util.ArrayList;
import java.util.List;

public class GenericSample {
	public static void main(String...args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		
		String element = list.get(0);
		
		System.out.println(element);
	}
}
