package domain.sales;

import domain.car.Car;
import domain.customer.Customer;
import domain.employee.Dealer;

public class Sales {

	private static int salesUID = 1;

	private int salesId;
	private Dealer dealer;
	private Customer customer;
	private Car car;
	private int originalPrice; // 원금
	private int advanceDeposit; // 선약금
	private String bankName; // 은행명
	private String accountName; // 예금주명
	private String accountNum; // 계좌번호
	private boolean isRental;

	public Sales(Dealer dealer, Customer customer, Car car, String bankName, String accountName, String accountNum,
			boolean isRental) {

		salesId = salesUID++;

		this.dealer = dealer;
		this.customer = customer;
		this.car = car;
		this.bankName = bankName;
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.isRental = isRental;
	}

}
