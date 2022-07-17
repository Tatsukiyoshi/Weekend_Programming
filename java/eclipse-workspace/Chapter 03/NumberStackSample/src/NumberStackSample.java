
public class NumberStackSample {

	public static void main(String[] args) {
		NumberStack<Integer> intStack = new NumberStack<>();
		NumberStack<Long> longStack = new NumberStack<>();
		
		intStack.push(100);
		intStack.push(200);
		
		Integer intElement = intStack.pop();
		if (intElement != null) {
			System.out.println(intElement);
		}
		
		longStack.push(123456789L);
	}
}
