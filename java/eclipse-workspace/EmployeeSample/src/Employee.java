
public class Employee {
	private int employeeNo;
	private String employeeName;
	
	public Employee(int employeeNo, String employeeName) {
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee)obj;
		if (this.employeeNo != other.employeeNo) {
			return false;
		}
		if (employeeName == null) {
			if (other.employeeName != null) {
				return false;
			}
		} else if (!employeeName.equals(other.employeeName)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeNo;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}
}
