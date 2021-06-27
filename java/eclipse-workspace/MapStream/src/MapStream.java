import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MapStream {

	public static void main(String[] args) {
		// 5-2-3 MapからStreamを作成する
		Map<String, String> map = new HashMap<>();
		map.put("1", "Murata");
		map.put("2", "Okada");
		map.put("3", "Tanimoto");

		Stream<Entry<String, String>> stream = map.entrySet().stream();
		stream.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
	}

}
