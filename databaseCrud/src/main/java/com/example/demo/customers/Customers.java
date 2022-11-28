package com.example.demo.customers;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
	@Id
	private int cid;
	private String cname;
	private String ccourse;
//	public Customers() {
//		
//	}
//	public Customers(int cid) {
//		this.cid=cid;
//	}
//	
//	public Customers(int cid, String cname, String ccourse) {
//		super();
//		this.cid = cid;
//		this.cname = cname;
//		this.ccourse = ccourse;
//	}
//	public int getCid() {
//		return cid;
//	}
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
//	public String getCname() {
//		return cname;
//	}
//	public void setCname(String cname) {
//		this.cname = cname;
//	}
//	public String getCcourse() {
//		return ccourse;
//	}
//	public void setCcourse(String ccourse) {
//		this.ccourse = ccourse;
//	}
//	@Override
//	public String toString() {
//		return "Customers [cid=" + cid + ", cname=" + cname + ", ccourse=" + ccourse + "]";
//	}
	
	
}
