package domain.common.constants;

import java.util.Arrays;
import java.util.List;

public enum CarType {

	BMW("비엠더블유", Arrays.asList("X4", "X7", "X6", "iX", "i7", "i4")),
	BENZ("벤츠", Arrays.asList("C200", "C300", "E200", "E300", "E350", "S500", "S580")),
	AUDI("아우디", Arrays.asList("A3", "A4", "A6", "A8", "S3", "S4", "S6", "S8")), //
	KIA("기아", Arrays.asList("K3", "K5", "K8", "K9", "모닝", "셀토스", "카니발")), //
	HYUNDAI("현대", Arrays.asList("아반떼", "쏘나타", "그랜저", "G80", "G90", "아이오닉5", "아이오닉7"));

	private final String brand;
	private final List<String> model;

	private CarType(String brand, List<String> model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public List<String> getModel() {
		return model;
	}

}
