package domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.common.Manager;

public class EmployeeManager implements Manager<Employee> {

	private final List<Employee> employees;

	public EmployeeManager() {
		employees = new ArrayList();
	}

	@Override
	public void addItem(Employee item) {
		employees.add(item);
	}

	@Override
	public void getList() {
		employees.stream().forEach(System.out::println);
	}

	@Override
	public void getItem(int id) {
		employees.stream().filter(el -> el.getEmpId() == id).forEach(System.out::println);
	}

	@Override
	public void deleteItem(int id) {
		Employee employee = employees.stream().filter(e -> e.getEmpId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		employees.remove(employee);
	}

}
