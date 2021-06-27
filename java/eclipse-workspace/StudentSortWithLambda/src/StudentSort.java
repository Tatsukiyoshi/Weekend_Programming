import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSort {

	public static void main(String[] args) {
		// Java7以前のソート
		System.out.println("Comparator Sort:");
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Murata", 100));
		studentList.add(new Student("Okada", 70));
		studentList.add(new Student("Tanimoto", 80));
		
		System.out.println(studentList);
		
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				return Integer.compare(student1.getScore(), student2.getScore());
			}
		});
		
		System.out.println(studentList);
		
		// ラムダ式を利用
		// List<Student> studentList = new ArrayList<>();
		System.out.println("Lambda Sort:");
		studentList = new ArrayList<>();
		studentList.add(new Student("Murata", 100));
		studentList.add(new Student("Okada", 70));
		studentList.add(new Student("Tanimoto", 80));
		
		System.out.println(studentList);
		
		Collections.sort(studentList,
				(student1, student2) -> Integer.compare(student1.getScore(), student2.getScore()));

		System.out.println(studentList);
		
		// 関数型インタフェース
		Student[] students = {
				new Student("Ken", 100),
				new Student("Shin", 60),
				new Student("Takuya", 80)};
		
		Arrays.sort(students, (Student o1, Student o2) ->
			Integer.compare(o2.getScore(), o1.getScore()));
		
		Arrays.stream(students).forEach(s ->
				System.out.println(s.getName() + ":" + s.getScore()));
	}
}
