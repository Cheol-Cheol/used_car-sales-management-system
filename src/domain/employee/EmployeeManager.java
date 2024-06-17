package domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import domain.common.DummyData;
import domain.common.Manager;

public class EmployeeManager implements Manager<Employee> {

	private final List<Employee> employees;

	public EmployeeManager() {
		employees = new ArrayList(DummyData.initEmpolyees());
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
	public Optional<Employee> getItem(int id) {
		return employees.stream().filter(el -> el.getEmpId() == id).findFirst();
	}

	@Override
	public void deleteItem(int id) {
		Employee employee = employees.stream().filter(el -> el.getEmpId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		employees.remove(employee);
	}

}
