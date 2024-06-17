import java.util.NoSuchElementException;

import domain.activityReport.ActivityReportManager;
import domain.car.CarManager;
import domain.customer.CustomerManager;
import domain.employee.Employee;
import domain.employee.EmployeeManager;
import domain.sale.SaleManager;

public class TotalSolution {

	private Employee loginUser;

	private final EmployeeManager employeeManager;
	private final CustomerManager customerManager;
	private final CarManager carManager;
	private final SaleManager saleManager;
	private final ActivityReportManager activityReportManager;

	public TotalSolution() {
		employeeManager = new EmployeeManager();
		customerManager = new CustomerManager();
		carManager = new CarManager();
		saleManager = new SaleManager();
		activityReportManager = new ActivityReportManager();
	}

	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public CarManager getCarManager() {
		return carManager;
	}

	public SaleManager getSaleManager() {
		return saleManager;
	}

	public ActivityReportManager getActivityReportManager() {
		return activityReportManager;
	}

	public void login(int id, String name) throws Exception {
		Employee employee = getEmployeeManager().getItem(id)
				.orElseThrow(() -> new NoSuchElementException("[서비스 알림] 일치하는 id를 찾지 못함"));

		if (employee.getName().equals(name.trim())) {
			loginUser = employee;
			System.out.println("[" + loginUser.getRole().getName() + "] " + loginUser.getName() + "님 반갑습니다.");
		} else {
			throw new IllegalArgumentException("[서비스 알림] 로그인 실패");
		}
	}

	public void logout() {
		loginUser = null;
	}
}
