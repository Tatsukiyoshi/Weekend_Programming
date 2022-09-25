import java.util.List;

/**
 * Employeeクラス
 * @author taish
 *
 */
public class Employee {
	private String name;
	private Integer age;
	private List<String> licenses;

	public Employee() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<String> licenses) {
		this.licenses = licenses;
	}
}
