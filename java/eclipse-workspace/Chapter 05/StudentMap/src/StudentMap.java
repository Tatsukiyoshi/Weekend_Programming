import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Streamに対する「中間操作」
public class StudentMap {

	// 5-3-1 要素を置き換える「中間操作」
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		Stream<Integer> stream = students.stream()
				.map(s -> s.getScore());
		stream.forEach(System.out::println);
		
		// 各グループの複数のStuentを１つの
		List<Group> groups = new ArrayList<>();
		
		Group group1 = new Group();
		group1.add(new Student("Murata", 100));
		group1.add(new Student("Tanimoto", 60));
		group1.add(new Student("Okada", 80));
		groups.add(group1);
		
		Group group2 = new Group();
		group2.add(new Student("Akiba", 75));
		group2.add(new Student("Hayakawa", 85));
		group2.add(new Student("Sakamoto", 95));
		groups.add(group2);
		
		Group group3 = new Group();
		group3.add(new Student("Kimura", 90));
		group3.add(new Student("Hashimoto", 65));
		group3.add(new Student("Ueda", 80));
		groups.add(group3);
		
		// 通常のmapを実施
		@SuppressWarnings("unused")
		Stream<List<Student>> mappedStream = groups.stream().map(g -> g.getStudents());
		
		// flatMapを実施
		@SuppressWarnings("unused")
		Stream<Student> flapMappedStream = groups.stream().flatMap(g -> g.getStudents().stream());
		
		// flatMapメソッドを使わない場合
		List<Student> allStudents = new ArrayList<>();
		groups.stream()
			.forEach(g -> allStudents.addAll(g.getStudents()));
		allStudents.stream()
			.sorted((s1, s2) -> s2.getScore() - s1.getScore())
			.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));

		// flatMapメソッドを使う場合
		groups.stream()
			.flatMap(g -> g.getStudents().stream())
			.sorted((s1, s2) -> s2.getScore() - s1.getScore())
			.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
	}

}
