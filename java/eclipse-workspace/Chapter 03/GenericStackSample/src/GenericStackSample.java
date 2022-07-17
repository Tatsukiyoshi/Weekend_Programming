import java.util.ArrayList;
import java.util.List;

public class GenericStackSample {

	public static void main(String[] args) {
		GenericStack<String> genStack = new GenericStack<>();
		
		genStack.push("Scala");
		genStack.push("Groovy");
		genStack.push("Java");
		
		String strElement = genStack.pop();
		if (strElement != null) {
			System.out.println(strElement);
		}
		
		GenericStack<Integer> genStack2 = new GenericStack<>();
		
		genStack2.push(100);
		genStack2.push(200);
		
		Integer intElement = genStack2.pop();
		if(intElement != null) {
			System.out.println(intElement);
		}
		
		List<String> strList = new ArrayList<>();
		strList.add("Java");
		strList.add("Groovy");
		GenericStack<String> gstack = GenericStackUtil.as(strList);
		System.out.println(gstack.pop());
	}
}
