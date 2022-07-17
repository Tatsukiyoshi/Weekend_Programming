import java.text.MessageFormat;

public class StringFormatting {
	// プライベートフィールド
	private int number = 13;
	private String parameter = "apples";

	public static void main(String[] args) {
		StringFormatting sf = new StringFormatting();

		System.out.println("7-3-1");
		sf.sub1();
		sf.sub2();
		System.out.println("7-3-2");
		sf.sub3();
		sf.sub4();
	}

	private void sub4() {
		String message = MessageFormat.format("I have {1} {0}.", parameter, number);
		System.out.println(message);
	}

	private void sub3() {
		String message = MessageFormat.format("I have {0} {1}.", number, parameter);
		System.out.println(message);
	}

	private void sub2() {
		System.out.printf("I have 0x0%X %S.\n", number, parameter);
	}

	private void sub1() {
		System.out.printf("I have %d %s.\n", number, parameter);
	}
}
