package com.mycompany.myapp.dto;

import java.util.Date;

public class IstInventory {//��� ���
	
	private String ist_number;//���(�α���ID)
	private String ist_userid;//���ID(SEQ)
	private int ist_divisid;//������̸�
	private Date ist_pday;//�μ�ID(SEQ)
	private Date ist_sday;//��åID(SEQ)
	private int ist_quantity;//����ID(SEQ)
	private String ist_remark;//�ּ�
	private String ist_dbquery;//�����
	private String soft_del;//��뱸��ID(SEQ)
	
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
