import java.util.ArrayList;
import java.util.List;

// 5-5-3 ListやMapに対して効率的に処理を行う
public class ListAPISample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Murata");
		list.add("Okada");
		list.add("Tanimoto");
		
		list.removeIf(s -> s.length() <= 5);
		list.replaceAll(s -> s.toUpperCase());
		
		list.forEach(System.out::println);
	}
}
