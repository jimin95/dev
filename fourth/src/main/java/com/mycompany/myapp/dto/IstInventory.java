package com.mycompany.myapp.dto;

import java.util.Date;

public class IstInventory {//장비 재고
	
	private String ist_number;//사번(로그인ID)
	private String ist_userid;//장비ID(SEQ)
	private int ist_divisid;//사용자이름
	private Date ist_pday;//부서ID(SEQ)
	private Date ist_sday;//직책ID(SEQ)
	private int ist_quantity;//지역ID(SEQ)
	private String ist_remark;//주소
	private String ist_dbquery;//퇴사일
	private String soft_del;//사용구분ID(SEQ)
	
	public String getIst_number() {
		return ist_number;
	}
	public void setIst_number(String ist_number) {
		this.ist_number = ist_number;
	}
	public String getIst_userid() {
		return ist_userid;
	}
	public void setIst_userid(String ist_userid) {
		this.ist_userid = ist_userid;
	}
	public int getIst_divisid() {
		return ist_divisid;
	}
	public void setIst_divisid(int ist_divisid) {
		this.ist_divisid = ist_divisid;
	}
	public Date getIst_pday() {
		return ist_pday;
	}
	public void setIst_pday(Date ist_pday) {
		this.ist_pday = ist_pday;
	}
	public Date getIst_sday() {
		return ist_sday;
	}
	public void setIst_sday(Date ist_sday) {
		this.ist_sday = ist_sday;
	}
	public int getIst_quantity() {
		return ist_quantity;
	}
	public void setIst_quantity(int ist_quantity) {
		this.ist_quantity = ist_quantity;
	}
	public String getIst_remark() {
		return ist_remark;
	}
	public void setIst_remark(String ist_remark) {
		this.ist_remark = ist_remark;
	}
	public String getIst_dbquery() {
		return ist_dbquery;
	}
	public void setIst_dbquery(String ist_dbquery) {
		this.ist_dbquery = ist_dbquery;
	}
	public String getSoft_del() {
		return soft_del;
	}
	public void setSoft_del(String soft_del) {
		this.soft_del = soft_del;
	}

	
}
