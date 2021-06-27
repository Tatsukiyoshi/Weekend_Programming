import java.util.HashMap;
import java.util.Map;

public class MapInterface {

	public static void main(String[] args) {
		// 4-4-1 Mapを作成する
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		
		// 4-4-2 Mapの使い方
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Ken", 100);
		scores.put("Shin", 60);
		scores.put("Takuya", 80);
		System.out.println("Mapの中身：" + scores.toString());	
		
		// 値の置換
		scores.put("Shin", 50);
		System.out.println("Mapの中身：" + scores.toString());	

		// 値の取得
		Integer takuyaScore = scores.get("Takuya");
		System.out.println("Takuyaの点数：" + takuyaScore);

		// 値の削除
		scores.remove("Shin");
		System.out.println("Mapの中身：" + scores.toString());	
		
		// 要素数の取得
		int size = scores.size();
		System.out.println("要素の数：" + size);
		
		// キーの検索
		boolean existKen = scores.containsKey("Ken");
		System.out.println("Kenの存在：" + existKen);
		
		// 値の検索
		boolean exist80 = scores.containsValue(80);
		System.out.println("80点の存在：" + exist80);
	}
}
