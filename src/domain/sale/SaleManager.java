package domain.sale;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.car.Car;
import domain.common.Manager;

public class SaleManager implements Manager<Sale> {

	private final List<Sale> sales;

	public SaleManager() {
		sales = new ArrayList();
	}

	// 판매품의서 생성
	@Override
	public void addItem(Sale item) {
		sales.add(item);
	}

	// 판매품의서 전체조회
	@Override
	public void getList() {
		sales.stream().forEach(el -> el.printInfo());
	}

	// 판매품의서 상세조회
	@Override
	public Sale getItem(int id) {
		return sales.stream().filter(el -> el.getContractNum() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
	}

	// 판매품의서 삭제
	@Override
	public void deleteItem(int id) {
		Sale sale = sales.stream().filter(el -> el.getContractNum() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		sales.remove(sale);
	}

	// 판매품의서 수정
	public void editItem(int id, Car newCar) {
		Sale sale = sales.stream().filter(e1 -> e1.getContractNum() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 계약번호입니다."));
		System.out.println("수정되었습니다.");
		sale.setCar(newCar);
		System.out.println(sale.getCar().getCarId() + ", " + sale.getCar().getCarColor());
	}

}
