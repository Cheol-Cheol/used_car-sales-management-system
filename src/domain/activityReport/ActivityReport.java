package domain.activityReport;

import domain.common.BaseObject;
import domain.common.constants.ActivityType;
import domain.common.constants.ExecutionStatus;
import domain.employee.Dealer;

public class ActivityReport extends BaseObject {

	private static int activityUID = 1;

	private int activityId;
	private Dealer dealer;
	private ActivityType activityType;
	private ExecutionStatus executionStatus;
	private String content;
	private String memo;

	public ActivityReport(Dealer dealer, String content, String memo) {
		activityId = activityUID++;
		activityType = ActivityType.EMPTY;
		executionStatus = ExecutionStatus.INCOMPLETE;

		this.dealer = dealer;
		this.content = content;
		this.memo = memo;
	}

	public int getActivityId() {
		return activityId;
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

	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
		return String.format("[%d] %-5s %-5s %-5s %-30s %-30s", getActivityId(), getDealer().getName(),
				getActivityType().name(), getExecutionStatus().name(), getContent(), getMemo());
	}

}
