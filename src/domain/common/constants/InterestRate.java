package domain.common.constants;

public enum InterestRate {

	THREEMONTH("3개월"), SIXMONTH("6개월"), ONEYEAR("1년"), OVERONEYEAR("1년이상");

	private final String date;

	private InterestRate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

}