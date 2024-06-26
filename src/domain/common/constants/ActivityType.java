package domain.common.constants;

public enum ActivityType {

	CALL("전화"), VISIT("방문"), EMPTY("미정");

	private final String type;

	private ActivityType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
