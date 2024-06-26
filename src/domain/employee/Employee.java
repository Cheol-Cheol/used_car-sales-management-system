package domain.employee;

import domain.common.BaseObject;
import domain.common.constants.Role;

public class Employee extends BaseObject {

	private static int empUID = 1;

	private int empId;
	private String name;
	private String tel;
	private Role role;

	public Employee(String name, String tel, Role role) {
		super();
		empId = empUID++;

		this.name = name;
		this.tel = tel;
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public Role getRole() {
		return role;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return String.format("[%d] %-5s %-5s %-15s %-15s %-15s", getEmpId(), getRole().name(), getName(), getTel(),
				getCreatedAt(), getUpdatedAt());
	}

}
