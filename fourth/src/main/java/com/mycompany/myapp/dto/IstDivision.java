package com.mycompany.myapp.dto;

public class IstDivision {//장비 구분
	
	private int ist_divisid;//장비ID(SEQ)
	private int ist_category;//장비구분ID(SEQ)
	private int ist_model;//모델구분ID(SEQ)
	private String ist_name;//장비번호
	private String ist_serial;//시리얼번호
	private String ist_mac;//맥주소
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	public int getIst_divisid() {
		return ist_divisid;
	}
	public void setIst_divisid(int ist_divisid) {
		this.ist_divisid = ist_divisid;
	}
	public int getIst_category() {
		return ist_category;
	}
	public void setIst_category(int ist_category) {
		this.ist_category = ist_category;
	}
	public int getIst_model() {
		return ist_model;
	}
	public void setIst_model(int ist_model) {
		this.ist_model = ist_model;
	}
	public String getIst_name() {
		return ist_name;
	}
	public void setIst_name(String ist_name) {
		this.ist_name = ist_name;
	}
	public String getIst_serial() {
		return ist_serial;
	}
	public void setIst_serial(String ist_serial) {
		this.ist_serial = ist_serial;
	}
	public String getIst_mac() {
		return ist_mac;
	}
	public void setIst_mac(String ist_mac) {
		this.ist_mac = ist_mac;
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
