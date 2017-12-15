package com.mycompany.myapp.dto;

import java.util.Date;

public class IstSupplies {//장비 소모품
	
	private int ist_supplid;//소모품ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private Date ist_appliday;//신청일
	private String ist_supply;//소모품명
	private int ist_quantity;//수량
	private int ist_suppstatus;//소모품상태ID(SEQ)
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	public int getIst_supplid() {
		return ist_supplid;
	}
	public void setIst_supplid(int ist_supplid) {
		this.ist_supplid = ist_supplid;
	}
	public int getIst_divisid() {
		return ist_divisid;
	}
	public void setIst_divisid(int ist_divisid) {
		this.ist_divisid = ist_divisid;
	}
	public String getIst_userid() {
		return ist_userid;
	}
	public void setIst_userid(String ist_userid) {
		this.ist_userid = ist_userid;
	}
	public Date getIst_appliday() {
		return ist_appliday;
	}
	public void setIst_appliday(Date ist_appliday) {
		this.ist_appliday = ist_appliday;
	}
	public String getIst_supply() {
		return ist_supply;
	}
	public void setIst_supply(String ist_supply) {
		this.ist_supply = ist_supply;
	}
	public int getIst_quantity() {
		return ist_quantity;
	}
	public void setIst_quantity(int ist_quantity) {
		this.ist_quantity = ist_quantity;
	}
	public int getIst_suppstatus() {
		return ist_suppstatus;
	}
	public void setIst_suppstatus(int ist_suppstatus) {
		this.ist_suppstatus = ist_suppstatus;
	}
	public String getIst_remark() {
		return ist_remark;
	}
	public void setIst_remark(String ist_remark) {
		this.ist_remark = ist_remark;
	}
	public String getSoft_del() {
		return soft_del;
	}
	public void setSoft_del(String soft_del) {
		this.soft_del = soft_del;
	}
	
	
	
	
}
