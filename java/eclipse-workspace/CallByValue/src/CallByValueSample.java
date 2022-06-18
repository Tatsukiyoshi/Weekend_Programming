/**
 * 
 */

/**
 * @author taish
 *
 */
public class CallByValueSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 1;
		callByValue(value);
		System.out.println("呼び出し元 = " + value);
	}

	private static void callByValue(int value) {
		value++;
		System.out.println("呼び出し先 = " + value);
	}
}
