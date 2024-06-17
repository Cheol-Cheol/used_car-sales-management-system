import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import domain.employee.Dealer;
import domain.employee.Employee;
import domain.employee.EmployeeManager;
import utils.DataInput;

public class Runner {

	private static TotalSolution totalSolution = new TotalSolution();

	public static void main(String[] args) throws IOException {

		// 로그인
		login();

		// 딜러일 때

		// 관리자일 때

		// 차량

		// 고객

		// 판매

		// 활동일지

	}

	private static void login() throws NumberFormatException, IOException {
		DataInput dataInput = DataInput.getInstance();

		System.out.println("로그인할 id와 이름을 입력해주세요.");
		System.out.print("id >");
		int id = Integer.parseInt(dataInput.readLine());
		System.out.print("이름 >");
		String name = dataInput.readLine();

		try {
			totalSolution.login(id, name);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void logout() {
		totalSolution.logout();
	}
}
