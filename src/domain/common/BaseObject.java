package domain.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseObject {

	private String createdAt; // 생성날짜
	private String updatedAt; // 수정날짜

	public BaseObject() {
		initCreatedAt();
		initUpdatedAt();
	}

	private void initCreatedAt() {
		this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	private void initUpdatedAt() {
		this.updatedAt = "";
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
