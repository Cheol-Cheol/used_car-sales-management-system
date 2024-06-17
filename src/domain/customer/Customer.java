package domain.customer;

import java.util.ArrayList;
import java.util.List;

import domain.common.BaseObject;
import domain.common.constants.CarType;
import domain.common.constants.CustomerType;
import domain.employee.Dealer;
import domain.sale.Sale;

public class Customer extends BaseObject {

	private static int customerUID = 1;

	private int customerId;
	private Dealer myDealer;
	private List<Sale> mySales;
	private String carInterests;
	private CustomerType customerType;
	private String name;
	private String email;
	private String tel;
	private String addr;
	private String job;
	private int age;

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

	public void printInfo() {
		System.out.println("id: " + "[" + getCustomerId() + "]");
		System.out.println("고객명: " + getName());
		System.out.println("담당직원명: " + getMyDealer().getName());
		System.out.println("고객유형: " + getCustomerType().getType());
		System.out.println("관심차종: " + getCarInterests());
		System.out.println("판매품위서 개수: " + getMySales().size());
		System.out.println("이메일: " + getEmail());
		System.out.println("전화번호: " + getTel());
		System.out.println("주소: " + getAddr());
		System.out.println("직업: " + getJob());
		System.out.println("나이: " + getAge());
		System.out.println("생성날짜: " + getCreatedAt());
		System.out.println("수정날짜: " + getUpdatedAt());
		System.out.println("-----------------------------------------------------------------------------------");
	}

}
