package domain.common;

import java.util.Arrays;
import java.util.List;

import domain.activityReport.ActivityReport;
import domain.car.Car;
import domain.common.constants.CarColor;
import domain.common.constants.CustomerType;
import domain.common.constants.PurchaseStatus;
import domain.customer.Customer;
import domain.employee.Admin;
import domain.employee.Dealer;
import domain.employee.Employee;
import domain.sale.Sale;

public class DummyData {

	public static List<Car> initCars() {
		return Arrays.asList(new Car("BMW", "X4", CarColor.BLACK, "12가 1234", 15000000, 20000, "2022", false),
				new Car("KIA", "셀토스", CarColor.BLUE, "32라 5234", 5000000, 50000, "2005", true),
				new Car("HYUNDAI", "G90", CarColor.BLACK, "45바 3421", 35000000, 40000, "2023", false),
				new Car("AUDI", "A4", CarColor.WHITE, "15다 8234", 15000000, 15000, "2022", false),
				new Car("BENZ", "E300", CarColor.WHITE, "15마 4323", 35000000, 23000, "2023", true));
	}

	public static List<Employee> initEmpolyees() {
		return Arrays.asList(new Admin("아무개", "010-1234-1234"), new Dealer("황철원", "010-1212-4512"),
				new Dealer("조정하", "010-4562-1343"), new Dealer("이예림", "010-2332-6723"),
				new Dealer("유재원", "010-6742-4922"), new Dealer("송예림", "010-9678-1102"));
	}

	// Customer 빌더 적용하면 좋을듯
	public static List<Customer> initCustomers() {
		return Arrays.asList(
				new Customer("세단형", CustomerType.PERSONAL, "송동호", "test@naver.com", "010-2352-1122", "대전광역시 유성구", "직장인",
						27),
				new Customer("대형", CustomerType.CORPORATION, "KCC 정보통신", "kcc1234@naver.com", "010-4452-3442",
						"서울특별시 용산구 청파동", "", 1),
				new Customer("소형", CustomerType.PERSONAL, "최동호", "dongho1234@naver.com", "010-2352-1122", "인천광역시 중구",
						"무직", 25),
				new Customer("중형", CustomerType.PERSONAL, "박동호", "hello1234@naver.com", "010-2352-1122", "인천광역시 연수구",
						"자영업인", 42),
				new Customer("대형", CustomerType.CORPORATION, "KOSA", "kosa1234@naver.com", "010-2552-6122", "서울특별시 종로구",
						"", 1));
	}

}
