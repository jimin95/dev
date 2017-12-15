package com.mycompany.myapp.dto;

import java.util.Date;

public class IstRental2 {//장비 대여
	
	private int ist_rental2id;//대여ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private Date ist_appliday;//결제일
	private String ist_project;//프로젝트명
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	public int getIst_rental2id() {
		return ist_rental2id;
	}
	public void setIst_rental2id(int ist_rental2id) {
		this.ist_rental2id = ist_rental2id;
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
	public String getIst_project() {
		return ist_project;
	}
	public void setIst_project(String ist_project) {
		this.ist_project = ist_project;
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
