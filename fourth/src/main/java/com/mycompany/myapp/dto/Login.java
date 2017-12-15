package com.mycompany.myapp.dto;


public class Login {//로그인
	
	private String ist_userid;//로그인 ID
	private String ist_password;//로그인 PW
	private String ist_email;//로그인 EMAIL
	private String ist_tel;//로그인 TEL
	
	public String getIst_userid() {
		return ist_userid;
	}
	public void setIst_userid(String ist_userid) {
		this.ist_userid = ist_userid;
	}
	public String getIst_password() {
		return ist_password;
	}
	public void setIst_password(String ist_password) {
		this.ist_password = ist_password;
	}
	public String getIst_email() {
		return ist_email;
	}
	public void setIst_email(String ist_email) {
		this.ist_email = ist_email;
	}
	public String getIst_tel() {
		return ist_tel;
	}
	public void setIst_tel(String ist_tel) {
		this.ist_tel = ist_tel;
	}
	
	
}
