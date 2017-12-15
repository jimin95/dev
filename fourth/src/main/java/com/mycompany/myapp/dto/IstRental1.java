package com.mycompany.myapp.dto;

import java.util.Date;

public class IstRental1 {//장비 활용
	
	private int ist_rental1id;//황용ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private Date ist_appliday;//결제일
	private String ist_usage;//용도
	private String ist_remark;//비고
	private String soft_del;//소프트딜리트
	
	public int getIst_rental1id() {
		return ist_rental1id;
	}
	public void setIst_rental1id(int ist_rental1id) {
		this.ist_rental1id = ist_rental1id;
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
	public String getIst_usage() {
		return ist_usage;
	}
	public void setIst_usage(String ist_usage) {
		this.ist_usage = ist_usage;
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
