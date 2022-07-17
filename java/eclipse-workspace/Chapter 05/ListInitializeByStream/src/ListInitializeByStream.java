import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 5-6 Stream APIを使ったListの初期化
public class ListInitializeByStream {

	public static void main(String[] args) {
		// 5-6-1 Streamを用いて、列挙した値からListを作成する
		List<Integer> integerList = IntStream.of(1, 62, 31, 1, 54, 31).boxed()
				.collect(Collectors.toList());
		
		System.out.println(integerList);
		
		// 5-6-2 Streamを用いて、値の範囲からListを作成する
		integerList = IntStream.range(1, 100).boxed()
				.collect(Collectors.toList());
		
		System.out.println(integerList);
		
		// 5-6-3 Streamを用いて、配列を作成する
		Integer[] integerArray = IntStream.of(1, 62, 31, 1, 54, 31).boxed()
				.toArray(n -> new Integer[n]);
		
		for (int i = 0; i < integerArray.length; i++) {
			System.out.println(integerArray[i]);
		}
	}
}
