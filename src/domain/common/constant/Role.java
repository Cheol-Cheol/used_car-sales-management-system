package domain.common.constant;

public enum Role {

	ADMIN("관리자"), DEALER("딜러");

	private final String name;

	private Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
