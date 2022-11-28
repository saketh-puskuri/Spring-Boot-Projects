package com.example.demo;

public class Customers {
	private int cid;
	private String cname;
	private String ccourse;
	public Customers() {
		
	}
	public Customers(int cid) {
		this.cid=cid;
	}
	
	public Customers(int cid, String cname, String ccourse) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ccourse = ccourse;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcourse() {
		return ccourse;
	}
	public void setCcourse(String ccourse) {
		this.ccourse = ccourse;
	}
	@Override
	public String toString() {
		return "Customers [cid=" + cid + ", cname=" + cname + ", ccourse=" + ccourse + "]";
	}
	
	
}
