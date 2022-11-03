package org.kosta.udonmarket.model;

public class MarketVO {
	private String id;
	private String marketName;
	private String marketAddress;
	private String marketTel;
	private String info;
	private String item;
	private String marketNo;
	
	public MarketVO() {
		super();
	}

	public MarketVO(String id, String marketName, String marketAddress, String marketTel, String info, String item,
			String marketNo) {
		super();
		this.id = id;
		this.marketName = marketName;
		this.marketAddress = marketAddress;
		this.marketTel = marketTel;
		this.info = info;
		this.item = item;
		this.marketNo = marketNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketAddress() {
		return marketAddress;
	}

	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}

	public String getMarketTel() {
		return marketTel;
	}

	public void setMarketTel(String marketTel) {
		this.marketTel = marketTel;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMarketNo() {
		return marketNo;
	}

	public void setMarketNo(String marketNo) {
		this.marketNo = marketNo;
	}

	@Override
	public String toString() {
		return "MarketVO [id=" + id + ", marketName=" + marketName + ", marketAddress=" + marketAddress + ", marketTel="
				+ marketTel + ", info=" + info + ", item=" + item + ", marketNo=" + marketNo + "]";
	}
	
}
