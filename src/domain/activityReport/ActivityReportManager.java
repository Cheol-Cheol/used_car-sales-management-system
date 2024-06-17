package domain.activityReport;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import domain.common.Manager;

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
	public Optional<ActivityReport> getItem(int id) {
		return activityReports.stream().filter(el -> el.getActivityReportId() == id).findFirst();
	}

	@Override
	public void deleteItem(int id) {
		ActivityReport activityReport = activityReports.stream().filter(el -> el.getActivityReportId() == id)
				.findFirst().orElseThrow(() -> new NoSuchElementException("존재하지 않는 Id입니다."));
		activityReports.remove(activityReport);
	}

}
