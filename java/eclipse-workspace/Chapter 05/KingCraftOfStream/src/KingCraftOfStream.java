import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 5-5-1 王道はmao、filter、collect
public class KingCraftOfStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Murata", "Okada", "Tanimoto");
		
		List<String> newList = list.stream()
				.filter(p -> p.length() > 5)
				.map(p -> "[" + p + "]")
				.collect(Collectors.toList());
		
		newList.forEach(System.out::println);
	}
}
