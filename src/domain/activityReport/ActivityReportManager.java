package domain.activityReport;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.common.Manager;
import domain.employee.Employee;

public class ActivityReportManager implements Manager<ActivityReport> {

	private final List<ActivityReport> activityReports;

	public ActivityReportManager() {
		activityReports = new ArrayList();
	}

	@Override
	public void addItem(ActivityReport item) {
		activityReports.add(item);
	}

	@Override
	public void getList() {
		activityReports.stream().forEach(System.out::println);
	}

	@Override
	public void getItem(int id) {
		activityReports.stream().filter(el -> el.getActivityReportId() == id).forEach(System.out::println);
	}

	@Override
	public void deleteItem(int id) {
		ActivityReport activityReport = activityReports.stream().filter(el -> el.getActivityReportId() == id)
				.findFirst().orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		activityReports.remove(activityReport);
	}

}
