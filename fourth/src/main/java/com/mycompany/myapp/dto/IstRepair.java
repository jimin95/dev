package com.mycompany.myapp.dto;

import java.util.Date;

public class IstRepair {
	
	private int ist_repairid;//수리ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private Date ist_appliday;//신청일
	private String ist_symptom;//증상
	private String ist_cooper;//수리업체명
	private int ist_repastatus;//수리상태ID(SEQ)
	private int ist_price;//수리가격
	private int ist_totalprice;//월수리총액
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	public int getIst_repairid() {
		return ist_repairid;
	}
	public void setIst_repairid(int ist_repairid) {
		this.ist_repairid = ist_repairid;
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
	public String getIst_symptom() {
		return ist_symptom;
	}
	public void setIst_symptom(String ist_symptom) {
		this.ist_symptom = ist_symptom;
	}
	public String getIst_cooper() {
		return ist_cooper;
	}
	public void setIst_cooper(String ist_cooper) {
		this.ist_cooper = ist_cooper;
	}
	public int getIst_repastatus() {
		return ist_repastatus;
	}
	public void setIst_repastatus(int ist_repastatus) {
		this.ist_repastatus = ist_repastatus;
	}
	public int getIst_price() {
		return ist_price;
	}
	public void setIst_price(int ist_price) {
		this.ist_price = ist_price;
	}
	public int getIst_totalprice() {
		return ist_totalprice;
	}
	public void setIst_totalprice(int ist_totalprice) {
		this.ist_totalprice = ist_totalprice;
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
