package streams;

public class Employee {
	
	private int id;
	private String name;
	private String lastname;
	private double salary;
	private String department;
	private boolean status;
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, String lastname, double salary, String department, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.salary = salary;
		this.department= department;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastname=" + lastname + ", salary=" + salary
				+ ", department=" + department + ", status=" + status + "]";
	}

	

}
