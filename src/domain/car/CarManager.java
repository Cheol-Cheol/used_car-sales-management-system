package domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import domain.common.DummyData;
import domain.common.Manager;

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
	public Optional<Car> getItem(int id) {
		return cars.stream().filter(el -> el.getCarId() == id).findFirst();
	}

	@Override
	public void deleteItem(int id) {
		Car car = cars.stream().filter(el -> el.getCarId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		cars.remove(car);
	}

}
