package dto;

public class TTHachToan {
	private Integer id;
	private String bds;
	private String accNum;
	private String tellerId;
	
	public TTHachToan() {
		super();
	}
	
	public TTHachToan(Integer i, String bds, String accNum, String tellerId) {
		super();
		this.id = i;
		this.bds = bds;
		this.accNum = accNum;
		this.tellerId = tellerId;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBds() {
		return bds;
	}
	public void setBds(String bds) {
		this.bds = bds;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getTellerId() {
		return tellerId;
	}
	public void setTellerId(String tellerId) {
		this.tellerId = tellerId;
	}
	
	
	
}
