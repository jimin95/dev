package com.mycompany.myapp.dto;

import java.util.Date;

public class IstPurchase {//장비 구매
	
	private int ist_purchid;//구매ID(SEQ)
	private int ist_divisid;//장비ID(SEQ)
	private String ist_userid;//사번
	private String ist_offer;//기안자
	private Date ist_ofday;//기안일
	private String ist_usage;//용도
	private Date ist_oderday;//발주일
	private Date ist_wareday;//입고일
	private Date ist_sendday;//지급일
	private int ist_purstatus;//상태ID(SEQ)
	private int ist_quantity;//수량
	private int ist_unitprice;//단가
	private int ist_divisprice;//장비종류합계액
	private int ist_totalprice;//월 구매 총액
	private String soft_del;//소프트딜리트
	public int getIst_purchid() {
		return ist_purchid;
	}
	public void setIst_purchid(int ist_purchid) {
		this.ist_purchid = ist_purchid;
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
	public String getIst_offer() {
		return ist_offer;
	}
	public void setIst_offer(String ist_offer) {
		this.ist_offer = ist_offer;
	}
	public Date getIst_ofday() {
		return ist_ofday;
	}
	public void setIst_ofday(Date ist_ofday) {
		this.ist_ofday = ist_ofday;
	}
	public String getIst_usage() {
		return ist_usage;
	}
	public void setIst_usage(String ist_usage) {
		this.ist_usage = ist_usage;
	}
	public Date getIst_oderday() {
		return ist_oderday;
	}
	public void setIst_oderday(Date ist_oderday) {
		this.ist_oderday = ist_oderday;
	}
	public Date getIst_wareday() {
		return ist_wareday;
	}
	public void setIst_wareday(Date ist_wareday) {
		this.ist_wareday = ist_wareday;
	}
	public Date getIst_sendday() {
		return ist_sendday;
	}
	public void setIst_sendday(Date ist_sendday) {
		this.ist_sendday = ist_sendday;
	}
	public int getIst_purstatus() {
		return ist_purstatus;
	}
	public void setIst_purstatus(int ist_purstatus) {
		this.ist_purstatus = ist_purstatus;
	}
	public int getIst_quantity() {
		return ist_quantity;
	}
	public void setIst_quantity(int ist_quantity) {
		this.ist_quantity = ist_quantity;
	}
	public int getIst_unitprice() {
		return ist_unitprice;
	}
	public void setIst_unitprice(int ist_unitprice) {
		this.ist_unitprice = ist_unitprice;
	}
	public int getIst_divisprice() {
		return ist_divisprice;
	}
	public void setIst_divisprice(int ist_divisprice) {
		this.ist_divisprice = ist_divisprice;
	}
	public int getIst_totalprice() {
		return ist_totalprice;
	}
	public void setIst_totalprice(int ist_totalprice) {
		this.ist_totalprice = ist_totalprice;
	}
	public String getSoft_del() {
		return soft_del;
	}
	public void setSoft_del(String soft_del) {
		this.soft_del = soft_del;
	}
	
	
	
	
}
