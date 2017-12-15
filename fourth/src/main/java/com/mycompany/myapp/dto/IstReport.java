package com.mycompany.myapp.dto;

import java.util.Date;

public class IstReport {//장비 월말 보고서
	
	private int ist_reportid;//보고서ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private Date ist_calculday;//계산일
	private Date ist_appliday;//신청일
	private String ist_supply;//소모품명
	private String ist_cooper;//수리업체명
	private int ist_reporstatus;//보고서상태ID(SEQ)
	private int ist_quantity;//수량
	private int ist_price;//합계액
	private int ist_totalprice;//월 총액
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	
	public int getIst_reportid() {
		return ist_reportid;
	}
	public void setIst_reportid(int ist_reportid) {
		this.ist_reportid = ist_reportid;
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
	public Date getIst_calculday() {
		return ist_calculday;
	}
	public void setIst_calculday(Date ist_calculday) {
		this.ist_calculday = ist_calculday;
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
	public String getIst_cooper() {
		return ist_cooper;
	}
	public void setIst_cooper(String ist_cooper) {
		this.ist_cooper = ist_cooper;
	}
	public int getIst_reporstatus() {
		return ist_reporstatus;
	}
	public void setIst_reporstatus(int ist_reporstatus) {
		this.ist_reporstatus = ist_reporstatus;
	}
	public int getIst_quantity() {
		return ist_quantity;
	}
	public void setIst_quantity(int ist_quantity) {
		this.ist_quantity = ist_quantity;
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
