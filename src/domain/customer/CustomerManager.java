package domain.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import domain.common.DummyData;
import domain.common.Manager;

public class CustomerManager implements Manager<Customer> {

	private final List<Customer> customers;

	public CustomerManager() {
		customers = new ArrayList(DummyData.initCustomers());
	}

	@Override
	public void addItem(Customer item) {
		customers.add(item);
	}

	@Override
	public void getList() {
		customers.stream().forEach(System.out::println);
	}

	@Override
	public Customer getItem(int id) {
		return customers.stream().filter(el -> el.getCustomerId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
	}

	@Override
	public void deleteItem(int id) {
		Customer customer = customers.stream().filter(el -> el.getCustomerId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		customers.remove(customer);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

}
