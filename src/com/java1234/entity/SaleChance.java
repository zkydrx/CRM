package com.java1234.entity;

import java.util.Date;


/**
 * ??????????
 * @author Administrator
 *
 */
public class SaleChance {

	private Integer id; // ???
	private String chanceSource; // ???????
	private String customerName; // ???????
	private int cgjl; // ???????
	private String overView; // ???
	private String linkMan; // ?????
	private String linkPhone; // ????´Â
	private String description; // ????????
	private String createMan; // ?????? 
	private Date createTime; // ???????
	private String assignMan; // ?????
	private Date assignTime; // ??????
	
	private Integer state; // ?????? 0 ¦Ä???? 1 ?????
	private Integer devResult; // ????????? 0 ¦Ä???? 1 ?????? 2 ??????? 3 ???????
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getChanceSource() {
		return chanceSource;
	}
	public void setChanceSource(String chanceSource) {
		this.chanceSource = chanceSource;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCgjl() {
		return cgjl;
	}
	public void setCgjl(int cgjl) {
		this.cgjl = cgjl;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAssignMan() {
		return assignMan;
	}
	public void setAssignMan(String assignMan) {
		this.assignMan = assignMan;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDevResult() {
		return devResult;
	}
	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}
	
	
}
