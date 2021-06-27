import java.util.ArrayList;

public class ArrayListSample {
	public static void main(String...args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Java");
		
		String element = (String)list.get(0);
		
		System.out.println(element);
	}
}
