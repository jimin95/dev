package com.mycompany.myapp.dto;

import java.util.Date;

public class IstUser {
	
	private String ist_userid;//���(�α���ID)
	private int ist_divisid;//���ID(SEQ)
	private String ist_username;//������̸�
	private int ist_dpt;//�μ�ID(SEQ)
	private int ist_position;//��åID(SEQ)
	private int ist_area;//����ID(SEQ)
	private String ist_address;//�ּ�
	private Date ist_retire;//�����
	private int ist_usage;//��뱸��ID(SEQ)
	private String ist_remark;//���
	private String soft_del;//����Ʈ����Ʈ
	
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
	public String getIst_username() {
		return ist_username;
	}
	public void setIst_username(String ist_username) {
		this.ist_username = ist_username;
	}
	public int getIst_dpt() {
		return ist_dpt;
	}
	public void setIst_dpt(int ist_dpt) {
		this.ist_dpt = ist_dpt;
	}
	public int getIst_position() {
		return ist_position;
	}
	public void setIst_position(int ist_position) {
		this.ist_position = ist_position;
	}
	public int getIst_area() {
		return ist_area;
	}
	public void setIst_area(int ist_area) {
		this.ist_area = ist_area;
	}
	public String getIst_address() {
		return ist_address;
	}
	public void setIst_address(String ist_address) {
		this.ist_address = ist_address;
	}
	public Date getIst_retire() {
		return ist_retire;
	}
	public void setIst_retire(Date ist_retire) {
		this.ist_retire = ist_retire;
	}
	public int getIst_usage() {
		return ist_usage;
	}
	public void setIst_usage(int ist_usage) {
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
