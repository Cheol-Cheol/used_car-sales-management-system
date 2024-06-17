package domain.car;

import domain.common.constants.CarColor;
import domain.common.constants.CarType;
import domain.common.constants.PurchaseStatus;

public class Car {

	private static int carUID = 1;

	private int carId;
	private String brand;
	private String model;
	private CarColor carColor;
	private PurchaseStatus purchaseStatus; // 계약 유무
	private String carNum; // 차량번호
	private int price;
	private int distance;
	private String birth;
	private boolean accidentStatus;

	public Car(String brand, String model, CarColor carColor, PurchaseStatus purchaseStatus, String carNum, int price,
			int distance, String birth, boolean accidentStatus) {

		carId = carUID++;

		this.brand = brand;
		this.model = model;
		this.carColor = carColor;
		this.purchaseStatus = purchaseStatus;
		this.carNum = carNum;
		this.price = price;
		this.distance = distance;
		this.birth = birth;
		this.accidentStatus = accidentStatus;
	}

	public int getCarId() {
		return carId;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public CarColor getCarColor() {
		return carColor;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public String getCarNum() {
		return carNum;
	}

	public int getPrice() {
		return price;
	}

	public int getDistance() {
		return distance;
	}

	public String getBirth() {
		return birth;
	}

	public boolean isAccidentStatus() {
		return accidentStatus;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCarColor(CarColor carColor) {
		this.carColor = carColor;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAccidentStatus(boolean accidentStatus) {
		this.accidentStatus = accidentStatus;
	}

}
