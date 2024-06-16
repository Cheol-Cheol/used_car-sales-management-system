import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.employee.Dealer;
import domain.employee.Employee;
import domain.employee.EmployeeManager;

public class Runner {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TotalSolution totalSolution = new TotalSolution();

		Employee d1 = new Dealer("송동호", "01033331234");
		Employee d2 = new Dealer("박동호", "01033331234");
		Employee d3 = new Dealer("최동호", "01033331234");
		Employee d4 = new Dealer("황동호", "01033331234");
		Employee d5 = new Dealer("마동호", "01033331234");

		totalSolution.getEmployeeManager().addEmployee(d1);
		totalSolution.getEmployeeManager().addEmployee(d2);
		totalSolution.getEmployeeManager().addEmployee(d3);
		totalSolution.getEmployeeManager().addEmployee(d4);
		totalSolution.getEmployeeManager().addEmployee(d5);
		
		totalSolution.getEmployeeManager().getList();
	}

}
