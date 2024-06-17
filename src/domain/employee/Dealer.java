package domain.employee;

import java.util.ArrayList;
import java.util.List;

import domain.activityReport.ActivityReport;
import domain.common.constants.Role;
import domain.customer.Customer;
import domain.sale.Sale;

public class Dealer extends Employee {

	private List<Sale> mySales;
	private List<Customer> myCustomers;
	private List<ActivityReport> myActivityReports;

	public Dealer(String name, String tel) {
		super(name, tel, Role.DEALER);

		mySales = new ArrayList();
		myCustomers = new ArrayList();
		myActivityReports = new ArrayList();
	}

	public List<Sale> getMySales() {
		return mySales;
	}

	public List<Customer> getMyCustomers() {
		return myCustomers;
	}

	public List<ActivityReport> getMyActivityReports() {
		return myActivityReports;
	}

}
