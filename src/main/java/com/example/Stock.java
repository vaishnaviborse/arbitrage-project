package com.example;

public class Stock {

	//static Integer count=0;
	private String name;
	private Double nseValue;
	private Double bseValue;
	private Double diff;
	private String dt;
	private String higher;

	public String getHigher() {
		return higher;
	}

	public void setHigher(String higher) {
		this.higher = higher;
	}

	public Double getDiff() {
		return diff;
	}

	public void setDiff(Double diff) {
		this.diff = diff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getNseValue() {
		return nseValue;
	}

	public void setNseValue(Double nseValue) {
		this.nseValue = nseValue;
	}

	public Double getBseValue() {
		return bseValue;
	}

	public void setBseValue(Double bseValue) {
		this.bseValue = bseValue;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
	
	public Stock(String name, String nseValue, String bseValue,String d_t) {
		super();
		this.name = name;
		nseValue = nseValue.replaceAll(",", "");
		bseValue = bseValue.replaceAll(",", "");
		this.nseValue = Double.parseDouble(nseValue);
		this.bseValue = Double.parseDouble(bseValue);
		d_t=d_t.replaceAll("T", " ");
		this.dt=d_t.replaceAll("Z","");
	}
	
}
