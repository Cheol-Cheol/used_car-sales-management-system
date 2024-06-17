package domain.employee;

import domain.common.constants.Role;

public class Admin extends Employee {

	public Admin(String name, String tel) {
		super(name, tel, Role.ADMIN);
	}

}
