import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Employee {
	private String name;
	private Integer age;
	private Date birth;
	private String email;
	private String note;

	public Employee() {}

	public Employee(String name, Integer age, Date birth, String email, String note) {
		this.setName(name);
		this.setAge(age);
		this.setBirth(birth);
		this.setEmail(email);
		this.setNote(note);
	}
	
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static Date localDate2Date(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
