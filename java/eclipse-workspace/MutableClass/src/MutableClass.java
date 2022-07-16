import java.util.concurrent.atomic.AtomicInteger;

public class MutableClass {

	public static void main(String[] args) {
		StringBuilder text = new StringBuilder("This is ");
		System.out.println("操作前：" + text);
		text.append("an apple.");
		System.out.println("操作後：" + text);
		
		AtomicInteger number = new AtomicInteger(1);
		System.out.println("操作前：" + number);
		number.incrementAndGet();
		System.out.println("操作後：" + number);
		
		someMethod();
	}

	public static  void someMethod() {
		StringBuilder text = new StringBuilder("This is ");
		AtomicInteger number = new AtomicInteger(1);
		System.out.println("書き換え前：" + text + " " + number);
		
		write(text, number);
		
		System.out.println("書き換え後：" + text + " " + number);
	}

	public static void write(StringBuilder text, AtomicInteger number) {
		text.append("an apple.");
		number.incrementAndGet();
	}
}
