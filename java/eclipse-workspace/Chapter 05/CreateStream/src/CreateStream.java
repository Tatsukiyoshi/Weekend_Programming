import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// 5-2 Streamを作成する
public class CreateStream {

	public static void main(String[] args) {
		// 5-2-1 ListやSetからStreamを作成する
		List<String> list = Arrays.asList("Murata", "Okada", "Tanimoto");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);

		// 5-2-2 配列からStreamを作成する
		String[] array = {"Murata", "Okada", "Tanimoto"};
		stream = Arrays.stream(array);
		stream.forEach(System.out::println);
		
		stream = Stream.of("Murata", "Okada", "Tanimoto");
		stream.forEach(System.out::println);
	}
}
