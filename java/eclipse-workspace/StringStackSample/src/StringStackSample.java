public class StringStackSample {

	public static void main(String[] args) {
		StringStack strStack = new StringStack();
		
		String strElement = strStack.pop();
		
		strStack.push("Scala");
		strStack.push("Groovy");
		strStack.push("Java");
		
		strElement = strStack.pop();
		if (strElement != null) {
			System.out.println(strElement);
		}
	}
}

