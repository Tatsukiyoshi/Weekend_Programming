import java.util.ArrayList;
import java.util.List;

// 5-3-2 要素を絞り込む中間操作
public class StreamInterimOperation {

	public static void main(String[] args) {
		// filterによる抽出
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		students.stream()
			.filter(s -> s.getScore() > 70) // scoreが70より大きいStudentの抽出
			.forEach(s -> System.out.println(s.getName()));

		// limitによる絞り込み
		students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		students.stream()
			.limit(2)	// 2件に絞り込む
			.forEach(s -> System.out.println(s.getName()));
		
		// distinctによる絞り込み
		List<String> strings = new ArrayList<>();
		strings.add("Ken");
		strings.add("Shin");
		strings.add("Ken");
		strings.add("Takuya");
		strings.add("Ken");
		strings.add("Shin");
		
		strings.stream()
			.distinct()
			.forEach(System.out::println);
		
		// sortedによる並べ替え
		students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		students.stream()
			// scoreが高い順に並べる
			.sorted((s1, s2) -> s2.getScore() - s1.getScore())
			.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
	}
}
