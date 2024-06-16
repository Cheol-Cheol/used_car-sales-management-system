package domain.common.constants;

public enum ExecutionStatus {

	COMPLETE("완료"), WRITE_RESULTS("결과작성"), INCOMPLETE("미완료");

	private final String name;

	private ExecutionStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
