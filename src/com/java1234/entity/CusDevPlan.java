package com.java1234.entity;

import java.util.Date;

/**
 * ?????????????
 * @author Administrator
 *
 */
public class CusDevPlan {

	private Integer id; // ???
	private SaleChance saleChance; // ???????
	private String planItem; // ?????
	private Date planDate; // ???????
	private String exeAffect; // ???งน??
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SaleChance getSaleChance() {
		return saleChance;
	}
	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}
	public String getPlanItem() {
		return planItem;
	}
	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getExeAffect() {
		return exeAffect;
	}
	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}
	
	
}
