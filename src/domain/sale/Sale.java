package domain.sale;

import domain.car.Car;
import domain.common.BaseObject;
import domain.customer.Customer;
import domain.employee.Dealer;

public class Sale extends BaseObject {

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

	public Sale(Dealer dealer, Customer customer, Car car, String bankName, String accountName, String accountNum,
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

	public int getSalesId() {
		return salesId;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public int getAdvanceDeposit() {
		return advanceDeposit;
	}

	public String getBankName() {
		return bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public boolean isRental() {
		return isRental;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public void setAdvanceDeposit(int advanceDeposit) {
		this.advanceDeposit = advanceDeposit;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}

}
