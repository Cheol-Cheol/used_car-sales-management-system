package domain.common.constant;

public enum PurchaseStatus {

	IN_STOCK("구매가능"), OUT_OF_STOCK("품절");

	private final String name;

	private PurchaseStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
