import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 4-3-2 Listを作成する
// 4-3-3 Listの代表的なメソッド
public class ArrayListMethods {
	public static void main(String[] args) {
		// List作成と要素の追加
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(62);
		list.add(31);
		list.add(1);
		list.add(54);
		list.add(31);
		System.out.println("list=" + list.toString());

		// 作成済み配列をもとにList作成→変更不可
		List<Integer> integerList = Arrays.asList(1, 62, 31, 1, 54, 31);
		System.out.println("integerList=" + integerList.toString());
		
		// 要素を列挙して作成したListを変更したい場合
		List<Integer> integerList1 = new ArrayList<>(Arrays.asList(1, 62, 31, 1, 54, 31));
		System.out.println("integerList1=" + integerList1.toString());
		
		// 値の追加
		List<String> names = new ArrayList<>();
		names.add("Ken");
		names.add("Shin");
		names.add("Takuya");
		System.out.println("リストの中身：" + names.toString());

		// 値の挿入
		names.add(2, "Satoshi");
		System.out.println("リストの中身：" + names.toString());
		
		// 値の置換
		names.set(0, "Makoto");
		System.out.println("リストの中身：" + names.toString());

		// 値の取得
		String thirdName = names.get(2);
		System.out.println("３番目の要素：" + thirdName);
		
		// 値の削除
		names.remove(1);
		System.out.println("リストの中身：" + names.toString());

		// 要素数の取得
		int size = names.size();
		System.out.println("要素の数：" + size);

		// 値の検索
		int takuyaIndex = names.indexOf("Takuya");
		System.out.println("Takuyaの位置：" + takuyaIndex);
		
		// 値が含まれているかの判定
		boolean exists = names.contains("Shin");
		System.out.println("Shinが含まれているか？" + exists);
		
	}

}
