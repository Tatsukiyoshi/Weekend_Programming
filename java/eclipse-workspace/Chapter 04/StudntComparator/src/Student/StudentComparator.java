package Student;

import java.util.Arrays;
import java.util.Comparator;

public class StudentComparator {

	public static void main(String[] args) {

		Student[] students = {
			new Student("Ken", 100),
			new Student("Shin", 60),
			new Student("Takuya", 80)
		};
		/** 並び替え方法を定義する
		 */
		Comparator<Student> comparator = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};

		// 配列と並び替え方法を指定して、並び替える
		Arrays.sort(students, comparator);
		for(Student student : students) {
			System.out.println(student.getName() + ":" + student.getScore());
		}
	}
}
