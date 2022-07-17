import java.util.ArrayList;
import java.util.List;

// 複数のStudentを持つクラス
public class Group {
	private List<Student> students = new ArrayList<>();
	
	public void add(Student student) {
		students.add(student);
	}
	
	public List<Student> getStudents(){
		return students;
	}
}

