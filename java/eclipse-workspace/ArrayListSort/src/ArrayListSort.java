import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 4-3-4 Listをソートする
public class ArrayListSort {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(13);
		list.add(2);
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		
		Collections.sort(list, c);
		System.out.println(list);
	}
}
