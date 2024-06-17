package domain.activityReport;

import domain.common.BaseObject;
import domain.common.constants.ActivityType;
import domain.common.constants.ExecutionStatus;
import domain.customer.Customer;
import domain.employee.Dealer;

public class ActivityReport extends BaseObject {

	private static int activityReportUID = 1;

	private int activityReportId;
	private Dealer dealer;
	private Customer customer;
	private ActivityType activityType;
	private ExecutionStatus executionStatus;
	private String content;
	private String memo;

	public ActivityReport(Dealer dealer, Customer customer, String content, String memo) {
		activityReportId = activityReportUID++;
		activityType = ActivityType.EMPTY;
		executionStatus = ExecutionStatus.INCOMPLETE;

		this.dealer = dealer;
		this.customer = customer;
		this.content = content;
		this.memo = memo;
	}

	public Customer getCustomer() {
		return customer;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public void printInfo() {
		System.out.println("id: " + "[" + getActivityReportId() + "]");
		System.out.println("활동일자: " + getCreatedAt());
		System.out.println("직원명: " + getDealer().getName());
		System.out.println("고객명: " + getCustomer().getName());
		System.out.println("활동형태: " + getActivityType().getType());
		System.out.println("활동내용: " + getContent());
		System.out.println("계획메모: " + getMemo());
		System.out.println("수정일자: " + getUpdatedAt());
		System.out.println("실행여부: " + getExecutionStatus().getName());
		System.out.println("-----------------------------------------------------------------------------------");
	}

}
