package domain.employee;

import domain.common.BaseObject;

public class Employee extends BaseObject {

	private static int empUID = 1;

	private int empId;
	private String name;
	private String tel;

	public Employee(String name, String tel) {
		super();
		empId = empUID++;

		this.name = name;
		this.tel = tel;
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

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("[%d] %-5s %-15s", getEmpId(), getName(), getTel());
	}

}
