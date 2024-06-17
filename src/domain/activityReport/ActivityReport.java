package domain.activityReport;

import domain.common.BaseObject;
import domain.common.constants.ActivityType;
import domain.common.constants.ExecutionStatus;
import domain.employee.Dealer;

public class ActivityReport extends BaseObject {

	private static int activityReportUID = 1;

	private int activityReportId;
	private Dealer dealer;
	private ActivityType activityType;
	private ExecutionStatus executionStatus;
	private String content;
	private String memo;

	public ActivityReport(Dealer dealer, String content, String memo) {
		activityReportId = activityReportUID++;
		activityType = ActivityType.EMPTY;
		executionStatus = ExecutionStatus.INCOMPLETE;

		this.dealer = dealer;
		this.content = content;
		this.memo = memo;
	}

	public int getActivityReportId() {
		return activityReportId;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public ExecutionStatus getExecutionStatus() {
		return executionStatus;
	}

	public String getContent() {
		return content;
	}

	public String getMemo() {
		return memo;
	}

	public void setActivityReportId(int activityId) {
		this.activityReportId = activityReportId;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public void setExecutionStatus(ExecutionStatus executionStatus) {
		this.executionStatus = executionStatus;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return String.format("[%d] %-5s %-5s %-5s %-30s %-30s", getActivityReportId(), getDealer().getName(),
				getActivityType().name(), getExecutionStatus().name(), getContent(), getMemo());
	}

}
