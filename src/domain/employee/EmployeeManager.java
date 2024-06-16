package domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeManager {

	List<Employee> employees;

	public EmployeeManager() {
		employees = new ArrayList();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void getList() {
		employees.stream().forEach(System.out::println);
	}

	public void getEmployee(int empId) {
		employees.stream().filter(e -> e.getEmpId() == empId).forEach(System.out::println);
	}

	public void deleteEmployee(int empId) {
		Employee employee = employees.stream().filter(e -> e.getEmpId() == empId).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		employees.remove(employee);
	}

}
