package domain.sale;

import domain.car.Car;
import domain.common.BaseObject;
import domain.common.constants.ConfirmStatus;
import domain.common.constants.InterestRate;
import domain.customer.Customer;
import domain.employee.Dealer;

public class Sale extends BaseObject {

	private static int salesUID = 1;

	private int salesId;
	private Dealer dealer;
	private Customer customer;
	private Car car;
	private int contractNum;
	private int originalPrice; // 원금
	private int advanceDeposit; // 선약금
	private String bankName; // 은행명
	private String accountName; // 예금주명
	private String accountNum; // 계좌번호
	private boolean isRental;
	private boolean confirm;
	private boolean isAdvanceDeposit; //
	private boolean isGetDeposit;
	private ConfirmStatus confirmStatus; // 결재승인
	private InterestRate interestRate; // 이자율

	public Sale(Dealer dealer, Customer customer, Car car, String bankName, String accountName, String accountNum,
			boolean isRental) {

		salesId = salesUID++;
		originalPrice = car.getPrice();
		contractNum = salesId;
		confirmStatus = ConfirmStatus.WAIT;

		this.dealer = dealer;
		this.customer = customer;
		this.car = car;
		this.bankName = bankName;
		this.accountName = accountName;
		this.accountNum = accountNum;
		this.isRental = isRental;
	}

	public ConfirmStatus getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(ConfirmStatus confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public int getContractNum() {
		return contractNum;
	}

	public void setContractNum(int contractNum) {
		this.contractNum = contractNum;
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

	public String isRental() {
		return isRental ? "예" : "아니오";
	}

	public String isConfirm() {
		return confirm ? "예" : "아니오";
	}

	public String isAdvanceDeposit() {
		return isAdvanceDeposit ? "예" : "아니오";
	}

	public boolean isGetDeposit() {
		return isGetDeposit;
	}

	public InterestRate getInterestRate() {
		return interestRate;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public void setAdvanceDeposit(boolean isAdvanceDeposit) {
		this.isAdvanceDeposit = isAdvanceDeposit;
	}

	public void setGetDeposit(boolean isGetDeposit) {
		this.isGetDeposit = isGetDeposit;
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

	public void setInterestRate(InterestRate interestRate) {
		switch (interestRate) {
		case THREEMONTH:
			car.setPrice((int) (car.getPrice() * 1.5));
			break;
		case SIXMONTH:
			car.setPrice((int) (car.getPrice() * 1.4));
			break;
		case ONEYEAR:
			car.setPrice((int) (car.getPrice() * 1.35));
			break;
		case OVERONEYEAR:
			car.setPrice((int) (car.getPrice() * 1.2));
			break;
		}
	}

	public void printInfo() {
		System.out.println("id: " + "[" + getSalesId() + "]");
		System.out.println("딜러명: " + getDealer().getName());
		System.out.println("고객명: " + getCustomer().getName());
		System.out.println("계약번호: " + getContractNum());
		System.out.println("원금: " + getOriginalPrice());
		System.out.println("선약금: " + getAdvanceDeposit());
		System.out.println("은행명: " + getBankName());
		System.out.println("예금주명: " + getAccountName());
		System.out.println("계좌번호: " + getAccountNum());
		System.out.println("렌탈유무: " + isRental());
		System.out.println("결재상태: " + getConfirmStatus().getName());
		System.out.println("선수금 입금여부: " + isAdvanceDeposit());
		System.out.println("인도금 입금여부: " + isGetDeposit());
		System.out.println("이자율: " + getInterestRate().getDate());
		System.out.println("생성날짜: " + getCreatedAt());
		System.out.println("수정날짜: " + getUpdatedAt());
		System.out.println("-----------------------------------------------------------------------------------");
	}

}
