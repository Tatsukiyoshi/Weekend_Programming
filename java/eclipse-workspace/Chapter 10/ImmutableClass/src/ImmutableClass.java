
public class ImmutableClass {

	public static void main(String[] args) {
		String text1 = "This is an apple.";
		String text2 = text1.replace("apple", "orange");
		System.out.println("元のオブジェクト：" + text1);
		System.out.println("戻り値　　　　　：" + text2);
	}
}
