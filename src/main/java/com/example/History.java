package com.example;

import java.sql.Connection;

public class History {
	private String stockName,higher;
	private Double nse,bse,diff;
	private String user,dt;
	OracleConn Oconn= new OracleConn();
	Connection conn;
	
	public void setall(String user,String stockName,Double nse,Double bse,String higher,Double diff,String dt) {
		System.out.println("setallll**/////**..");
		this.stockName = stockName;
		this.nse = nse;
		this.bse=bse;
		this.user = user;
		this.diff=diff;
		this.dt=dt;
		this.higher=higher;
	}
	
	public void establish()
	{
		conn=Oconn.getConnection();
	}
	
	public void displayHistory()
	{
		Oconn.displayHistory();
	}
	
	public void sethistory()
	{
		System.out.println("setHist****..");
		Oconn.saveHistory(conn,user,stockName, nse, bse,higher,diff,dt);
	}
	
	
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getHigher() {
		return higher;
	}
	public void setHigher(String higher) {
		this.higher = higher;
	}
	public Double getNse() {
		return nse;
	}
	public void setNse(Double nse) {
		this.nse = nse;
	}
	public Double getBse() {
		return bse;
	}
	public void setBse(Double bse) {
		this.bse = bse;
	}
	public Double getDiff() {
		return diff;
	}
	public void setDiff(Double diff) {
		this.diff = diff;
	}
	public String getUsername() {
		return user;
	}
	public void setUsername(String user) {
		this.user = user;
	}

}
