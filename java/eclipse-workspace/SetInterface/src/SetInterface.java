import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetInterface {

	public static void main(String[] args) {
		/*
		 * 4-5-1 Setの初期化
		 */
		// コレクションをSetに変換する
		List<Integer> integerList = Arrays.asList(1, 62, 31, 1, 54, 31);
		System.out.println("List :" + integerList);
		
		Set<Integer> integerSet = new HashSet<>(integerList);
		System.out.println("Set  :" + integerSet);
		
		// 配列をSetに変換する
		Integer[] integerArray = {1, 62, 31, 1, 54, 31};

		integerList = Arrays.asList(integerArray);
		System.out.println("List :" + integerList);

		integerSet = new HashSet<>(integerList);
		System.out.println("Set  :" + integerSet);

		/*
		 * 4-5-2 Setの使い方
		 */
		Set<String> names = new HashSet<>();
		
		// 値の追加
		names.add("Ken");
		names.add("Shin");
		names.add("Takuya");
		System.out.println("Setの中身：" + names.toString());

		// 値の上書き
		names.add("Shin");
		System.out.println("Setの中身：" + names.toString());
		
		// 値の削除
		names.remove("Shin");
		System.out.println("Setの中身：" + names.toString());
		
		// 要素数の取得
		int size = names.size();
		System.out.println("要素の数：" + size);
		
		// 値の検索
		boolean existKen = names.contains("Ken");
		System.out.println("Kenの存在：" + existKen);
	}
}
