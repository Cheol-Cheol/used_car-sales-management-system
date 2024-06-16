package domain.common.constant;

public enum CustomerType {

	PERSONAL("개인"), CORPORATION("법인");

	private final String type;

	private CustomerType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
