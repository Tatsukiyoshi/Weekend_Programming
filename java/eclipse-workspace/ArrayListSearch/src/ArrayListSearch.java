import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 4-3-5 Listを検索する
public class ArrayListSearch {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 1, 4, 5, 7, 8, 11, 12, 17, 21, 24);
		
		// 「５」という数字を検索
		int found = Collections.binarySearch(values, 5);
		System.out.println(found);

		// 「６」という数字を検索
		int notfound = Collections.binarySearch(values, 6);
		System.out.println(notfound);
	}
}
