import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 5-4 Streamに対する「終端操作」
public class StreamTerminalOperation {

	public static void main(String[] args) {
		// 結果をまとめて取り出す終端操作
		List<String> list = Arrays.asList("Murata", "Okada", "Tanimoto");
		
		List<String> newList = list.stream()
			.filter(p -> p.length() > 5)
			.collect(Collectors.toList());	// Listにして返す

		newList.forEach(System.out::println);

		// 区切り文字を使って結合する
		// List<String> list = Arrays.asList("Murata", "Okada", "Tanimoto");
		String joined = list.stream()
			.filter(p -> p.length() > 5)
			.collect(Collectors.joining(","));
		
		System.out.println(joined);
		
		// 要素をグループ分けする
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		students.add(new Student("Sakamoto", 100));
		
		// グループ分けする。キーに点数、値に対応する生徒のlistが入ったMapが作られる
		Map<Integer, List<Student>> map = students.stream()
				.collect(Collectors.groupingBy(Student::getScore));
		
		// Mapから100点の生徒のリストを取り出す
		List<Student> perfects = map.get(100);
		perfects.forEach(s -> System.out.println(s.getName()));
	}

}
