import java.util.Arrays;
import java.util.List;

// 5-1-3 メソッド参照
public class MethodReference {

	public static void main(String[] args) {
		// メソッド参照
		List<String> list = Arrays.asList("Xxx", "Yyyy", "Zzzz");
		list.forEach(System.out::println);
		
		// ラムダ式
		list.forEach(str -> System.out.println(str));
	}
}
