package org.kosta.udonmarket.model;

public class CheckHeartVO {
	private String message;
	private long totalCount;
	
	public CheckHeartVO() {
		super();
	}

	public CheckHeartVO(String message, long totalCount) {
		super();
		this.message = message;
		this.totalCount = totalCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "CheckHeartVO [message=" + message + ", totalCount=" + totalCount + "]";
	}
	
}
