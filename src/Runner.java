import java.io.IOException;
import java.util.NoSuchElementException;

import domain.activityReport.ActivityReport;
import domain.car.Car;
import domain.common.constants.CarColor;
import domain.common.constants.CustomerType;
import domain.common.constants.Role;
import domain.customer.Customer;
import domain.employee.Admin;
import domain.employee.Dealer;
import domain.employee.Employee;
import utils.DataInput;

public class Runner {

	private static TotalSolution totalSolution = new TotalSolution();

	public static void main(String[] args) throws IOException {

		DataInput dataInput = DataInput.getInstance();

		Employee loginUser = login();

		while (true) {
			System.out.println("[1] 고객 관리     [2] 차량 관리     [3] 판매 관리     [4] 활동 계획 관리     [5] 딜러 관리     [6] 로그아웃");
			System.out.print("[" + loginUser.getRole().getName() + "] >");
			int cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				if (isAdmin(loginUser)) {
					customerManagerByAdmin(loginUser);
				} else {
					customerManagerByDealer(loginUser);
				}
				break;
			case 2:
				if (isAdmin(loginUser)) {
					carManagerByAdmin(loginUser);
				} else {
					carManagerByDealer(loginUser);
				}
				break;
			case 3:
				break;
			case 4:
				if (isAdmin(loginUser)) {
					activityReportManagerByAdmin(loginUser);
				} else {
					activityReportManagerByDealer(loginUser);
				}
				break;
			case 5:
				if (isAdmin(loginUser)) {
					employeeManagerByAdmin(loginUser);
				} else {
					System.out.println("[서비스 알림] 접근 권한이 없습니다.");
				}
				break;
			case 6:
				logout();
				loginUser = login();
				break;
			}
		}

	}

	private static void customerManagerByAdmin(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Admin loginAdmin = (Admin) loginUser;
		while (true) {
			System.out.println("\n#고객 관리");
			System.out.println("[1] 고객 전체 조회     [2] 고객 상세 조회     [3] 고객 수정     [4] 고객 삭제     [5] 나가기");
			System.out.print("[" + loginAdmin.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				totalSolution.getCustomerManager().getList();
				break;
			case 2:
				System.out.println("검색할 고객의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					Customer customer = totalSolution.getCustomerManager().getItem(id);
					customer.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("수정할 고객의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				break;
			case 4:
				System.out.println("삭제할 고객의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					totalSolution.getCustomerManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				return;
			}
		}

	}

	private static void customerManagerByDealer(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Dealer loginDealer = (Dealer) loginUser;
		while (true) {
			System.out.println("\n#고객 관리");
			System.out.println("[1] 고객 등록     [2] 고객 전체 조회     [3] 고객 상세 조회     [4] 고객 수정     [5] 고객 삭제     [6] 나가기");

			cmd = Integer.parseInt(dataInput.readLine());
			switch (cmd) {
			case 1:
				System.out.println("고객의 성명을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String name = dataInput.readLine();
				System.out.println("고객의 이메일을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String email = dataInput.readLine();
				System.out.println("고객의 주소를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String addr = dataInput.readLine();
				System.out.println("고객의 관심차종을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String carInterests = dataInput.readLine();
				System.out.println("고객의 전화번호를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String tel = dataInput.readLine();
				System.out.println("고객의 직업을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String job = dataInput.readLine();
				System.out.println("고객의 나이를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				int age = Integer.parseInt(dataInput.readLine());
				System.out.println("고객의 개인/법인을 입력해주세요. [1] 개인 [2] 법인");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				int idx = Integer.parseInt(dataInput.readLine()) - 1;

				Customer newCustomer = loginDealer.addItem(carInterests, CustomerType.values()[idx], name, email, tel,
						addr, job, age);
				totalSolution.getCustomerManager().addItem(newCustomer);
				break;
			case 2:
				loginDealer.getList();
				break;
			case 3:
				System.out.println("검색할 고객의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					Customer customer = loginDealer.getItem(id);
					customer.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				// 수정
				break;
			case 5:
				System.out.println("삭제할 고객의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					loginDealer.deleteItem(id);
					totalSolution.getCustomerManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				return;
			}

		}
	}

	private static void carManagerByAdmin(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Admin loginAdmin = (Admin) loginUser;
		while (true) {
			System.out.println("\n#차량 관리");
			System.out.println("[1] 차량 등록     [2] 차량 전체 조회     [3] 차량 상세 조회     [4] 차량 수정     [5] 차량 삭제     [6] 나가기");
			System.out.print("[" + loginAdmin.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				System.out.println("차량의 브랜드를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				String brand = dataInput.readLine();
				System.out.println("차량의 모델을 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				String model = dataInput.readLine();
				System.out.println("차량의 색상을 입력해주세요.");
				for (int i = 0; i < CarColor.values().length; i++) {
					System.out.print("(" + (i + 1) + ") " + CarColor.values()[i].getName() + " ");
				}
				System.out.println("");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				int carColorIdx = Integer.parseInt(dataInput.readLine());
				System.out.println("차량의 차량번호를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				String carNum = dataInput.readLine();
				System.out.println("차량의 가격을 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				int price = Integer.parseInt(dataInput.readLine());
				System.out.println("차량의 주행거리를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				int distance = Integer.parseInt(dataInput.readLine());
				System.out.println("차량의 연식을 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				String birth = dataInput.readLine();
				System.out.println("차량의 사고유무를 입력해주세요. [Y/N]");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				boolean accidentStatus = dataInput.readLine().equals("Y") ? true : false;

				Car newCar = new Car(brand, model, CarColor.values()[carColorIdx + 1], carNum, price, distance, birth,
						accidentStatus);
				totalSolution.getCarManager().addItem(newCar);
				break;
			case 2:
				totalSolution.getCarManager().getList();
				break;
			case 3:
				System.out.println("검색할 차량의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					Car car = totalSolution.getCarManager().getItem(id);
					car.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("수정할 차량의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				break;
			case 5:
				System.out.println("삭제할 차량의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					totalSolution.getCarManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				return;
			}
		}
	}

	private static void carManagerByDealer(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Dealer loginDealer = (Dealer) loginUser;
		while (true) {
			System.out.println("\n#차량 관리");
			System.out.println("[1] 차량 전체 조회     [2] 차량 상세 조회    [3] 조건별 차량 조회     [4] 나가기");
			System.out.print("[" + loginDealer.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				totalSolution.getCarManager().getList();
				break;
			case 2:
				System.out.println("검색할 차량의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					Car car = totalSolution.getCarManager().getItem(id);
					car.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				// 조건별 차량 조회
				break;
			case 4:
				return;
			}
		}
	}

	private static void activityReportManagerByAdmin(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Admin loginAdmin = (Admin) loginUser;
		while (true) {
			System.out.println("\n#활동 계획 관리");
			System.out.println("[1] 활동 계획 전체 조회     [2] 활동 계획 상세 조회     [3] 활동 계획 수정     [4] 활동 계획 삭제     [5] 나가기");
			System.out.print("[" + loginAdmin.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				totalSolution.getActivityReportManager().getList();
				break;
			case 2:
				System.out.println("검색할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					ActivityReport activityReport = totalSolution.getActivityReportManager().getItem(id);
					activityReport.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("수정할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				break;
			case 4:
				System.out.println("삭제할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					totalSolution.getActivityReportManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				return;
			}
		}
	}

	private static void activityReportManagerByDealer(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Dealer loginDealer = (Dealer) loginUser;
		while (true) {
			System.out.println("\n#활동 계획 관리");
			System.out.println(
					"[1] 활동 계획 등록     [2] 활동 계획 전체 조회     [3] 활동 계획 상세 조회     [4] 활동 계획 수정     [5] 활동 계획 삭제     [6] 나가기");
			System.out.print("[" + loginDealer.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1:
				System.out.println("활동 계획에 추가할 고객의 id을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());
				System.out.println("활동 계획의 내용을 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String content = dataInput.readLine();
				System.out.println("활동 계획의 메모를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				String memo = dataInput.readLine();

				try {
					Customer customer = loginDealer.getItem(id);
					ActivityReport newActivityReport = new ActivityReport(loginDealer, customer, content, memo);
					loginDealer.getMyActivityReports().add(newActivityReport);
					totalSolution.getActivityReportManager().addItem(newActivityReport);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				loginDealer.getActivityReportList();
				break;
			case 3:
				System.out.println("검색할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					ActivityReport activityReport = loginDealer.getActivityReportItem(id);
					activityReport.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("수정할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				break;
			case 5:
				System.out.println("삭제할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginDealer.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					loginDealer.deleteActivityReportItem(id);
					totalSolution.getActivityReportManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				return;
			}
		}
	}

	// 이거 해야됨
	private static void employeeManagerByAdmin(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Admin loginAdmin = (Admin) loginUser;
		while (true) {
			System.out.println("\n#딜러 관리");
			System.out.println(
					"[1] 딜러 생성     [2] 딜러 전체 조회     [3] 딜러 상세 조회     [4] 딜러 정보 수정     [5] 딜러 정보 삭제     [6] 나가기");
			System.out.print("[" + loginAdmin.getRole().getName() + "] >");
			cmd = Integer.parseInt(dataInput.readLine());

			switch (cmd) {
			case 1: // 딜러 생성
				totalSolution.getActivityReportManager().getList();
				break;
			case 2: // 딜러 전체 조회
				System.out.println("검색할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					ActivityReport activityReport = totalSolution.getActivityReportManager().getItem(id);
					activityReport.printInfo();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // 딜러 상세 조회
				System.out.println("수정할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				break;
			case 4: // 딜러 정보 수정
				System.out.println("삭제할 활동 계획의 id를 입력해주세요.");
				System.out.print("[" + loginAdmin.getRole().getName() + "] >");
				id = Integer.parseInt(dataInput.readLine());

				try {
					totalSolution.getActivityReportManager().deleteItem(id);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5: // 딜러 정보 삭제
				return;
			}
		}
	}

	private static Employee login() throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		System.out.println("[로그인] id와 이름을 입력해주세요.");
		System.out.print("[id] >");
		int id = Integer.parseInt(dataInput.readLine());
		System.out.print("[이름] >");
		String name = dataInput.readLine();

		Employee loginUser = null;
		try {
			loginUser = totalSolution.login(id, name);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return loginUser;
	}

	private static void logout() {
		totalSolution.logout();
	}

	private static boolean isAdmin(Employee loginUser) {
		return loginUser.getRole() == Role.ADMIN;
	}

}
