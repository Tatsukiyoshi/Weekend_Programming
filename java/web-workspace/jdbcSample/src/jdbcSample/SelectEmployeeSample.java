package jdbcSample;

import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class SelectEmployeeSample {
	public static void main(String[] args) {
		EmployeeDAO empDAO = new EmployeeDAO();
		List<Employee> empList = empDAO.findAll();

		// 結果表に格納されたレコードの内容を表示
		for(Employee employee : empList){
			System.out.println("ID:" + employee.getId());
			System.out.println("名前:" + employee.getName());
			System.out.println("年齢:" + employee.getAge() + "\n");
		}
		
		if(empDAO.remove("EMP999")) {
			System.out.println("削除に成功しました");
		} else {
			System.out.println("削除に失敗しました");
		}

		if(empDAO.remove("EMP001")) {
			System.out.println("削除に成功しました");
		} else {
			System.out.println("削除に失敗しました");
		}

		empList = empDAO.findAll();

		// 結果表に格納されたレコードの内容を表示
		for(Employee employee : empList){
			System.out.println("ID:" + employee.getId());
			System.out.println("名前:" + employee.getName());
			System.out.println("年齢:" + employee.getAge() + "\n");
		}
	}
}
