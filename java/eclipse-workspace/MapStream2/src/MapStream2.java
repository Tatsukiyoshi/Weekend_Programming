
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MapStream2 {

	public static void main(String[] args) {
		// 5-2-3 MapからStreamを作成する
		Map<String, String> map = new HashMap<>();
		map.put("1", "Murata");
		map.put("2", "Okada");
		map.put("3", "Tanimoto");
		
		Stream<String> stream = map.values().stream();
		stream.forEach(System.out::println);
	}
}

