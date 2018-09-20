package com.java1234.entity;

import java.util.Date;

/**
 * ?????????
 * @author Administrator
 *
 */
public class CustomerLoss {

	private Integer id; // ???
	private String cusNo; // ??????
	private String cusName; // ???????
	private String cusManager; // ???????
	private Date lastOrderTime; // ??????????
	private Date confirmLossTime; // ??????????
	private Integer state; // ?? 0 ?????? 1 ??????
	private String lossReason; // ??????
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	public String getCusManager() {
		return cusManager;
	}
	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}
	public Date getLastOrderTime() {
		return lastOrderTime;
	}
	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}
	
	public Date getConfirmLossTime() {
		return confirmLossTime;
	}
	public void setConfirmLossTime(Date confirmLossTime) {
		this.confirmLossTime = confirmLossTime;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getLossReason() {
		return lossReason;
	}
	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
	}
	
	
}
