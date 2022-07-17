import java.util.HashMap;
import java.util.Map;

public class MapTest {
	private static final Map<Integer, String> map;
	
	static {
		map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
	}
}
