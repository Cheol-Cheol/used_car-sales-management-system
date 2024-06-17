package domain.customer;

import java.util.ArrayList;
import java.util.List;

import domain.common.BaseObject;
import domain.common.constants.CarType;
import domain.common.constants.CustomerType;
import domain.employee.Dealer;
import domain.sale.Sale;

// 빌더 패턴 적용 - 심플 빌더 패턴(?) 공부해서 다시 적용해보기 
// toString - 형식 바꿔야댐
public class Customer extends BaseObject {

	private static int customerUID = 1;

	private int customerId;
	private Dealer myDealer; // ㅍ
	private List<Sale> mySales; // ㅍ
	private String carInterests; // ㅍ
	private CustomerType customerType; // ㅍ // 개인 or 법인
	private String name; // ㅍ
	private String email; // ㅅ
	private String tel; // ㅍ
	private String addr; // ㅍ
	private String job; // ㅅ
	private int age; // ㅅ

	public Customer(Dealer myDealer, String carInterests, CustomerType customerType, String name, String email,
			String tel, String addr, String job, int age) {

		customerId = customerUID++;
		mySales = new ArrayList();

		this.myDealer = myDealer;
		this.carInterests = carInterests;
		this.customerType = customerType;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
		this.age = age;
	}

	public Customer(String carInterests, CustomerType customerType, String name, String email, String tel, String addr,
			String job, int age) {

		customerId = customerUID++;
		mySales = new ArrayList();

		this.carInterests = carInterests;
		this.customerType = customerType;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
		this.age = age;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Dealer getMyDealer() {
		return myDealer;
	}

	public List<Sale> getMySales() {
		return mySales;
	}

	public String getCarInterests() {
		return carInterests;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public String getAddr() {
		return addr;
	}

	public String getJob() {
		return job;
	}

	public int getAge() {
		return age;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setMyDealer(Dealer myDealer) {
		this.myDealer = myDealer;
	}

	public void setMySales(List<Sale> mySales) {
		this.mySales = mySales;
	}

	public void setCarInterests(String carInterests) {
		this.carInterests = carInterests;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", myDealer=" + myDealer + ", carInterests=" + carInterests
				+ ", customerType=" + customerType + ", name=" + name + ", email=" + email + ", tel=" + tel + ", addr="
				+ addr + ", job=" + job + ", age=" + age + "]";
	}

}
