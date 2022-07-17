import java.util.ArrayList;
import java.util.List;

// 5-1-1 Stream APIでコレクションの操作はどう変わるか？
public class StreamSample { 

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		// 「作成」：Streamインスタンスを生成する
		students.stream()
			// 「中間操作」：scoreが70点以上のStudentを抽出
			.filter(s -> s.getScore() >= 70)
			// 「終端操作」：名前を表示する
			.forEach(s -> System.out.println(s.getName()));
	}
}
