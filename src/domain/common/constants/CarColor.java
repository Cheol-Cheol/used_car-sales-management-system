package domain.common.constants;

public enum CarColor {

	BLACK("검은색"), WHITE("흰색"), RED("빨간색"), BLUE("파란색"), YELLOW("노란색");

	private final String name;

	private CarColor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
