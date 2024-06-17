package domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.activityReport.ActivityReport;
import domain.common.constants.CustomerType;
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

	public Customer addItem(String carInterests, CustomerType customerType, String name, String email, String tel,
			String addr, String job, int age) {
		// 유효성 검사
		Customer customer = new Customer(carInterests, customerType, name, email, tel, addr, job, age);
		customer.setMyDealer(this);
		return customer;
	}

	public void getList() {
		myCustomers.stream().forEach(System.out::println);
	}

	public Customer getItem(int id) {
		return myCustomers.stream().filter(el -> el.getCustomerId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
	}

	public void deleteItem(int id) {
		Customer customer = myCustomers.stream().filter(el -> el.getCustomerId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		myCustomers.remove(customer);
	}
}
