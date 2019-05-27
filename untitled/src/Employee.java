import java.time.LocalDate;

class Employee {
	private long id;
	private double salary;
	private LocalDate dateOfJoining;

	public Employee(long id, double salary, LocalDate dateOfJoining) {
		this.id = id;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
