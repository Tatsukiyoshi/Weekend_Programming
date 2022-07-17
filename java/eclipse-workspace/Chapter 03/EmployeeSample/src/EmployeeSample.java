import java.util.HashSet;
import java.util.Set;

public class EmployeeSample {
	public static void main(String...args) {
		Employee employee1 = new Employee(1, "山田 太郎");
		Employee employee2 = new Employee(1, "山田 太郎");
		Set<Employee> employees = new HashSet<>();
		employees.add(employee1);
		employees.add(employee2);
		System.out.println(employees.size());
	}
}
