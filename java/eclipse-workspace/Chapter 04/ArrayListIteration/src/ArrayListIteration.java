import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 4-3-6 Listのイテレーション
public class ArrayListIteration {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		// for-each
		System.out.println("for-eachでの出力");
		for(String element : list) {
			System.out.println(element);
		}
		
		// Iteratorインタフェース
		System.out.println("Iteratorでの出力");
		for(Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
			String element = iterator.next();
			System.out.println(element);
		}
		
		// Iteratorでの繰り返し処理
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ken", 100));
		students.add(new Student("Shin", 60));
		students.add(new Student("Takuya", 80));
		
		System.out.println("繰り返し処理前");
		for(Student student : students) {
			System.out.println(student.getName() + ":" + student.getScore());
		}
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			
			// 70点未満の人は、リストから削除する
			if(student.getScore() < 70) {
				iterator.remove();
			}
		}

		System.out.println("繰り返し処理後");
		for(Student student : students) {
			System.out.println(student.getName() + ":" + student.getScore());
		}
	}
}
