package domain.common.constants;

public enum ConfirmStatus {

	WAIT("결재대기"), READY("결재가능"), COMPLETE("결재완료");

	private final String name;

	private ConfirmStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
