package domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.common.DummyData;
import domain.common.Manager;
import domain.employee.Employee;

public class CarManager implements Manager<Car> {

	private final List<Car> cars;

	public CarManager() {
		cars = new ArrayList(DummyData.initCars());
	}

	@Override
	public void addItem(Car item) {
		cars.add(item);
	}

	@Override
	public void getList() {
		cars.stream().forEach(System.out::println);
	}

	@Override
	public void getItem(int id) {
		cars.stream().filter(el -> el.getCarId() == id).forEach(System.out::println);
	}

	@Override
	public void deleteItem(int id) {
		Car car = cars.stream().filter(el -> el.getCarId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		cars.remove(car);
	}

}
