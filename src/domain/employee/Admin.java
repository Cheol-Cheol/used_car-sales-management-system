package domain.employee;

import domain.common.constant.Role;

public class Admin extends Employee {

	private Role role;

	public Admin(String name, String tel) {
		super(name, tel);
		role = Role.ADMIN;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("[%d] %-5s %-15s", getEmpId(), getRole().name(), getTel());
	}

}
