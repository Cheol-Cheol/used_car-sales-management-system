package domain.employee;

import java.util.ArrayList;
import java.util.List;

import domain.activityReport.ActivityReport;
import domain.common.constant.Role;
import domain.customer.Customer;
import domain.sales.Sales;

public class Dealer extends Employee {

	private Role role;
	private List<Sales> mySales;
	private List<Customer> myCustomers;
	private List<ActivityReport> myActivityReports;

	public Dealer(String name, String tel) {
		super(name, tel);

		role = Role.DEALER;
		mySales = new ArrayList();
		myCustomers = new ArrayList();
		myActivityReports = new ArrayList();
	}

	public List<Sales> getMySales() {
		return mySales;
	}

	public List<Customer> getMyCustomers() {
		return myCustomers;
	}

	public List<ActivityReport> getMyActivityReports() {
		return myActivityReports;
	}

}
