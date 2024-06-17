import java.io.IOException;
import java.util.NoSuchElementException;

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

		// 로그인
		Employee loginUser = null;
		while (loginUser == null) {
			loginUser = login();
		}

		while (true) {
			// 안내창
			System.out.println("[1] 고객 관리     [2] 차량 관리     [3] 판매 관리     [4] 활동 관리     [5] 로그아웃");
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
				break;
			case 5:
				logout();
				login();
				break;
			}
		}

	}

	// 수정 기능 해야됨
	private static void customerManagerByAdmin(Employee loginUser) throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		int cmd;
		int id;
		Admin loginAdmin = (Admin) loginUser;
		while (true) {
			System.out.println("-------------------------[고객 관리]-------------------------");
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
					System.out.println(customer);
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
			System.out.println("-------------------------[고객 관리]-------------------------");
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
					System.out.println(customer);
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

	}

	private static void carManagerByDealer(Employee loginUser) throws NumberFormatException, IOException {

	}

	private static Employee login() throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		System.out.println("로그인할 id와 이름을 입력해주세요.");
		System.out.print("id >");
		int id = Integer.parseInt(dataInput.readLine());
		System.out.print("이름 >");
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
